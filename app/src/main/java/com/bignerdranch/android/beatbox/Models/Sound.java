package com.bignerdranch.android.beatbox.Models;

/**
 * Created by mateusz on 23.04.18.
 */

public class Sound {
    private String mAssetPath;
    private String mName;
    private Integer mSoundId;

    public Sound(String assetPath){
        mAssetPath=assetPath;
        String[] components=assetPath.split("/");
        String fileName=components[components.length-1];
        mName=fileName.replace(".wav","");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }
}
