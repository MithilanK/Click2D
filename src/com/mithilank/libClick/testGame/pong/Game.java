package com.mithilank.libClick.testGame.pong;

import com.mithilank.libClick.App;
import com.mithilank.libClick.graphics.ShapeRenderer;
import com.mithilank.libClick.util.AppConfig;

import java.awt.*;

public class Game extends App {
    public Paddle paddle1 = new Paddle();
    public ShapeRenderer shapeRenderer = new ShapeRenderer();
    public Game(AppConfig cfg) {
        super(cfg);
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {
        paddle1.position.y += 3.11111222222;
        shapeRenderer.Begin();
        paddle1.Draw(shapeRenderer, Color.WHITE);
        shapeRenderer.End();
    }
}
