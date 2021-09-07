package com.mithilank.click2d.graphics;

import com.mithilank.click2d.math.Vector2;
import com.mithilank.click2d.util.Camera;

import java.awt.*;

public class ShapeRenderer {
    private Graphics2D gl;
    private Boolean isbegun = false;
    public float offsetx = 0f;
    public float offsety = 0f;
    public ShapeRenderer () {

    }

    public void SetProjectionMatrix (Camera cam) {
        offsetx = cam.position.x;
        offsety = cam.position.y;
    }

    public void Begin(Graphics2D gl) {
        this.gl = gl;
        isbegun = true;
    }

    public void DrawRect (Vector2 pos, float width, float height, Color color) {
        if (isbegun) {
            gl.setColor(color);
            gl.fillRect((int) ((int) pos.x - offsetx), (int) ((int) pos.y - offsety), (int) width, (int) height);
        }
    }

    public void OutlineRect (Vector2 pos, float width, float height, Color color) {
        if (isbegun) {
            gl.setColor(color);
            gl.drawRect((int) pos.x -  (int) offsetx, (int) pos.y - (int)  offsety, (int) width, (int) height);
        }
    }

    public void DrawCircle (Vector2 pos, float radius, Color color) {
        if (isbegun) {
            gl.setColor(color);
            gl.drawOval((int)pos.x -  (int) offsetx,(int) pos.y - (int)  offsety, (int)radius,(int) radius);
        }

    }

    public void End() {
        this.gl = null;
        isbegun = false;
        offsetx = 0f;
        offsety = 0f;

    }
}
