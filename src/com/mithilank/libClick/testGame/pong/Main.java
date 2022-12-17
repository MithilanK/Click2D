package com.mithilank.libClick.testGame.pong;

import com.mithilank.libClick.App;
import com.mithilank.libClick.util.AppConfig;

public class Main {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        config.width = 1280;
        config.height = 720;
        config.gameheight = 720;
        config.gamewidth = 1280;
        config.fps = 60L;
        config.name = "poopoo";
        new Game(config).start();

    }
}
