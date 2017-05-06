package com.arkanoid.entities;

import com.arkanoid.Arkanoid;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Kell on 22.04.2017.
 */
public class Ball {

    public boolean active = false;
    public float velocity = 170;
    public float x;
    public float y;
    public float velocityX = 0;
    public float velocityY = 0;
    public int width;
    public int height;
    public float topPointX;
    public float topPointY;
    public float bottomPointX;
    public float bottomPointY;
    public float leftPointX;
    public float leftPointY;
    public float rightPointX;
    public float rightPointY;
    private Texture texture;
    private SpriteBatch batch;

    public Ball(float x, float y, int w, int h) {
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        // highest x value of the ball
        updateTopPointX();
        updateTopPointY();
        //lowest x value of the ball
        updateBottomPointX();
        //lowest y value of the ball
        updateBottomPointY();
        //max x ball value of the right side is in the middle
        updateRightPointX();
        updateRightPointY();
        //max x point to the left of the ball
        updateLeftPointX();
        updateLeftPointY();

        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("ball.png"));
    }

    public void updateTopPointX() {
        this.topPointX = this.x + (width / 2);
    }

    public void updateTopPointY() {
        this.topPointY = this.y + height;
    }

    public void updateBottomPointX() {
        this.bottomPointX = this.x;
    }

    public void updateBottomPointY() {
        this.bottomPointY = this.y;
    }

    public void updateLeftPointX() {
        this.leftPointX = this.y + (height / 2);
    }

    public void updateLeftPointY() {
        this.leftPointY = this.y;
    }

    public void updateRightPointX() {
        this.rightPointX = this.x + width;
    }

    public void updateRightPointY() {
        this.rightPointY = this.y + (height / 2);
    }

    public void render() {
        batch.begin();
        batch.draw(texture, this.x, this.y);
        batch.end();

    }

    public void update(Paddle paddle) {

        if(this.y > 570 || this.collisionWithPaddle(paddle)) {
            velocityY *=  -1;
        } else if(this.x < 10 || this.x > 770) {
            velocityX *= -1;
        }

        this.x += velocityX * Gdx.graphics.getDeltaTime();
        this.y += velocityY * Gdx.graphics.getDeltaTime();

        // highest x value of the ball
        updateTopPointX();
        updateTopPointY();
        //lowest x value of the ball
        updateBottomPointX();
        //lowest y value of the ball
        updateBottomPointY();
        //max x ball value of the right side is in the middle
        updateRightPointX();
        updateRightPointY();
        //max x point to the left of the ball
        updateLeftPointX();
        updateLeftPointY();

    }

    public boolean collisionWithPaddle(Paddle paddle) {
        if(this.y < (paddle.getY()+ paddle.getHeight()) ) {
           if( this.x < (paddle.getX()+ paddle.getWidth()) && this.x > paddle.getX()) {
               return true;
           } else if(this.y < 0) {
                Arkanoid.gameOver = true;
            }
        }

        return false;
    }
}
