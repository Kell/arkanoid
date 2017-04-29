package com.arkanoid.entities;

import com.arkanoid.Arkanoid;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Kell on 22.04.2017.
 */
public class Ball {

    public boolean active = false;
    public float velocity = 150;
    public float x;
    public float y;
    public float velocityX = 0;
    public float velocityY = 0;
    public int width;
    public int height;
    ShapeRenderer ballRenderer = null;

    public Ball(float x, float y, int w, int h) {
        this.x = x;
        this.y = y;
        width = w;
        height = h;

        ballRenderer = new ShapeRenderer();
    }

    public void render() {
        ballRenderer.begin(ShapeRenderer.ShapeType.Filled);
        ballRenderer.setColor(Color.WHITE);
        ballRenderer.ellipse(x, y, width, height);
        ballRenderer.end();

    }

    public void update(Paddle paddle) {

        if(this.y >= 570 || this.collisionWithPaddle(paddle)) {
            velocityY *=  -1;
        } else if(this.x < 10 || this.x >= 770) {
            velocityX *= -1;
        }

        this.x += velocityX * Gdx.graphics.getDeltaTime();
        this.y += velocityY * Gdx.graphics.getDeltaTime();

    }

    public boolean collisionWithPaddle(Paddle paddle) {
        if(this.y <= (paddle.getY()+ paddle.getHeight()) ) {
           if( this.x < (paddle.getX()+ paddle.getWidth()) && this.x > paddle.getX()) {
               return true;
           } else if(this.y < 0) {
                Arkanoid.gameOver = true;
            }
        }

        return false;
    }
}
