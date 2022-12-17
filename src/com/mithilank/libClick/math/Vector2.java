package com.mithilank.libClick.math;

public class Vector2{
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

        return "(" + x + ", " + y+ ")";
    }

    public static void add(Vector2 one, Vector2 two) {
        one.x += two.x;
        one.y += two.y;

    }
    public static void sub(Vector2 one, Vector2 two) {
        one.x -= two.x;
        one.y -= two.y;

    }
}
