package com.mithilank.libClick.node.physics;

import com.mithilank.libClick.math.Rect;
import com.mithilank.libClick.math.Vector2;
import com.mithilank.libClick.node.Node2d;

public class PhysicsBody2d extends Node2d {
    public Vector2 scale;
    public Rect hitbox;
    public Vector2 move;
    public Boolean colliding = false;

    public PhysicsBody2d(Vector2 position, Vector2 scale) {
        super(position);
        move = new Vector2();
        this.scale = scale;
        hitbox = new Rect(position, scale);
    }

    public void Tick () {

    }


}
     