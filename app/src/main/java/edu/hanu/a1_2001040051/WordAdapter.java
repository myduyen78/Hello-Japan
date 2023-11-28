package edu.hanu.a1_2001040051;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class WordAdapter extends ListAdapter<Word, RecyclerView.ViewHolder> {
    class WordHolder extends RecyclerView.ViewHolder {
        ImageView charVisual;

        public void bind(Word word) {
            charVisual.setImageDrawable(word.visualization);
            charVisual.setOnClickListener(v -> AlphabetReader.read(word.sound));
        }

        public WordHolder(@NonNull View itemView) {
            super(itemView);
            charVisual = itemView.findViewById(R.id.charVisual);
            charVisual.setColorFilter(ContextCompat.getColor(itemView.getContext(),R.color.item_back), PorterDuff.Mode.SRC_ATOP);
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new WordHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((WordHolder) holder).bind(getItem(position));
    }

    static class DiffUtil extends androidx.recyclerview.widget.DiffUtil.ItemCallback<Word> {

        @Override
        public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem.equals(newItem);
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem.visualization.equals(newItem.visualization);
        }
    }

    private WordAdapter(@NonNull androidx.recyclerview.widget.DiffUtil.ItemCallback<Word> diffCallback) {
        super(diffCallback);
    }

    public WordAdapter() {
        super(new DiffUtil());
    }
}
