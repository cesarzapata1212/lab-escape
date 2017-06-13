package co.tide.api;

import java.io.Serializable;

/**
 * Created by cesar on 6/12/17.
 */
public class MazeResult implements Serializable {

    private char[][] matrix;
    private String error;

    public MazeResult(final char[][] matrix) {
        this.matrix = matrix;
        this.error = null;
    }

    public MazeResult(String error) {
        this.matrix = new char[0][0];
        this.error = error;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}
