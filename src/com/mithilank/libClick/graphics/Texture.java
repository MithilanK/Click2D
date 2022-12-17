package com.mithilank.libClick.graphics;

import com.mithilank.libClick.math.Vector2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Texture {
    BufferedImage img;
    public Texture(BufferedImage img) {
        this.img = img;

    }
    public void Draw (SpriteBatch batch, Vector2 pos) {
        batch.DrawImg(this.img, pos);
    }
}
