package com.mithilank.libClick.ui;

import com.mithilank.libClick.Click;
import com.mithilank.libClick.graphics.Texture;
import com.mithilank.libClick.math.Rect;
import com.mithilank.libClick.math.Vector2;

import java.util.ArrayList;

public class ButtonManager {
    public ArrayList<Button> buttons;

    public class Button {
        public Rect bounds;
        public Texture Normal;
        public Texture Hover;
        public Texture Down;
        public Texture MainTexture;
        public Boolean pressed = false;
        public Boolean clicking = false;
        public Button (float x, float y, float width, float height, Texture Normal, Texture Hover, Texture Down) {
            this.bounds = new Rect(x, y, width, height);
            this.Normal = Normal;
            this.Hover = Hover;
            this.Down= Down;
            this.MainTexture = Normal;

            buttons.add(this);
        }

        public void mouseup () {
            if (this.bounds.CollidePoint(Click.input.mouse.MousePos())) {
                onPressed();
            }
        }

        public void onPressed () {

        }





        public void update (Vector2 mousepos) {
            if (this.bounds.CollidePoint(mousepos)) {
                if (Click.input.mouse.left) {
                    this.MainTexture = Down;
                }
                else {
                    this.MainTexture = Hover;
                }
            }
            else {
                this.MainTexture = Normal;
            }
        }

    }

    public void MouseUp () {
        for (Button button: buttons) {
            button.mouseup();
        }
    }

    public void Update () {
        for (Button button: buttons) {
            button.update(Click.input.mouse.MousePos());
        }
    }
}
