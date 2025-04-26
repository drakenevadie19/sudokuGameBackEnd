package sudoku.sudokugame.algo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sudoku.sudokugame.algo.dto.MatrixDTO;
import sudoku.sudokugame.algo.model.Matrix;

@Component
public class MatrixToMatrixDTO implements Converter<Matrix, MatrixDTO> {

    @Override
    public MatrixDTO convert(Matrix matrix) {
        return new MatrixDTO(
            matrix.getMatrixId(),
            matrix.getMatrix()
        );
    }

}
