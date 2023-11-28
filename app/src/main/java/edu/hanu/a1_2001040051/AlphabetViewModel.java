package edu.hanu.a1_2001040051;

import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;

public class AlphabetViewModel extends ViewModel {
    public void show(WordAdapter adapter, TextView title, String type, Button toShowBtn, Button toHideBtn) {
        switch (type) {
            case "hi" : {
                if (adapter.getCurrentList() != Enviroment.hiraganaWords) {
                    adapter.submitList(Enviroment.hiraganaWords);
                    title.setText(R.string.hiragana);
                }
                break;
            }
            case "ka" : {
                if (adapter.getCurrentList() != Enviroment.katakanaWords) {
                    adapter.submitList(Enviroment.katakanaWords);
                    title.setText(R.string.katakana);
                }
                break;
            }
        }

        toShowBtn.setBackgroundColor(ContextCompat.getColor(toShowBtn.getContext(), R.color.btn_on));
        toHideBtn.setBackgroundColor(ContextCompat.getColor(toShowBtn.getContext(), R.color.white));
    }
}
