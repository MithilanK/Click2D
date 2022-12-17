package com.mithilank.libClick;

import com.mithilank.libClick.graphics.Display;
import com.mithilank.libClick.node.Node2d;
import com.mithilank.libClick.util.AppConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class App extends JPanel implements Runnable {
    double deltaU = 0;
    double deltaF = 0;
    int frames = 0;
    int ticks = 0;
    public Long fps;
    public Boolean running = true;
    public String name;
    public Thread GameThread;

    public App (AppConfig cfg) {

        this.name = cfg.name;
        Click.graphics.displaywidth = (int) cfg.width;
        Click.graphics.displayheight = (int) cfg.height;
        Click.graphics.windowwidth = (int) cfg.gamewidth;
        Click.graphics.windowheight = (int) cfg.gameheight;
        Click.graphics.resizable = cfg.resizeable;
        Click.graphics.screen = new BufferedImage(Click.graphics.windowwidth, Click.graphics.windowheight, BufferedImage.TYPE_INT_RGB);
        Click.graphics.display = new Display(name);
        Click.graphics.display.addKeyListener(Click.input.key);
        Click.graphics.display.addMouseListener(Click.input.mouse);
        Click.graphics.fps = cfg.fps;



    }



    public void start() {

        GameThread = new Thread(this);
        GameThread.start();
    }

    @Override
    public void run() {
        create();
        Click.graphics.display.setSize(Click.graphics.displaywidth, Click.graphics.displayheight);

        Click.graphics.display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Click.graphics.display.setVisible(true);
        Click.graphics.display.setResizable(Click.graphics.resizable);

        
        final long MS_PER_UPDATE = ((1000L)/ (Click.graphics.fps));
        long last_frame_time = System.currentTimeMillis();
        while (true) {

            Click.graphics.screen = new BufferedImage(Click.graphics.windowwidth, Click.graphics.windowheight, BufferedImage.TYPE_INT_RGB);
            for (Node2d node : Click.math.Bodies.get()) {
                node.Tick();
            }
            update();



            Click.graphics.display.getGraphics().drawImage(Click.graphics.screen.getScaledInstance(Click.graphics.displaywidth ,Click.graphics.displayheight, 1), 0, 0, null);
            try {
                if (MS_PER_UPDATE -(System.currentTimeMillis() - last_frame_time) > 0) {
                    Thread.sleep(MS_PER_UPDATE - (System.currentTimeMillis() - last_frame_time));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            last_frame_time =  System.currentTimeMillis();

        }
    }
    public void create() {
    }

    public void update() {

    }

}
