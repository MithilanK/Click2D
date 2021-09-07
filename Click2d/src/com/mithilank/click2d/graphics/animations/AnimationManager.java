package com.mithilank.click2d.graphics.animations;

import java.util.*;

public class AnimationManager {
    private Hashtable<String, Animation> Animations = new Hashtable<>();
    public AnimationManager () {

    }

    public void Register (String name, Animation anim) {
        Animations.put(name, anim);
    }

    public Animation Get (String name) {
        return Animations.get(name);
    }


    public void UpdateAll () {
        for (Map.Entry<String, Animation> entry : Animations.entrySet()){
            entry.getValue().Update();
        }
    }
}
