package MapEditor;

public class Engine {

    //memorise the grid
    private GridDraw grid;
    //memorise the object draw
    private Draw draw;
    //memorise the keyboard
    private KeyboardMove keyboard;
    //memorise if the block is painted
    private boolean painting = false;

    //initiate the engine and the grid and  block to draw the lines
    public Engine(int width, int height) {
        grid = new GridDraw( width, height);
        draw = new Draw(grid);
        keyboard = new KeyboardMove(this, draw, grid);
    }

    //make the block painted
    public void setPainting(boolean painting) {
        this.painting = painting;
    }

    //paint the block
    public void paintBlock() {

        Blocks currentDraw = grid.getBlocks(draw.getWidth(), draw.getHeight());

        if(!currentDraw.isFilled()) {
            currentDraw.fill();
        } else {
            currentDraw.erase();
        }
    }

    //Move the draw in the correct direction
    public void moveDraw(Draw.Directions direction) {

        switch(direction) {
            case UP:
                draw.moveUp();
                break;

            case DOWN:
                draw.moveDown();
                break;

            case LEFT:
                draw.moveLeft();
                break;

            default:
                draw.moveRight();
                break;
        }

        //if paint call the method
        if(painting) {
            paintBlock();
        }
    }

    //clear the Grid
    public void clearGrid() {
        grid.clear();
    }

    //save ti tge file save the draw.
    public void save() {
                SaveLoad.writeFile(grid.toString());
    }

    //load from the file last grid saved
    public void load() { grid.stringToGrid(SaveLoad.readFile()); }

    //return if grid is painted
    public boolean isPainting() {
        return painting;
    }
}
