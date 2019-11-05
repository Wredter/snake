package Snake.GameObjects.Static.DataTypes;

import java.util.Objects;

public class SnakeData {
    public int xBodyPos;
    public int yBodyPos;
    public char bodySymbol;
    public int prevXBodyPos;
    public int prevYBodyPos;

    public SnakeData(int xBodyPos, int yBodyPos, char bodySymbol) {
        this.xBodyPos = xBodyPos;
        this.yBodyPos = yBodyPos;
        this.bodySymbol = bodySymbol;
    }

    public SnakeData(int xBodyPos, int yBodyPos, char bodySymbol, int prevXBodyPos, int prevYBodyPos) {
        this.xBodyPos = xBodyPos;
        this.yBodyPos = yBodyPos;
        this.bodySymbol = bodySymbol;
        this.prevXBodyPos = prevXBodyPos;
        this.prevYBodyPos = prevYBodyPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnakeData snakeData = (SnakeData) o;
        return xBodyPos == snakeData.xBodyPos &&
                yBodyPos == snakeData.yBodyPos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xBodyPos, yBodyPos);
    }
}
