package com.arkanoid;

import com.arkanoid.entities.Ball;
import com.arkanoid.entities.Paddle;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;


public class Arkanoid extends ApplicationAdapter {

	public static boolean gameOver = false;
	int rectY = 10;
	int rectWidth = 100;
	int rectHeight = 20;
	Paddle paddle;
	Ball ball;
	float ballPaddleCenterX;
	MapHandler mapHandler;


	@Override
	public void create () {
		mapHandler = new MapHandler();
		mapHandler.initMap();

		paddle = new Paddle((400 - (rectWidth / 2)), rectY,rectWidth, rectHeight);
		paddle.setMaxX(Gdx.graphics.getWidth());
		float ballX = (paddle.getX() + (paddle.getWidth() / 2)) - (10);
		float ballY = rectY + rectHeight;
		ball = new Ball(ballX, ballY, 20, 20);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(!gameOver) {
			handleInput();
			update();

			mapHandler.render();
			paddle.render();
			ball.render();
		}
	}

	/**
	 * Update all logic functionality
	 */
	public void update() {
		ballPaddleCenterX = (paddle.getX() + (paddle.getWidth() / 2)) - (ball.width / 2);
		ball.update(paddle);

		mapHandler.update(ball);
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
			ball.velocityY = ball.velocity;

			ball.active = true;
		}
	}
}
