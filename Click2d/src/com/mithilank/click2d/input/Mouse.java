package com.mithilank.click2d.input;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
    public Boolean left = false;
    public Boolean leftjustdown = false;
    public Boolean right = false;
    public Boolean rightjustdown = false;
    public Boolean middle = false;
    public Boolean middlejustdown = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                leftjustdown = true;
                break;
            case MouseEvent.BUTTON2:
                middlejustdown = true;
                break;
            case MouseEvent.BUTTON3:
                rightjustdown = true;
                break;

        }

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
}
