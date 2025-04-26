package sudoku.sudokugame.algo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sudoku.sudokugame.algo.repository.MatrixRepository;

@Service
public class MatrixService {

    @Autowired
    private final MatrixRepository matrixRepository;

    public MatrixService(MatrixRepository matrixRepository) {
        this.matrixRepository = matrixRepository;
    }
}
