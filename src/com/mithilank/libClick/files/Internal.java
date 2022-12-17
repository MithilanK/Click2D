package com.mithilank.libClick.files;

import com.mithilank.libClick.graphics.Texture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Internal {
    public Texture load_texture (String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        }
        catch (IOException e) {
            System.out.println("No Valid Image dummy what are you doing");
        }

        return new Texture(img);
    }

}
