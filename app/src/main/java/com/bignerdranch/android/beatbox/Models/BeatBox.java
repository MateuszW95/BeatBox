package com.bignerdranch.android.beatbox.Models;

import android.content.Context;
import android.content.res.AssetManager;
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
    private AssetManager mAssetManager;
    private List<Sound> mSounds=new ArrayList<>();

    public BeatBox(Context context){
        mAssetManager=context.getAssets();
        loadSounds();
    }

    public List<Sound> getSounds() {
        return mSounds;
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
            String path=SOUNDS_FOLDER+"/"+name;
            mSounds.add(new Sound(path));
        }

    }
}
