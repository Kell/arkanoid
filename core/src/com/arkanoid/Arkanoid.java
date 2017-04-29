package com.arkanoid;

import com.arkanoid.entities.Ball;
import com.arkanoid.entities.Brick;
import com.arkanoid.entities.Paddle;
import com.arkanoid.entities.Wall;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;


public class Arkanoid extends ApplicationAdapter {


	public static boolean gameOver = false;
	int rectX = 10;
	int rectY = 10;
	int rectWidth = 100;
	int rectHeight = 20;
	Paddle paddle;
	Ball ball;
	Wall wallTop;
	Wall wallLeft;
	Wall wallRight;
	float ballPaddleCenterX;
	Brick brick1;
	Brick brick2;
	Brick brick3;


	@Override
	public void create () {
		wallTop = new Wall(0, 590, 800, 10);
		wallLeft = new Wall(0, 0, 10, 600);
		wallRight = new Wall(790, 0, 10, 600);

		paddle = new Paddle(rectX, rectY,rectWidth, rectHeight);
		paddle.setMaxX(Gdx.graphics.getWidth());
		float ballX = (paddle.getX() + (paddle.getWidth() / 2)) - (10);
		float ballY = rectY + rectHeight;
		ball = new Ball(ballX, ballY, 20, 20);

		brick1 = new Brick(10, 300, Color.BLUE);
		brick2 = new Brick(70, 300, Color.GREEN);
		brick3 = new Brick(130, 300, Color.CYAN);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(!gameOver) {
			handleInput();
			update();

			brick1.render();
			brick2.render();
			brick3.render();

			paddle.render();
			wallTop.render();
			wallLeft.render();
			wallRight.render();

			ball.render();
		}
	}

	/**
	 * Update all logic functionality
	 */
	public void update() {
		ballPaddleCenterX = (paddle.getX() + (paddle.getWidth() / 2)) - (ball.width / 2);
		ball.update(paddle);
	}


	@Override
	public void dispose () {

	}

	/**
	 * Handles the user input
	 */
	public void handleInput() {

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			// set paddle movement to right
			paddle.setX(paddle.getX() + paddle.velocity * Gdx.graphics.getDeltaTime());
			if(!ball.active) {
				ball.x = ballPaddleCenterX + paddle.velocity * Gdx.graphics.getDeltaTime();
			}
		} else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			// set paddle movement to left
			paddle.setX(paddle.getX() -  paddle.velocity * Gdx.graphics.getDeltaTime());
			if(!ball.active) {
				ball.x = ballPaddleCenterX -  paddle.velocity * Gdx.graphics.getDeltaTime();
			}
		} else if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			//releasing ball
			ball.velocityX = ball.velocity;
			ball.velocityY = ball.velocityX;

			ball.active = true;
		}
	}
}
