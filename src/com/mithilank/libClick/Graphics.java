package com.mithilank.libClick;

import com.mithilank.libClick.graphics.Display;
import com.mithilank.libClick.graphics.animations.AnimationManager;

import java.awt.image.BufferedImage;

public class Graphics {
    public int displaywidth = 640;
    public int displayheight = 360;
    public int windowwidth = 640;
    public int windowheight = 360;
    public long fps = 60;
    public Boolean resizable = false;
    public Display display;
    public BufferedImage screen;
    public AnimationManager animationmanager = new AnimationManager();
}