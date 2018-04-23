package com.bignerdranch.android.beatbox.Activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.bignerdranch.android.beatbox.Fragments.BeatBoxFragment;
import com.bignerdranch.android.beatbox.R;

public class BeatBoxActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }


}
