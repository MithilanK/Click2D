package com.mithilank.libClick.input;

import com.mithilank.libClick.Click;
import com.mithilank.libClick.math.Vector2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
    public Boolean left = false;
    public Boolean right = false;
    public Boolean middle = false;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                left = true;
                break;
            case MouseEvent.BUTTON2:
                middle = true;
                break;
            case MouseEvent.BUTTON3:
                right = true;
                break;

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                left = false;
                break;
            case MouseEvent.BUTTON2:
                right = false;
                break;
            case MouseEvent.BUTTON3:
                middle = false;
                break;
        }

    }


    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Vector2 MousePos() {
        return new Vector2(Click.graphics.display.getMousePosition().x, Click.graphics.display.getMousePosition().y);
    }
}
