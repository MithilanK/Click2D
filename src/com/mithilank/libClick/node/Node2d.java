package com.mithilank.libClick.node;

import com.mithilank.libClick.Click;
import com.mithilank.libClick.math.Vector2;

public class Node2d {
    public Vector2 position;
    public Node2d (Vector2 position) {
        this.position = position;
        Click.math.Bodies.add(this);
    }

    public void Tick() {

    }
}
