package co.tide.escape;

import java.util.Objects;

/**
 * Created by cesar on 6/11/17.
 */
public class MazePosition {

    private final int x;
    private final int y;

    public MazePosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(final Object obj) {
        try {
            MazePosition other = (MazePosition) obj;
            return this.x == other.x && this.y == other.y;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
