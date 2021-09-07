package com.mithilank.click2d.audio;

import javax.sound.sampled.*;
import java.io.IOException;

public class Sound {
    public static synchronized void play(final String fileName)
    {
        // Note: use .wav files
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream
                            (
                                    java.lang.String.class.getClass().getResourceAsStream(fileName)
                            );
                    clip.open(inputStream);
                    clip.start();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                    System.out.println("play sound error: " + e.getMessage() + " for " + fileName);
                }
            }
        }).start();
    }
}


