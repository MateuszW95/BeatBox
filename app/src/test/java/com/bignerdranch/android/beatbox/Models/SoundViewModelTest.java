package com.bignerdranch.android.beatbox.Models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SoundViewModelTest {
    private BeatBox mBeatBox;
    private Sound mSound;
    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        //obiekt pozorny
        mBeatBox=mock(BeatBox.class);

        mSubject=new SoundViewModel(mBeatBox);
        mSound=new Sound("assetPath");
        mSubject.setSound(mSound);
    }

    @Test
    public void exposesSoundNameAsTitle(){
        assertThat(mSubject.getTitle(),is(mSound.getName()));
    }

    @Test
    public void callBeatBoxPlayOnButtonClicked(){
        mSubject.OnPlay();
        verify(mBeatBox).play(mSound);
    }
}