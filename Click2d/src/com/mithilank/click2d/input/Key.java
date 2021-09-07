package com.mithilank.click2d.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {
    public Boolean A = false;
    public Boolean S = false;
    public Boolean D = false;
    public Boolean W = false;
    public Boolean SPACE = false;
    public Boolean UP = false;
    public Boolean LEFT = false;
    public Boolean DOWN = false;
    public Boolean RIGHT = false;
    public Boolean ONE = false;
    public Boolean TWO = false;
    public Boolean THREE = false;
    public Boolean FOUR = false;
    public Boolean FIVE = false;
    public Boolean SIX = false;
    public Boolean SEVEN = false;
    public Boolean EIGHT = false;
    public Boolean NINE = false;
    public Boolean ZERO = false;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                W = true;
                break;

            case KeyEvent.VK_A:
                A = true;
                break;

            case KeyEvent.VK_S:
                S = true;
                break;

            case KeyEvent.VK_D:
                D = true;
                break;

            case KeyEvent.VK_UP:
                UP = true;
                break;

            case KeyEvent.VK_DOWN:
                DOWN = true;
                break;

            case KeyEvent.VK_LEFT:
                LEFT = true;
                break;

            case KeyEvent.VK_RIGHT:
                RIGHT = true;
                break;

            case KeyEvent.VK_SPACE:
                SPACE = true;
                break;

            case KeyEvent.VK_0:
                ZERO = true;
                break;

            case KeyEvent.VK_1:
                ONE = true;
                break;

            case KeyEvent.VK_2:
                TWO = true;
                break;

            case KeyEvent.VK_3:
                THREE = true;
                break;

            case KeyEvent.VK_4:
                FOUR = true;
                break;

            case KeyEvent.VK_5:
                FIVE = true;
                break;

            case KeyEvent.VK_6:
                SIX = true;
                break;

            case KeyEvent.VK_7:
                SEVEN = true;
                break;

            case KeyEvent.VK_8:
                EIGHT = true;
                break;

            case KeyEvent.VK_9:
                NINE = true;
                break;


        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                W = false;
                break;

            case KeyEvent.VK_A:
                A = false;
                break;

            case KeyEvent.VK_S:
                S = false;
                break;

            case KeyEvent.VK_D:
                D = false;
                break;

            case KeyEvent.VK_UP:
                UP = false;
                break;

            case KeyEvent.VK_DOWN:
                DOWN = false;
                break;

            case KeyEvent.VK_LEFT:
                LEFT = false;
                break;

            case KeyEvent.VK_RIGHT:
                RIGHT = false;
                break;

            case KeyEvent.VK_SPACE:
                SPACE = false;
                break;

            case KeyEvent.VK_0:
                ZERO = false;
                break;

            case KeyEvent.VK_1:
                ONE = false;
                break;

            case KeyEvent.VK_2:
                TWO = false;
                break;

            case KeyEvent.VK_3:
                THREE = false;
                break;

            case KeyEvent.VK_4:
                FOUR = false;
                break;

            case KeyEvent.VK_5:
                FIVE = false;
                break;

            case KeyEvent.VK_6:
                SIX = false;
                break;

            case KeyEvent.VK_7:
                SEVEN = false;
                break;

            case KeyEvent.VK_8:
                EIGHT = false;
                break;

            case KeyEvent.VK_9:
                NINE = false;
                break;


        }
    }
}
