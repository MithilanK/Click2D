package com.mithilank.libClick.node.physics.bodies;

import com.mithilank.libClick.Click;
import com.mithilank.libClick.math.Vector2;
import com.mithilank.libClick.node.Node2d;
import com.mithilank.libClick.node.physics.PhysicsBody2d;

import java.util.ArrayList;

public class RigidBody2d extends PhysicsBody2d {
    public Vector2 acceleration = new Vector2();
    public RigidBody2d(Vector2 position, Vector2 scale) {
        super(position, scale);
    }

    public void Update() {
    }

    public void addForce(Vector2 force) {
        Vector2.add(move, force);
    }

    public void gravityUpdate() {
        acceleration.y = 0.2f;
        Vector2.add(move, acceleration);
        this.hitbox.position.y += move.y;
        ArrayList<PhysicsBody2d> possiblecollisions = Click.math.Bodies.getPhysicsBodies(true);
        for (PhysicsBody2d body : possiblecollisions) {
            if (body instanceof StaticBody2d) {
                if (body.hitbox.CollideRect(this.hitbox)) {
                    if (move.y > 0) {
                        move.y = 0;
                        this.hitbox.position.y = body.hitbox.position.y - this.hitbox.height;
                    }

                    if (move.y < 0) {
                        move.y = 0;
                        this.hitbox.position.y = body.hitbox.position.y + body.hitbox.height;
                    }

                }
            }


        }
        this.hitbox.position.x += move.x;
        possiblecollisions = Click.math.Bodies.getPhysicsBodies(true);
        for (PhysicsBody2d body : possiblecollisions) {
            if (body.hitbox.CollideRect(this.hitbox) && body != this) {
                if (move.x > 0) {
                    move.x = 0;
                    this.hitbox.position.x = body.hitbox.position.x - hitbox.width;
                }

                if (move.x < 0) {this.hitbox.position.x = body.hitbox.position.x + body.hitbox.width;
                    move.x = 0;
                }

            }
        }
    }


    @Override
    public void Tick() {
        Update();
        gravityUpdate();
    }
}
