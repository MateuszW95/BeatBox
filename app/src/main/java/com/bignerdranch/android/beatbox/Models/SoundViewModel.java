package com.bignerdranch.android.beatbox.Models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.adapters.SeekBarBindingAdapter;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * Created by mateusz on 23.04.18.
 */

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;


    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    public  void OnPlay(){
        mBeatBox.play(mSound);
    }
    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange();
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

}
