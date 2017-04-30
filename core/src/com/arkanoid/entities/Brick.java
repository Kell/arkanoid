package com.arkanoid.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Kell on 22.04.2017.
 */
public class Brick {

    Color color = Color.WHITE;
    public float x;
    public float y;
    public int width = 60;
    public int height = 20;
    ShapeRenderer rectRenderer = null;

    public Brick(float x, float y, int w, int h) {
        this.x = x;
        this.y = y;
        width = w;
        height = h;

        rectRenderer = new ShapeRenderer();
    }

    public Brick(float x, float y, Color c) {
        this.x = x;
        this.y = y;
        this.color = c;

        rectRenderer = new ShapeRenderer();
    }

    public void render() {
        rectRenderer.begin(ShapeRenderer.ShapeType.Filled);
        rectRenderer.setColor(color);
        rectRenderer.rect(x, y, width, height);
        rectRenderer.end();
    }

}
