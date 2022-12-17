package com.mithilank.libClick.graphics.animations;

import com.mithilank.libClick.graphics.*;
import com.mithilank.libClick.graphics.Texture;

import java.util.Hashtable;
import java.util.Map;

public class AnimationPlayer {
    private Hashtable<String, Animation> Animations = new Hashtable<>();
    public Texture MainFrame;
    public AnimationPlayer () {

    }

    public void Play (String Name) {
        if (Animations.get(Name).playying) {
            for (Map.Entry<String, Animation> entry : Animations.entrySet()){
                if (entry.getKey() != Name) {
                    entry.getValue().Stop();
                }
            }
        }
        else {
            for (Map.Entry<String, Animation> entry : Animations.entrySet()){
                entry.getValue().Stop();
            }
            Animations.get(Name).Play();
        }

    }

    public void Register (String name, Animation anim) {
        Animations.put(name, anim);
    }

    public Animation Get (String name) {
        return Animations.get(name);
    }

    public void Update () {
        for (Map.Entry<String, Animation> entry : Animations.entrySet()){
            entry.getValue().Update();
            if (entry.getValue().playying) {
                this.MainFrame = entry.getValue().frame;
            }
        }
    }
}
