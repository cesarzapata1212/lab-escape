package co.tide;

/**
 * Created by cesar on 6/11/17.
 */
public class Maze {

    private static final char WALL = 'O';
    private static final char FREE = ' ';
    private static final char PATH = '•';

    private final char[][] matrix;
    private MazePosition exit;

    public Maze(char[][] matrix) {
        this.matrix = matrix;

        for (int i = 0; i < matrix.length; i++) {

            int firstCol = 0;
            if (matrix[i][firstCol] == FREE) {
                exit = new MazePosition(i, 0);
                break;
            }

            int lastCol = matrix[i].length - 1;
            if (matrix[i][lastCol] == FREE) {
                exit = new MazePosition(i, lastCol);
                break;
            }

        }

        for (int j = 1; j < matrix[0].length - 1; j++) {

            int firstRow = 0;
            if (matrix[firstRow][j] == FREE) {
                exit = new MazePosition(firstRow, j);
            }

            int lastRow = 0;
            if (matrix[lastRow][j] == FREE) {
                exit = new MazePosition(lastRow, j);
            }

        }

    }

    public MazePosition getExit() {
        return exit;
    }
}
