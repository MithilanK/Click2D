package com.mithilank.click2d.math;

public class Vector2 {
    public float x;
    public float y;

    public Vector2() {
        x = 0;
        y = 0;
    }
    public Vector2(float x, float y) {
        this.x = x;
        this.y =y;
    }

    public Vector2 normalize () {
        float hypot = (float) Math.hypot(x, y);
        this.x  = x/hypot;
        this.y = y/hypot;
        return this;
    }

    public String toString() {

        return x + ", " + y;
    }

}
