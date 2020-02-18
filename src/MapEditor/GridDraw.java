package MapEditor;

public class GridDraw {

    //memorise the width of the grid
    private int width;
    //memorise the height of the grid
    private int height;
    //memorise each block
    private Blocks[][] blocks;
    //memorise the padding
    public static final int padding = 10;

    //get the width and height for the grid and initiate the array of blocks
    public GridDraw(int width, int height) {

        //give the width and memorise
        this.width = width;
        //give the height and memorise
        this.height = height;

        //initiate the blocks array
        blocks = new Blocks[width][height];

        //initiate every space in the array whit object type Blocks
        for (int widths = 0; widths < width; widths++) {
            for (int heights = 0; heights < height; heights++) {
                blocks[widths][heights] = new Blocks(widths, heights);
            }
        }
    }

    //return the Width
    public int getWidth() {
        return width;
    }

    //return Height
    public int getHeight() {
        return height;
    }

    //return the blocks
    public Blocks getBlocks(int width, int height) {
        return blocks[width][height];
    }

    //clear the grid
    public void clear() {
        for (Blocks[] first : blocks) {
            for (Blocks second : first) {
                if (second.isFilled()) {
                    second.erase();
                }
            }
        }
    }

    //print from the grid to the file
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        //save from string to the file
        for (int widths = 0; widths < width; widths++) {
            for (int heights = 0; heights < height; heights++) {
                string.append(blocks[widths][heights]);
            }
            string.append("\n");
        }
        return string.toString();
    }


    public void disco() {
        for (int widths = 0; widths < width; widths++) {
            for (int heights = 0; heights < height; heights++) {
                blocks[widths][heights].disco();
            }
        }
    }

    //string to grid
    public void stringToGrid(String stringOfNumbers) {

        int index = 0;

        //save to the file the string
        for (int widths = 0; widths < width; widths++) {
            for (int heights = 0; heights < height; heights++) {
                if(stringOfNumbers.charAt(index) == '0') {
                    blocks[widths][heights].erase();
                } else {
                    blocks[widths][heights].fill();
                }
                index++;
            }
            index++;
        }
    }
}


