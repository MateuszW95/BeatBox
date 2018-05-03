package com.bignerdranch.android.beatbox.Models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.SeekBar;

/**
 * Created by mateusz on 26.04.18.
 */


public class BeatBoxViewModel extends BaseObservable {
    public static BeatBox mBeatBox;

    public int getProgress() {
        return mProgress;
    }

    @Bindable
    private static int mProgress;

    public BeatBoxViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
        setProgress((int)BeatBox.getmPlaySpeed());
    }


    public void setProgress(int progress) {
        mProgress = progress;
        notifyChange();
    }



    @InverseBindingAdapter(attribute ="progress" )
    public  static int getProgressFromSeek(SeekBar seekBar){

        return  seekBar.getProgress();
    }

    @BindingAdapter(value = {"progressAttrChanged"})
    public static void setListeners(SeekBar view, final InverseBindingListener inverseBindingListener){
        SeekBar.OnSeekBarChangeListener newListener;
        newListener=new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mBeatBox.setPlaySpeed((float)progress/(float)(66.67));
                mProgress=progress;
                inverseBindingListener.onChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        view.setOnSeekBarChangeListener(newListener);

    }

}
