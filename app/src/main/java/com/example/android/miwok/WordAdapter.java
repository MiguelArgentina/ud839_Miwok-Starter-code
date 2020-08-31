package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int mBackgroudColor;

    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaPlayer;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words   A List of Word objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int myBackgroundColor) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mBackgroudColor = myBackgroundColor;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_number
        ImageView miwokImageView = listItemView.findViewById(R.id.imageResourceId);
        ImageView miwokAudioImageView = listItemView.findViewById(R.id.audioResourceId);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        if (currentWord.hasImage()) {
            miwokImageView.setImageResource(currentWord.getImageResourceId());

        } else {
            miwokImageView.setVisibility(View.GONE);
        }

        if (!currentWord.hasAudio()) {
            miwokAudioImageView.setVisibility(View.GONE);
        }

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());


        View textContainer = listItemView.findViewById(R.id.textaudioContainer);
        int color = ContextCompat.getColor(getContext(), mBackgroudColor);
        textContainer.setBackgroundColor(color);


        final ImageView listImg = miwokAudioImageView;
        listImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Imagine Dragons" + position, Toast.LENGTH_SHORT).show();
// Get the {@link Word} object at the given position the user clicked on

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(getContext(), currentWord.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();

            }
        });


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }


}
