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
        if(getWidth() > 0) {
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
}
