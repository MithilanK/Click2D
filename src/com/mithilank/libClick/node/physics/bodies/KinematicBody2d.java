package com.mithilank.libClick.node.physics.bodies;

import com.mithilank.libClick.Click;
import com.mithilank.libClick.math.Vector2;
import com.mithilank.libClick.node.physics.PhysicsBody2d;

import java.util.ArrayList;

public class KinematicBody2d extends PhysicsBody2d {
    public Boolean is_on_floor = false;
    public Boolean is_on_roof = false;
    public Boolean is_on_left_wall = false;
    public Boolean is_on_right_wall = false;

    public KinematicBody2d(Vector2 position, Vector2 scale) {
        super(position, scale);
    }


    public void Update () {

    }

    public void Move_and_slide (Vector2 velocity) {
        this.move = velocity;
        this.hitbox.position.y += move.y;
        ArrayList<PhysicsBody2d> possiblecollisions = Click.math.Bodies.getPhysicsBodies(true);
        for (PhysicsBody2d body : possiblecollisions) {
            if (body.hitbox.CollideRect(this.hitbox) && body != this) {
                if (move.y > 0) {
                    move.y = 0;
                    this.hitbox.position.y = body.hitbox.position.y - this.hitbox.height;
                    is_on_floor = true;
                }

                if (move.y < 0) {
                    move.y = 0;
                    this.hitbox.position.y = body.hitbox.position.y + body.hitbox.height;
                    is_on_roof = true;
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
                    is_on_left_wall = true;
                }

                if (move.x < 0) {this.hitbox.position.x = body.hitbox.position.x + body.hitbox.width;
                    move.x = 0;
                    is_on_left_wall = true;
                }

            }
        }
    }

    @Override
    public void Tick () {
        ResetConstants();
        Update();
    }

    private void ResetConstants() {
        is_on_floor = false;
        is_on_roof = false;
        is_on_left_wall = false;
        is_on_right_wall = false;
    }
}
