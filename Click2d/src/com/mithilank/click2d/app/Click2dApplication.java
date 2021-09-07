package com.mithilank.click2d.app;

import com.mithilank.click2d.graphics.animations.AnimationManager;
import com.mithilank.click2d.input.*;
import com.mithilank.click2d.math.Vector2;

import javax.swing.*;
import java.awt.*;


public class Click2dApplication implements Runnable {
    double deltaU = 0; 
    double deltaF = 0;
    int frames = 0; 
    int ticks = 0;
    public Double fps = 60D;
    public Boolean running = true;
    public String name = "";
    public JFrame window;
    public Key key = new Key();
    public Mouse mouse = new Mouse();
    public int width = 1280;
    public int height = 720;
    public Boolean resizeable = false;
    private Screen screen;
    public AnimationManager animationmanager = new AnimationManager();

    public Vector2 MousePos () {
        return new Vector2(this.window.getMousePosition().getLocation().x, this.window.getMousePosition().getLocation().y);
    }


    public void start() {

        new Thread(this).start();
    }

    @Override
    public void run() {
        create();
        this.window = new JFrame(name);
        window.setSize(width, height);
        window.addKeyListener(key);
        window.addMouseListener(mouse);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(resizeable);



        long initialTime = System.nanoTime();
        final double timeU = 1000000000D / fps;
        final double timeF = 1000000000D / 60D;
        long timer = System.currentTimeMillis();
        while (running) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;
            animationmanager.UpdateAll();
            if (deltaU >= 1) {
                update();
                ticks++;
                deltaU--;
            }


            if (System.currentTimeMillis() - timer > 1000) {
                ticks = 0;
                timer += 1000;
            }
        }
    }
    public void create() {
    }

    public void update() {
        if (this.screen != null) {
            screen.update((Graphics2D) window.getGraphics());
        }
    }

    public void SetScreen(Screen screen) {
        if (this.screen != null) {
            this.screen.hide();
        }
        this.screen = screen;
        this.screen.show();
    }



}