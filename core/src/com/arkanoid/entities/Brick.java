package com.arkanoid.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Kell on 22.04.2017.
 */
public class Brick {

    private Texture texture;
    private SpriteBatch batch;
    public float x;
    public float y;
    public int width = 60;
    public int height = 20;

    public Brick(float x, float y, int w, int h) {
        this.x = x;
        this.y = y;
        width = w;
        height = h;

        batch = new SpriteBatch();
        texture = getTexture(0);

    }

    public Brick(float x, float y, int color) {
        this.x = x;
        this.y = y;

        batch = new SpriteBatch();
        texture = getTexture(color);
    }

    private Texture getTexture(int color)
    {
        Texture tex = null;
        switch(color) {
            case 1:
                tex = new Texture(Gdx.files.internal("red-brick.png"));
                break;
            case 2:
                tex = new Texture(Gdx.files.internal("blue-brick.png"));
                break;
            case 3:
                tex = new Texture(Gdx.files.internal("green-brick.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("red-brick.png"));
                break;
        }
        return tex;
    }

    public void render() {
        batch.begin();
        batch.draw(texture, this.x, this.y);
        batch.end();
    }

}
