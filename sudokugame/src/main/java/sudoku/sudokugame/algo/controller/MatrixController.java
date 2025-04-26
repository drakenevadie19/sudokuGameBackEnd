package sudoku.sudokugame.algo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sudoku.sudokugame.algo.converter.MatrixDTOToMatrix;
import sudoku.sudokugame.algo.converter.MatrixToMatrixDTO;
import sudoku.sudokugame.algo.service.MatrixService;
import sudoku.sudokugame.utils.Result;
import sudoku.sudokugame.utils.StatusCode;

@RestController
@RequestMapping("/matrix")
public class MatrixController {

    private final MatrixService matrixService;

    private final MatrixToMatrixDTO matrixToMatrixDTO;

    private final MatrixDTOToMatrix matrixDTOToMatrix;

    public MatrixController(MatrixService matrixService, MatrixToMatrixDTO matrixToMatrixDTO, MatrixDTOToMatrix matrixDTOToMatrix) {
        this.matrixService = matrixService;
        this.matrixToMatrixDTO = matrixToMatrixDTO;
        this.matrixDTOToMatrix = matrixDTOToMatrix;
    }

    @GetMapping("/hello")
    public Result hello() {
        return new Result(true, StatusCode.SUCCESS, "Hello");
    }
}
