package com.mithilank.libClick.math;

import com.mithilank.libClick.Click;
import com.mithilank.libClick.graphics.ShapeRenderer;

import java.awt.*;

public class Rect {
    public Vector2 position;
    public float width;
    public float height;
    public Boolean colliding;

    public Rect(float x, float y, float width, float height) {
        this.position = new Vector2(x, y);
        this.width = width;
        this.height = height;
        this.colliding = false;
        Click.math.Rects.add(this);
    }

    public Rect(float width, float height) {
        this.position = new Vector2(0, 0);
        this.width = width;
        this.height = height;
        this.colliding = false;
        Click.math.Rects.add(this);
    }
    public Rect(float x, float y, float width, float height, Boolean colliding) {
        this.position = new Vector2(x, y);
        this.width = width;
        this.height = height;

        this.colliding = colliding;
        Click.math.Rects.add(this);
    }

    public Rect(float width, float height, Boolean colliding) {
        this.position = new Vector2(0, 0);
        this.width = width;
        this.height = height;
        this.colliding = colliding;
        Click.math.Rects.add(this);
    }

    public Rect(Vector2 position, Vector2 scale) {
        this.position = position;
        this.width = scale.x;
        this.height = scale.y;
        Click.math.Rects.add(this);
    }

    public Boolean CollideRect (Rect rect) {
        return (position.x < rect.position.x + rect.width &&
                position.y+ height > rect.position.y &&
                position.x + width > rect.position.x &&
                position.y < rect.position.y + rect.height);
    }

    public Boolean CollidePoint (Vector2 point) {
        return (point.x > this.position.x &&
                point.x < this.position.x + this.width &&
                point.y > this.position.y &&
                point.y < this.position.y + this.width);
    }

    public void Draw (ShapeRenderer renderer, Color color) {
        renderer.DrawRect(this.position, this.width, this.height, color);

    }
}
