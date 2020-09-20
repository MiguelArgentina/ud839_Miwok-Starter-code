package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button


        // Create an array of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus", -1, R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", -1, R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", -1, R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", -1, R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit", -1, R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", -1, R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", -1, R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm", -1, R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis", -1, R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", -1, R.raw.phrase_come_here));
        words.add(new Word("Where are you going?", "minto wuksus", -1, R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", -1, R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", -1, R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", -1, R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit", -1, R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", -1, R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", -1, R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm", -1, R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis", -1, R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", -1, R.raw.phrase_come_here));
        words.add(new Word("Where are you going?", "minto wuksus", -1, R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", -1, R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", -1, R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", -1, R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit", -1, R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", -1, R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", -1, R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm", -1, R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis", -1, R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", -1, R.raw.phrase_come_here));

        RecyclerView mRecyclerView1;
        CustomWordAdapter mAdapter;
        mRecyclerView1 = findViewById(R.id.list);

        mAdapter = new CustomWordAdapter(words, R.color.category_phrases, new OnRecyclerClickListener() {
            @Override
            public void onRecyclerViewItemClicked(int position, int id) {
                Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                // Start the audio file
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

        mRecyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView1.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView1.setAdapter(mAdapter);


    }

    /*
     * Clean up the media player by releasing its resources.
     */

    private void releaseMediaPlayer() {
        /* If the media player is not null, then it may be currently playing a sound.*/
        if (mMediaPlayer != null) {
            /* Regardless of the current state of the media player, release its resources
            // because we no longer need it.*/
            mMediaPlayer.release();

            /* Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.*/
            mMediaPlayer = null;
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}