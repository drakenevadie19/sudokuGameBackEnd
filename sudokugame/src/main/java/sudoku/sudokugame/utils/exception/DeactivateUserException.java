package sudoku.sudokugame.utils.exception;

public class DeactivateUserException extends RuntimeException {

    public DeactivateUserException(String reason) {
        super("Cannot deactivate user: " + reason);
    }

}
