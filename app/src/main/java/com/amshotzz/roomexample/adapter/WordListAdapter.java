package com.amshotzz.roomexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.amshotzz.roomexample.R;
import com.amshotzz.roomexample.databinding.LayoutWordItemBinding;
import com.amshotzz.roomexample.entity.Word;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WorldViewHolder> {

    private final LayoutInflater mInflater;
    private List<Word> mWords;

    public WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordListAdapter.WorldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutWordItemBinding wordItemBinding;
        wordItemBinding = DataBindingUtil.inflate(mInflater, R.layout.layout_word_item, parent, false);
        return new WorldViewHolder(wordItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WorldViewHolder holder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            holder.vBinding.textView.setText(current.getWord());
        } else {
            // Covers the case of data not being ready yet.
            holder.vBinding.textView.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }

    public void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    public class WorldViewHolder extends RecyclerView.ViewHolder {
        LayoutWordItemBinding vBinding;

        public WorldViewHolder(@NonNull View itemView) {
            super(itemView);
            vBinding = DataBindingUtil.bind(itemView);
        }
    }
}
