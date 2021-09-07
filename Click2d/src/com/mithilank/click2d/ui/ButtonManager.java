package com.mithilank.click2d.ui;

import com.mithilank.click2d.app.Click2dApplication;
import com.mithilank.click2d.graphics.Texture;
import com.mithilank.click2d.input.Mouse;
import com.mithilank.click2d.math.Rect;
import com.mithilank.click2d.math.Vector2;

import java.util.ArrayList;

public class ButtonManager {
    public ArrayList<Button> buttons;
    public Mouse mouse;

    public class Button {
        public Rect bounds;
        public Texture Normal;
        public Texture Hover;
        public Texture Down;
        public Texture MainTexture;
        public Boolean pressed = false;
        public Button (float x, float y, float width, float height, Texture Normal, Texture Hover, Texture Down) {
            this.bounds = new Rect(x, y, width, height);
            this.Normal = Normal;
            this.Hover = Hover;
            this.Down= Down;
            this.MainTexture = Normal;

            buttons.add(this);
        }
        public void onClick() {

        }

        public void update (Vector2 mousepos) {
            if (pressed) {
                pressed = false;
                this.onClick();
            }

            if (this.bounds.CollidePoint(mousepos)) {
                if (mouse.left) {
                    this.MainTexture = Down;
                    pressed = true;

                }
                else {
                    this.MainTexture = Hover;

                }
            }
            else  {
                this.MainTexture = Normal;
            }
        }
    }
}
//Que prefieres comer en el desayuno? prefierero comer los huevos para la almurezo