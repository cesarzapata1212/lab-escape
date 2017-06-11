package co.tide.common.asserts;

import static org.junit.Assert.assertEquals;

/**
 * Created by cesar on 6/11/17.
 */
public class MazeAssert {

    public static void assertMazesAreEqual(char[][] expected, char[][] actual) {
        assertEquals("Mazes should have the same height", expected.length, actual.length);
        assertEquals("Mazes should have the same width", expected[0].length, actual[0].length);

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                assertEquals("Position should have the same value", expected[i][j], actual[i][j]);
            }
        }
    }

}
