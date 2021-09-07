package com.mithilank.testgame.platformer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.mithilank.click2d.app.*;
import com.mithilank.click2d.graphics.*;
import com.mithilank.click2d.math.*;
import com.mithilank.click2d.util.Camera;

public class Platformer extends Click2dApplication {
    Rect Player = new Rect(40, 40, 64, 64);
    Vector2 PlayerVel = new Vector2(0, 0);
    ArrayList<Rect> rects = new ArrayList<Rect>();
    ShapeRenderer renderer = new ShapeRenderer();
    Boolean isonground = false;
    Camera cam = new Camera(this);
    @Override
    public void create() {
        this.name = "Platformer";
        rects.add(new Rect(0, 600, 1280, 150));
    }

    @Override
    public void update() {
        BufferedImage renderedimg = new BufferedImage(1280, 720, 1);

        PlayerVel.y += 1;
        if (PlayerVel.y > 6) {
            PlayerVel.y = 6;
        }

        PlayerVel.x = (this.key.D ? 1 : 0) - (this.key.A ? 1 : 0);
        PlayerVel.x *= 8;

        Player.position.y += PlayerVel.y;
        isonground = false;
        for (Rect rect: rects) {
            if (rect.CollideRect(Player)) {
                if (PlayerVel.y > 0) {
                    Player.position.y = rect.position.y - Player.height;
                    PlayerVel.y = 0;
                    isonground = true;
                }
                if (PlayerVel.y < 0) {
                    Player.position.y = rect.position.y + rect.height;
                    PlayerVel.y = 0;

                }
            }
        }
        Player.position.x += PlayerVel.x;
        for (Rect rect: rects) {
            if (rect.CollideRect(Player)) {
                if (PlayerVel.x > 0) {
                    while (Player.CollideRect(rect)) {
                        Player.position.x -= 0.1;
                    }
                    PlayerVel.x = 0;
                }
                if (PlayerVel.x < 0) {
                    while (Player.CollideRect(rect)) {
                        Player.position.x += 0.1;
                    }
                    PlayerVel.x = 0;

                }
            }
        }
        if (isonground&&(this.key.SPACE || this.key.W)) {

            this.PlayerVel.y = -15f;
        }
        cam.interpolate(Player.position, 12f);
        renderer.SetProjectionMatrix(cam);
        renderer.Begin((Graphics2D) renderedimg.getGraphics());
        renderer.DrawRect(Player.position, Player.width, Player.height, Color.WHITE);
        for (Rect rect: rects) {
            renderer.DrawRect(rect.position, rect.width, rect.height, Color.WHITE);
        }
        renderer.End();
        this.window.getGraphics().drawImage(renderedimg, 0, 0, null);
        
    }
}
