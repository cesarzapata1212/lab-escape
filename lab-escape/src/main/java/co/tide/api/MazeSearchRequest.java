package co.tide.api;

import java.io.Serializable;

/**
 * Created by cesar on 6/12/17.
 */
public class MazeSearchRequest implements Serializable {

    private int startX;
    private int startY;
    private char[][] matrix;

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public char[][] getMatrix() {
        return matrix;
    }


}
