package com.mithilank.libClick.node.physics.bodies;

import com.mithilank.libClick.math.Vector2;
import com.mithilank.libClick.node.physics.PhysicsBody2d;

public class StaticBody2d extends PhysicsBody2d {
    public StaticBody2d(Vector2 position, Vector2 scale) {
        super(position, scale);
    }
}
