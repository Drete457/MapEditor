package MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Blocks {

    //memorise the width of the grid
    private int width;
    //memorise the height of the grid
    private int height;
    //memorise each rectangle
    protected Rectangle rectangle;
    //final size of each block
    protected static final int cellSize = 10;
    //memorise if the block is painted or not, for the file.
    private boolean painted;

    //initiate the variables and the rectangle of each block
    public Blocks(int width, int height) {

        this.width = width;
        this.height = height;

        //initiate the rectangle
        rectangle = new Rectangle(height * cellSize + GridDraw.padding, width * cellSize + GridDraw.padding, cellSize, cellSize);
        rectangle.draw();
    }

    //fill the rectangle
    public void fill() { rectangle.fill(); painted = true; }

    //make the rectangle return to the original color
    public void erase() {
        rectangle.delete();
        rectangle = null;
        rectangle = new Rectangle(height * cellSize + GridDraw.padding, width * cellSize + GridDraw.padding, cellSize, cellSize);
        rectangle.draw(); painted = false; }

    //ask if the rectangle is filled
    public boolean isFilled() {
        return rectangle.isFilled();
    }

    //get the Width
    public int getWidth() {
        return width;
    }

    //get the Height
    public int getHeight() {
        return height;
    }

    //set the height
    public void setHeight(int height) {
        this.height = height;
    }

    //set the width
    public void setWidth(int width) { this.width = width; }

    //write the file 1 for paint and 0 for not paint
    @Override
    public String toString() {
        if(painted) { return "1";}
        else { return "0"; }
    }

    public void disco() {
                if (painted) {
                    rectangle.setColor(Draw.colorRandom());
                    fill();
                }
    }

    public void crazyBlock() {
        rectangle.setColor(Draw.colorRandom());
        fill();
    }
}


