package sudoku.sudokugame.algo.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sudoku.sudokugame.algo.dto.MatrixDTO;
import sudoku.sudokugame.algo.model.Matrix;

@Component
public class MatrixDTOToMatrix implements Converter<MatrixDTO, Matrix> {

    @Override
    public Matrix convert(MatrixDTO matrixDTO) {
        return new Matrix(
                matrixDTO.matrixId(),
                matrixDTO.matrix()
        );
    }

}
