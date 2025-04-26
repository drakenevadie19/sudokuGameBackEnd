package sudoku.sudokugame.algo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sudoku.sudokugame.algo.model.Matrix;

@Repository
public interface MatrixRepository extends JpaRepository<Matrix, String> {

}
