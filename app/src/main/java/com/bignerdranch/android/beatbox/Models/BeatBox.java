package com.bignerdranch.android.beatbox.Models;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateusz on 23.04.18.
 */

public class BeatBox {
    private static final String TAG="BeatBox";
    private static final String SOUNDS_FOLDER="sample_sounds";
    private static final int MAX_SOUNS=5;

    private AssetManager mAssetManager;
    private List<Sound> mSounds=new ArrayList<>();
    private SoundPool mSoundPool;

    public static float getmPlaySpeed() {
        return mPlaySpeed;
    }

    private static float mPlaySpeed=1.0f;

    public void setPlaySpeed(float playSpeed) {
        mPlaySpeed = playSpeed;
    }

    public BeatBox(Context context){
        mAssetManager=context.getAssets();
        mSoundPool=new SoundPool(MAX_SOUNS, AudioManager.STREAM_MUSIC,0);
        loadSounds();
    }

    public List<Sound> getSounds() {
        return mSounds;
    }

    private void load(Sound sound)throws IOException{
        AssetFileDescriptor afd=mAssetManager.openFd(sound.getAssetPath());
        sound.setSoundId(mSoundPool.load(afd,1));
    }

    private  void loadSounds(){
        String[] soundNames;
        try {
            soundNames=mAssetManager.list(SOUNDS_FOLDER);
            Log.i(TAG,"Znaleziono "+soundNames.length+" dźwięków");
        } catch (IOException e) {
            Log.e(TAG,"Nie można odczytać listy dźwięków",e);
            return;
        }
        for (String name:soundNames){
            try
            {
                String path = SOUNDS_FOLDER + "/" + name;
                Sound sound = new Sound(path);
                load(sound);
                mSounds.add(sound);
            }
            catch(Exception e)
            {
                Log.e(TAG,"Nie mogę załadowac pliku "+name,e);
            }
        }
    }

    public void play(Sound sound){
        Integer soundId=sound.getSoundId();
        if(soundId==null){
            return;
        }
        mSoundPool.play(soundId,1.0f,1.0f,1,0,mPlaySpeed);
    }

    public void release(){
        mSoundPool.release();
    }
}
