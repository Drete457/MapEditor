package MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Draw extends Blocks {

    //memorise the grid
    private GridDraw grid;
    //memorise the color of the draw
    private Color color;

    //initiate the draw and the color he will use.
    public Draw(GridDraw grid) {
        super(0, 0);
        this.grid = grid;
        color = Color.GRAY;
        rectangle.setColor(color);
        fill();
    }

    //to help whit the direction
    public enum Directions {
        UP,
        DOWN,
        RIGHT,
        LEFT,
    }

    //move up
    public void moveUp() {
        if (getWidth() > 0) {
            rectangle.translate(0, -cellSize);
            setWidth(getWidth() - 1);
        }
    }

    //move down
    public void moveDown() {
        if (getWidth() < grid.getWidth() - 1) {
            rectangle.translate(0, cellSize);
            setWidth(getWidth() + 1);
        }
    }

    //move right
    public void moveRight() {
        if (getHeight() < grid.getHeight() - 1) {
            rectangle.translate(cellSize, 0);
            setHeight(getHeight() + 1);
        }
    }

    //move left
    public void moveLeft() {
        if (getHeight() > 0) {
            rectangle.translate(-cellSize, 0);
            setHeight(getHeight() - 1);
        }
    }

    public void changeColor() {
        rectangle.setColor(colorRandom());
        fill();
    }

    public static Color colorRandom() {
        int colorChoose = (int) (Math.random() * (13 - 0) + 0);
        Color color = Color.RED;
        if (colorChoose == 1) {
            color = Color.GREEN;
        }
        if (colorChoose == 2) {
            color = Color.BLUE;
        }
        if (colorChoose == 3) {
            color = Color.WHITE;
        }
        if (colorChoose == 4) {
            color = Color.LIGHT_GRAY;
        }
        if (colorChoose == 5) {
            color = Color.GRAY;
        }
        if (colorChoose == 6) {
            color = Color.DARK_GRAY;
        }
        if (colorChoose == 7) {
            color = Color.BLACK;
        }
        if (colorChoose == 8) {
            color = Color.CYAN;
        }
        if (colorChoose == 9) {
            color = Color.MAGENTA;
        }
        if (colorChoose == 10) {
            color = Color.YELLOW;
        }
        if (colorChoose == 11) {
            color = Color.PINK;
        }
        if (colorChoose == 12) {
            color = Color.ORANGE;
        }
        return color;
    }
}
