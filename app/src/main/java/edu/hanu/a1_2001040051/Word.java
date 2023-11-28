package edu.hanu.a1_2001040051;

import android.content.res.AssetFileDescriptor;
import android.graphics.drawable.Drawable;

public class Word {
    Drawable visualization;
    AssetFileDescriptor sound;

    boolean playable = true;
    public Word(Drawable visualization, AssetFileDescriptor sound) {
        this.visualization = visualization;
        this.sound = sound;
        if (visualization == null || sound == null) {
            playable = false;
        }
    }

}
