package com.arkanoid;

import com.arkanoid.entities.Ball;
import com.arkanoid.entities.Brick;
import com.arkanoid.entities.Wall;
import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kell on 29.04.2017.
 */
public class MapHandler {

    public int maxBricksPerRow = 13;
    public List<Brick> bricks = new ArrayList<Brick>();

    Ball ball;
    Wall wallTop;
    Wall wallLeft;
    Wall wallRight;

    Brick brick1;
    Brick brick2;
    Brick brick3;

    public void initMap()
    {
        wallTop = new Wall(0, 590, 800, 10);
        wallLeft = new Wall(0, 0, 10, 600);
        wallRight = new Wall(790, 0, 10, 600);


        brick1 = new Brick(10, 300, Color.BLUE);
        brick2 = new Brick(70, 300, Color.GREEN);
        brick3 = new Brick(130, 300, Color.CYAN);
        bricks.add(brick1);
        bricks.add(brick2);
        bricks.add(brick3);
    }

    public void render()
    {
        wallTop.render();
        wallLeft.render();
        wallRight.render();

       drawBricks();

    }

    public void update()
    {

    }

    public void drawBricks()
    {
        //render bricks
        for (Brick brick: bricks) {
            brick.render();
        }
    }

}
