package com.mithilank.libClick.node;

import com.mithilank.libClick.node.physics.PhysicsBody2d;

import java.util.ArrayList;

public class NodeManager {
    private ArrayList<Node2d> nodes = new ArrayList<>();
    public void add (Node2d rect) {
        nodes.add(rect);
    }

    public ArrayList<PhysicsBody2d> getPhysicsBodies (Boolean colliding) {
        ArrayList<PhysicsBody2d> Filtered = new ArrayList<>();
        ArrayList<PhysicsBody2d> Filtered2 = new ArrayList<>();
        for (Node2d node : nodes) {
            if (node instanceof PhysicsBody2d) {
                Filtered.add((PhysicsBody2d) node);
            }
        }
        if (colliding) {
            for (PhysicsBody2d node : Filtered) {

                if (node.colliding) {
                    Filtered2.add(node);
                }

            }
            return Filtered2;

        }
        else {
            return Filtered;
        }

    }

    public ArrayList<Node2d> get () {
        return this.nodes;
    }



}
