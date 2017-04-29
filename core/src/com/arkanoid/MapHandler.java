package com.arkanoid;

import com.arkanoid.entities.Brick;
import com.arkanoid.entities.Wall;
import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which handles all Map functionality
 */
public class MapHandler {

    // number of max possible bricks in a row
    public int maxBricksPerRow = 13;
    // holds all bricks for current map
    public List<Brick> bricks = new ArrayList<Brick>();

    //map wall objects
    Wall wallTop;
    Wall wallLeft;
    Wall wallRight;

    // bricks
    Brick brick1;
    Brick brick2;
    Brick brick3;

    /**
     * Handles everything that is needed on start up of the map
     */
    public void initMap()
    {
        //generate Walls
        wallTop = new Wall(0, 590, 800, 10);
        wallLeft = new Wall(0, 0, 10, 600);
        wallRight = new Wall(790, 0, 10, 600);


        // generating bricks
        // TODO: refactor brick generation for map
        brick1 = new Brick(10, 300, Color.BLUE);
        brick2 = new Brick(70, 300, Color.GREEN);
        brick3 = new Brick(130, 300, Color.CYAN);
        bricks.add(brick1);
        bricks.add(brick2);
        bricks.add(brick3);
    }

    /**
     * Handles the rendering of the map
     */
    public void render()
    {
       wallTop.render();
       wallLeft.render();
       wallRight.render();

       drawBricks();

    }

    /**
     * Update everything needed for the map
     */
    public void update()
    {

    }

    /**
     * handles the drawing of bricks
     */
    public void drawBricks()
    {
        //render bricks
        for (Brick brick: bricks) {
            brick.render();
        }
    }

}
