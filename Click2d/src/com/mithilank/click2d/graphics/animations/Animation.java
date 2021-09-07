package com.mithilank.click2d.graphics.animations;

import com.mithilank.click2d.graphics.Texture;

import java.util.ArrayList;

public class Animation {
    public ArrayList<Texture> frames;
    public float speed;
    public Texture frame;
    float tbf;
    float lastframetime;
    float framenum;
    public Boolean playying;


    public Animation (ArrayList<Texture> frames, float Speed) {
        this.frames = frames;
        this.speed = Speed;
        framenum = 0;
        this.tbf = speed / frames.size();
        this.tbf *= 1000000000f;
        lastframetime = System.nanoTime();
        playying = false;


    }

    public void Play () {
        if (!(playying)) {
            framenum = 0;
        }
        playying = true;
    }

    public void Stop () {
        if (playying) {
            framenum = 0;
        }
        playying = false;
    }

    public void Update () {
        if (playying) {
            if (lastframetime + tbf <= System.nanoTime()) {
                framenum += 1;
                lastframetime = System.nanoTime();
                this.frame = frames.get((int) framenum);
                if (framenum == frames.size()) {
                    playying = false;
                }
            }

        }
    }



}
