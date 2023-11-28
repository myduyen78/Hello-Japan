package edu.hanu.a1_2001040051;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.google.android.material.divider.MaterialDividerItemDecoration;

import edu.hanu.a1_2001040051.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    AlphabetViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this, getDefaultViewModelProviderFactory()).get(AlphabetViewModel.class);
        binding.setViewModel(viewModel);

        // load resources
        Enviroment.load(getResources(), getPackageName());

        WordAdapter wordAdapter = new WordAdapter();
        wordAdapter.submitList(Enviroment.hiraganaWords);
        binding.setWordAdapter(wordAdapter);

        // Decoration
        MaterialDividerItemDecoration horDecoration = new MaterialDividerItemDecoration(this, MaterialDividerItemDecoration.HORIZONTAL);
        MaterialDividerItemDecoration verDecoration = new MaterialDividerItemDecoration(this, MaterialDividerItemDecoration.VERTICAL);

        binding.recyclerWord.addItemDecoration(horDecoration);
        binding.recyclerWord.addItemDecoration(verDecoration);
        binding.recyclerWord.invalidateItemDecorations();
    }
}