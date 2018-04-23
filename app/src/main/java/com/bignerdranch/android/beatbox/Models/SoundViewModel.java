package com.bignerdranch.android.beatbox.Models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by mateusz on 23.04.18.
 */

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;
    public  SoundViewModel(BeatBox beatBox){
        mBeatBox=beatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange();
    }
    @Bindable
    public String getTitle(){
        return mSound.getName();
    }
}