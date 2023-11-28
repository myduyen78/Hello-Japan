package edu.hanu.a1_2001040051;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

public class AlphabetReader {
    public static void read(AssetFileDescriptor sound) {
        soundInvocation.pause();
        soundInvocation = new MediaPlayer();

        soundInvocation.setOnPreparedListener(MediaPlayer::start);

        try {
            soundInvocation.setDataSource(sound);
            soundInvocation.prepare();
        } catch (Exception ignore) {
        }

    }
    private static MediaPlayer soundInvocation = new MediaPlayer();

}
