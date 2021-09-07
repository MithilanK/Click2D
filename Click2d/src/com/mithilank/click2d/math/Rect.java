package com.mithilank.click2d.math;

public class Rect {
    public Vector2 position;
    public float width;
    public float height;

    public Rect(float x, float y, float width, float height) {
        this.position = new Vector2(x, y);
        this.width = width;
        this.height = height;
    }

    public Rect(float width, float height) {
        this.position = new Vector2(0, 0);
        this.width = width;
        this.height = height;
    }

    public Boolean CollideRect (Rect rect) {
        return (position.x < rect.position.x + rect.width &&
                position.y+ height > rect.position.y &&
                position.x + width > rect.position.x &&
                position.y < rect.position.y + rect.height);
    }


}
