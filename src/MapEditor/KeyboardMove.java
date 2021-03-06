package MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardMove implements KeyboardHandler {

    //memorise the engine
    private Engine engine;
    //memorise the block draw
    private Draw draw;
    //memorise the grid
    private GridDraw grid;

    //give the variables the reference for the engine, draw and the grid
    public KeyboardMove(Engine engine, Draw draw, GridDraw grid) {
        this.engine = engine;
        this.draw = draw;
        this.grid = grid;
        setKeyboard();
    }

    //Create, instantiate and initiate the keyboard
    public void setKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        //move up
        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUp);

        //move down
        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);

        //move left
        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        //move right
        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

        //paint the block
        KeyboardEvent eventV = new KeyboardEvent();
        eventV.setKey(KeyboardEvent.KEY_V);
        eventV.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventV);

        //paint the block when pressed
        KeyboardEvent eventV2 = new KeyboardEvent();
        eventV2.setKey(KeyboardEvent.KEY_V);
        eventV2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventV2);

        //save the file
        KeyboardEvent eventC = new KeyboardEvent();
        eventC.setKey(KeyboardEvent.KEY_X);
        eventC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventC);

        //load the file
        KeyboardEvent eventS = new KeyboardEvent();
        eventS.setKey(KeyboardEvent.KEY_C);
        eventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventS);

        //clear the grid
        KeyboardEvent eventL = new KeyboardEvent();
        eventL.setKey(KeyboardEvent.KEY_Z);
        eventL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventL);

        //exit the program
        KeyboardEvent eventR = new KeyboardEvent();
        eventR.setKey(KeyboardEvent.KEY_E);
        eventR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventR);

        //change the color of the draw
        KeyboardEvent eventB = new KeyboardEvent();
        eventB.setKey(KeyboardEvent.KEY_B);
        eventB.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventB);

        //change the color of the blocks already painted
        KeyboardEvent eventN = new KeyboardEvent();
        eventN.setKey(KeyboardEvent.KEY_N);
        eventN.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventN);

        //change the color of all blocks
        KeyboardEvent eventM = new KeyboardEvent();
        eventM.setKey(KeyboardEvent.KEY_M);
        eventM.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventM);
    }

    //verify what key was pressed and call the correct methods
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int keyPressed = keyboardEvent.getKey();

        switch (keyPressed) {

            //move up
            case KeyboardEvent.KEY_UP:
                engine.moveDraw(Draw.Directions.UP);
                break;

            //move down
            case KeyboardEvent.KEY_DOWN:
                engine.moveDraw(Draw.Directions.DOWN);
                break;

            //move left
            case KeyboardEvent.KEY_LEFT:
                engine.moveDraw(Draw.Directions.LEFT);
                break;

            //move right
            case KeyboardEvent.KEY_RIGHT:
                engine.moveDraw(Draw.Directions.RIGHT);
                break;

            //paint the block
            case KeyboardEvent.KEY_V:
                if (!engine.isPainting()) {
                    engine.setPainting(true);
                    engine.paintBlock();
                } else {
                    engine.setPainting(false);
                }
                break;

            //save the grid to the file
            case KeyboardEvent.KEY_X:
                engine.save();
                break;

            //load the file to the grid
            case KeyboardEvent.KEY_C:
                engine.load();
                break;

            //clear all the grid
            case KeyboardEvent.KEY_Z:
                engine.clearGrid();
                break;

            //Exit the game
            case KeyboardEvent.KEY_E:
                System.exit(0);
                break;

            //Change the color of the draw
            case KeyboardEvent.KEY_B:
                draw.changeColor();
                break;
        }
    }

    //Disable method
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        switch (key) {
            case KeyboardEvent.KEY_V:
                if (!engine.isPainting()) {
                    engine.setPainting(true);
                    engine.paintBlock();
                } else {
                    engine.setPainting(false);
                }
                break;

            //Change the color of the blocks that are painted
            case KeyboardEvent.KEY_N:
                grid.disco();
                break;

            //Change the color of the blocks that are painted
            case KeyboardEvent.KEY_M:
                grid.crazy();
                break;
        }
    }
}

