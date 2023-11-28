package edu.hanu.a1_2001040051;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import java.io.IOException;
import java.util.ArrayList;

public class Enviroment {
    public static ArrayList<Word> hiraganaWords;
    public static ArrayList<Word> katakanaWords;

    private static ArrayList<Word> processAlpha(Resources resource, String packagename, String prefix) throws IOException {
        ArrayList<Word> alphabet = new ArrayList<>(46);
        for (int i = 0; i <= 50; i++) {
            Drawable image = null;
            AssetFileDescriptor sound = null;

            try {
                int id = resource.getIdentifier(prefix + i, "drawable", packagename);
                image = ResourcesCompat.getDrawable(resource, id, resource.newTheme());

                if (prefix.equals("h")) {
                    int idSound = resource.getIdentifier("s" + i, "raw", packagename);
                    sound = resource.openRawResourceFd(idSound);
                } else {
                    sound = hiraganaWords.get(i).sound;
                }

            } catch (Resources.NotFoundException ignore) {
            }

            Word word = new Word(image, sound);
            alphabet.add(word);
        }
        return alphabet;
    }

    public static void load(Resources resources, String packageName) {

        try {
            hiraganaWords = processAlpha(resources, packageName, "h");
            katakanaWords = processAlpha(resources, packageName, "k");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
