package co.tide.common.maze;

import java.util.List;

/**
 * Created by cesar on 6/11/17.
 */
public class MazeUtils {

    private static final char BLANK = ' ';

    public static char[][] toCharMatrix(final List<List<String>> matrix) {

        int height = matrix.size();
        int width = matrix.get(0).size();
        char[][] maze = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(matrix.get(i).get(j).isEmpty()){
                    maze[i][j] = BLANK;
                }else {
                    maze[i][j] = matrix.get(i).get(j).charAt(0);
                }
            }
        }

        return maze;
    }
}
