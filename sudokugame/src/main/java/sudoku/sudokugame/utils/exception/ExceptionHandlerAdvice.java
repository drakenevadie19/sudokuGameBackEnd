package sudoku.sudokugame.utils.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.messaging.MessagingException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sudoku.sudokugame.utils.Result;
import sudoku.sudokugame.utils.StatusCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerAdvice {


  /**
   * This handles already existed object when add new object.
   *
   * @param ex
   * @return
   */

  @ExceptionHandler(ObjectAlreadyExistedException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  Result handleObjectAlreadyExistedException(Exception ex) {
    return new Result(false, StatusCode.CONFLICT, ex.getMessage());
  }


  /**
   * This handles object does not exist.
   *
   * @param ex
   * @return
   */

  @ExceptionHandler(ObjectNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  Result handleObjectNotFoundException(Exception ex) {
    return new Result(false, StatusCode.NOT_FOUND, ex.getMessage());
  }


  /**
   * This handles invalid inputs.
   *
   * @param ex
   * @return
   */
  @ExceptionHandler({MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  Result handleValidationException(MethodArgumentNotValidException ex) {
    List<ObjectError> errors = ex.getBindingResult().getAllErrors();
    Map<String, String> map = new HashMap<>(errors.size());
    errors.forEach((error) -> {
      String key = ((FieldError) error).getField();
      String val = error.getDefaultMessage();
      map.put(key, val);
    });
    return new Result(false, StatusCode.INVALID_ARGUMENT, "Provided arguments are invalid, see data for details."
        , map);
  }

  /**
   * This handles missing request body.
   *
   * @param ex
   * @return
   */

  @ExceptionHandler(DeactivateUserException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Result handleDeactivateUserException(DeactivateUserException ex) {
    return new Result(false, StatusCode.INVALID_ARGUMENT, ex.getMessage());
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Result handleMissingRequestBody(HttpMessageNotReadableException ex) {

    Throwable cause = ex.getCause();
    if (cause instanceof InvalidFormatException) {

      InvalidFormatException invalidFormatException = (InvalidFormatException) cause;

      Map<String, String> errors = new HashMap<>();
      errors.put(invalidFormatException.getPath().get(0).getFieldName(), "Invalid");

      return new Result(false, StatusCode.INVALID_ARGUMENT, "Provided arguments are invalid, see data for details.",
                        errors);
    }

    return new Result(false, StatusCode.INVALID_ARGUMENT, "Request body is missing");
  }

  /**
   * Fallback handles any unhandled exceptions.
   *
   * @param ex
   * @return
   */

  @ExceptionHandler(MessagingException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Result handleMessagingException(MessagingException ex) {
    return new Result(false, StatusCode.INTERNAL_SERVER_ERROR,
                      "An error occurred while sending email, please try again", ex.getMessage());
  }


  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  Result handleOtherException(Exception ex) {
    return new Result(false, StatusCode.INTERNAL_SERVER_ERROR, "A server internal error occurs.", ex.getMessage());
  }

}
