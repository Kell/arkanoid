package com.arkanoid;

import com.arkanoid.entities.Ball;
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
    public int numberOfBrickRows = 6;
    // holds all bricks for current map
    public List<Brick> bricks = new ArrayList<Brick>();

    //map wall objects
    Wall wallTop;
    Wall wallLeft;
    Wall wallRight;

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
        int currentColorIndex = 1;
        int rowY = 400;
        // TODO: refactor brick generation for map
        // temporary solution to generate bricks
        for (int i = 1; i <= numberOfBrickRows; i++) {
            int rowX = 10;
            rowY += 20;
            for (int j = 1; j <= maxBricksPerRow; j++) {
                System.out.println("Color:"+currentColorIndex);
                bricks.add(new Brick(rowX, rowY, currentColorIndex));
                rowX += 60;
                currentColorIndex++;

                //start again with colors
                if(currentColorIndex == 4) {
                    currentColorIndex = 1;
                }


            }
        }
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
    public void update(Ball ball)
    {
        List<Brick> bricksToDelete = new ArrayList<Brick>();
        //TODO:: add brick collision
        for (Brick brick: bricks) {
            //check lower egde
            if(ball.topPointX > brick.x && ball.topPointX < (brick.x + brick.width)
                && ball.topPointY >= brick.y ) {
                ball.velocityY *=  -1;
                bricksToDelete.add(brick);
                break;
            }
            //check top edge
            //if(ball.topPointX > brick.x && ball.topPointX < (brick.x + brick.width)
            //        && ball.topPointY <= (brick.y + brick.height) ) {
            //    ball.velocityY *=  -1;
            //    bricksToDelete.add(brick);
            //    break;
            //}
            //check left edge
            //if(ball.rightPointY > brick.y && ball.rightPointY < (brick.y + brick.height)
            //        && ball.rightPointX <= brick.x) {
            //    ball.velocityX *=  -1;
            //    bricksToDelete.add(brick);
            //    break;
            //}
            //check right edge
            //if(ball.leftPointY > brick.y && ball.leftPointY < (brick.y + brick.height)
            //        && ball.leftPointX <= (brick.x) + brick.width) {
            //    ball.velocityX *=  -1;
            //    bricksToDelete.add(brick);
            //    break;
            //}
        }

        //delete Bricks
        for (Brick brick: bricksToDelete) {
            bricks.remove(brick);
        }
        bricksToDelete.clear();
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
