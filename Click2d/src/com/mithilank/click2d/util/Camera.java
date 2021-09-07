package com.mithilank.click2d.util;

import com.mithilank.click2d.app.Click2dApplication;
import com.mithilank.click2d.math.Vector2;

public class Camera {
    public Vector2 position;
    public float width;
    public float height;

    public Camera (Click2dApplication game) {
        width = game.width;
        height = game.height;
        position = new Vector2(0 - width / 2 , 0 - height / 2);
    }

    public void set (float x, float y) {
        position = new Vector2(x - width / 2 , y - height / 2);
    }

    public void set (Vector2 SubjectPos) {
        position = new Vector2(SubjectPos.x - width / 2 , SubjectPos.y - height / 2);
    }

    public void interpolate (Vector2 SubjectPos, float speed) {
        position.x += ((SubjectPos.x - width / 2)- position.x)/ speed;
        position.y += ((SubjectPos.y - height / 2)- position.y)/ speed;

    }

    public Vector2 get () {
        return new Vector2(this.position.x - width / 2, this.position.y - height / 2);
    }




}
