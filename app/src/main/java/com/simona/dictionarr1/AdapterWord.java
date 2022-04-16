package com.simona.dictionarr1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterWord extends RecyclerView.Adapter<AdapterWord.ClassViewHolderForWord> {

    Context contextul;
    ArrayList<Wordd> sirWords;

    public AdapterWord(Context context, ArrayList<Wordd> sirWords) {
        this.contextul = context;
        this.sirWords = sirWords;
    }

    public class ClassViewHolderForWord extends RecyclerView.ViewHolder {

        TextView wordTV;

        public ClassViewHolderForWord(@NonNull View itemView) {
            super(itemView);
            wordTV = itemView.findViewById(R.id.wordTextView);
        }
    }


    @NonNull
    @Override
    public ClassViewHolderForWord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contextul).inflate(R.layout.rand, parent, false);
        ClassViewHolderForWord cvhw = new ClassViewHolderForWord(v);
        return cvhw;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolderForWord holder, int position) {
        Wordd currentWord = sirWords.get(position);
        holder.wordTV.setText(currentWord.getWordd());
    }

    @Override
    public int getItemCount() {
        return sirWords.size();
    }


}
