package com.mithilank.libClick.math;

import java.util.ArrayList;

public class AABBTree {
    private ArrayList<Rect> aabbs = new ArrayList<>();

    public void add (Rect rect) {
        aabbs.add(rect);
    }

    public ArrayList<Rect> get () {
        return this.aabbs;
    }

    public ArrayList<Rect> Hitlist (Rect dudeguy) {
        ArrayList<Rect> hitting = new ArrayList<>();
        for (Rect rect : aabbs) {
            if (rect != dudeguy && dudeguy.CollideRect(rect)) {
                hitting.add(rect);

            }
        }
        return hitting;
    }

}
