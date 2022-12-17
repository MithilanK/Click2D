package com.mithilank.libClick.graphics;

import com.mithilank.libClick.Click;
import com.mithilank.libClick.input.Key;
import com.mithilank.libClick.math.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteBatch {
    boolean isbegun;
    Graphics2D gl;
    public SpriteBatch () {

    }
    public void Begin(Graphics2D gl) {
        this.gl = gl;
        isbegun = true;
    }

    public void DrawImg (BufferedImage img, Vector2 pos) {
        gl.drawImage(img, (int)pos.x, (int)pos.y, null);
    }

    public void End() {
        this.gl = null;
        isbegun = false;

    }

}
