package sudoku.sudokugame.algo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "matrix")
public class Matrix implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String matrixId;

    private String matrix;

    public Matrix(String matrixId, String matrix) {
        this.matrixId = matrixId;
        this.matrix = matrix;
    }

    public Matrix() {
    }

    public String getMatrixId() {
        return matrixId;
    }

    public void setMatrixId(String matrixId) {
        this.matrixId = matrixId;
    }

    public String getMatrix() {
        return matrix;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }
}
