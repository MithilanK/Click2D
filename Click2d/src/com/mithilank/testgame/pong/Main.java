package com.mithilank.testgame.pong;

import com.mithilank.click2d.app.Click2dApplication;
import com.mithilank.click2d.graphics.ShapeRenderer;
import com.mithilank.click2d.math.Rect;
import com.mithilank.click2d.math.Vector2;
import com.mithilank.click2d.util.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main extends Click2dApplication {
    ShapeRenderer renderer = new ShapeRenderer();
    Rect paddle1 = new Rect(40, 296, 64, 128);
    Rect paddle2 = new Rect(1200 - 40, 296, 64, 128);
    Rect ball = new Rect(624, 344, 32, 32);

    Vector2 paddle1vel = new Vector2(0, -4);
    Vector2 paddle2vel = new Vector2(0, 4);
    Vector2 ballvel = new Vector2(4, 0);
    Camera cam = new Camera(this);

    @Override
    public void create () {
        this.name = "P ong made with Click 2D";
    }

    @Override
    public void update () {
        BufferedImage disp = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);

        if (key.W) {
            paddle1vel.y = -4;
        }

        if (key.S) {
            paddle1vel.y = 4;
        }

        if (key.UP) {
            paddle2vel.y = -4;
        }

        if (key.DOWN) {
            paddle2vel.y = 4;
        }


        paddle1.position.y += paddle1vel.y;
        paddle2.position.y += paddle2vel.y;
        ball.position.x += ballvel.x; ball.position.y += ballvel.y;
        if (paddle1.position.y + paddle1.height >= height) {
            paddle1.position.y = height - paddle1.height;
            paddle1vel.y = -4;
        }
        if (paddle1.position.y <= 0 + 22f) {
            paddle1.position.y = 0 + 22f;
            paddle1vel.y = 4;
        }

        if (paddle2.position.y + paddle2.height >= height) {
            paddle2.position.y = height - paddle2.height;
            paddle2vel.y = -4;
        }
        if (paddle2.position.y <= 0 + 22f) {
            paddle2.position.y = 0 + 22f;
            paddle2vel.y = 4;
        }
        if (ball.position.y + ball.height >= height) {
            ball.position.y = height - ball.height;
            ballvel.y *= -1;
        }
        if (ball.position.y <= 0 + 22f) {
            ball.position.y = 0 + 22f;
            ballvel.y *= -1;
        }



        if (ball.CollideRect(paddle1)) {
            ball.position.x = paddle1.position.x + paddle1.width;
            
            ballvel.x *= -1;
            ballvel.x += 1;

            if (paddle1vel.y < 0) {
                ballvel.y = (float) ((Math.random() * (-3 - -1)) + -1);
            }
            if (paddle1vel.y > 0) {
                ballvel.y = (float) ((Math.random() * (3 - 1)) + 1);

            }
            if (paddle1vel.y == 0) {
                ballvel.y = (float) ((Math.random() * (1 - -1)) + -1);
            }
        }

        if (ball.CollideRect(paddle2)) {
            ball.position.x = (paddle2.position.x - paddle2.width) + ball.width;
            
            ballvel.x *= -1;
            ballvel.x += -1;
            

            if (paddle2vel.y < 0) {
                ballvel.y = (float) ((Math.random() * (-3 - -1)) + -1);
            }
            if (paddle2vel.y > 0) {
                ballvel.y = (float) ((Math.random() * (3 - 1)) + 1);

            }
            if (paddle2vel.y == 0) {
                ballvel.y = (float) ((Math.random() * (1 - -1)) + -1);
            }
        }

        if (ball.position.x <= 0 || ball.position.x >= 1280) {
            paddle1 = new Rect(40, 296, 64, 128);
            paddle2 = new Rect(1200 - 40, 296, 64, 128);
            ball = new Rect(624, 344, 32, 32);

            paddle1vel = new Vector2(0, -4);
            paddle2vel = new Vector2(0, 4);
            ballvel = new Vector2(4, 0);
        }
        cam.interpolate(ball.position, 12f);
        renderer.SetProjectionMatrix(cam);
        renderer.Begin((Graphics2D) disp.getGraphics());
        renderer.DrawRect(paddle1.position , paddle1.width, paddle1.height, Color.white);
        renderer.DrawRect(paddle2.position , paddle2.width, paddle2.height, Color.white);
        renderer.DrawRect(ball.position , ball.width, ball.height, Color.white);
        renderer.End();
        window.getGraphics().drawImage(disp, 0, 0, null);

    }


}
