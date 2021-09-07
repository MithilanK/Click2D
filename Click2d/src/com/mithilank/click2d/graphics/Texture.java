package com.mithilank.click2d.graphics;

import com.mithilank.click2d.math.Vector2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Texture {
    BufferedImage img;
    public Texture(String path) {
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Not Valid Image");
        }
    }

    public void Draw (SpriteBatch batch, Vector2 pos) {
        batch.DrawImg(this.img, pos);
    }
}
