package com.arkanoid.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Kell on 23.04.2017.
 */
public class Wall {
    float x;
    float y;
    int width;
    int height;
    int maxX;

    ShapeRenderer rectRenderer = null;

    public Wall(float x, float y, int w, int h) {
        this.x = x;
        this.y = y;
        width = w;
        height = h;

        rectRenderer = new ShapeRenderer();
    }

    public void render() {
        rectRenderer.begin(ShapeRenderer.ShapeType.Filled);
        rectRenderer.setColor(Color.GREEN);
        rectRenderer.rect(x,y, width, height);
        rectRenderer.end();
    }
}
