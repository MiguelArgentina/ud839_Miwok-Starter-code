package com.example.android.miwok;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomWordAdapter extends RecyclerView.Adapter<CustomWordAdapter.MyViewHolder> {

    // declaring some fields.
    private ArrayList<Word> arrayList = new ArrayList<>();
    private OnRecyclerClickListener listener;
    private int mBackgroudColor;


    // constructor
    public CustomWordAdapter(ArrayList<Word> arrayList, int myBackgroundColor) {
        this.arrayList = arrayList;
        mBackgroudColor = myBackgroundColor;
    }

    public CustomWordAdapter(ArrayList<Word> arrayList, int myBackgroundColor, OnRecyclerClickListener listener) {
        this.listener = listener;
        this.arrayList = arrayList;
        mBackgroudColor = myBackgroundColor;
    }


    @NonNull
    @Override
    public CustomWordAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v("CreateViewHolder", "in onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext())
                //the layout of each element of the RecyclerView
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomWordAdapter.MyViewHolder holder, final int position) {


        Log.v("BindViewHolder", "in onBindViewHolder");

        Word currentWord = arrayList.get(position);

        if (currentWord.hasImage()) {
            holder.miwokImageView.setImageResource(currentWord.getImageResourceId());
        } else {
            holder.miwokImageView.setVisibility(View.INVISIBLE);
        }

        if (!currentWord.hasAudio()) {
            holder.miwokAudioImageView.setVisibility(View.GONE);
        }

        holder.defaultTextView.setText(currentWord.getDefaultTranslation());
        holder.miwokTextView.setText(currentWord.getMiwokTranslation());


        holder.miwokAudioImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRecyclerViewItemClicked(position, view.getId());
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, number, addedOn, defaultTextView, miwokTextView;
        ImageView miwokImageView, miwokAudioImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            Log.v("ViewHolder", "in View Holder");
            //We create elements for each component of a RecyclerView element
            miwokImageView = itemView.findViewById(R.id.imageResourceId);
            miwokAudioImageView = itemView.findViewById(R.id.audioResourceId);
            defaultTextView = itemView.findViewById(R.id.default_text_view);
            miwokTextView = itemView.findViewById(R.id.miwok_text_view);

            View textContainer = itemView.findViewById(R.id.textaudioContainer2);
            int color = ContextCompat.getColor(itemView.getContext(), mBackgroudColor); // ContextCompat.getColor(getContext(), mBackgroudColor);
            textContainer.setBackgroundColor(color);
        }
    }
}
