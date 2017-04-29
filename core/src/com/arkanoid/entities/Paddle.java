package com.arkanoid.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Kell on 22.04.2017.
 */
public class Paddle {
    public float velocity = 150;
    float x;
    float y;
    int width;
    int height;
    int maxX;

    ShapeRenderer rectRenderer = null;

    public Paddle(float x, float y, int w, int h) {
        this.x = x;
        this.y = y;
        width = w;
        height = h;

        rectRenderer = new ShapeRenderer();
    }


    public void setX(float x) {
        if (x < 0) {
            x = 0;
        } else if (x > maxX) {
            x = maxX;
        }

        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public void render() {
        rectRenderer.begin(ShapeRenderer.ShapeType.Filled);
        rectRenderer.setColor(Color.WHITE);
        rectRenderer.rect(x, y, width, height);
        rectRenderer.end();
    }
}

