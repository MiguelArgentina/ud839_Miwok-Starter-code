package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;
    private int mAudioResourceId;
    private boolean mHasImage = false;
    private boolean mHasAudio = false;

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int miwokImage) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = miwokImage;
        mHasImage = true;
    }

    public Word(String defaultTranslation, String miwokTranslation, int miwokImage, int miwokAudio) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = miwokImage;
        mAudioResourceId = miwokAudio;
        if (miwokImage != -1) {
            mHasImage = true;
        }
        mHasAudio = true;
    }

    public boolean hasImage() {
        return mHasImage;
    }

    public boolean hasAudio() {
        return mHasAudio;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
