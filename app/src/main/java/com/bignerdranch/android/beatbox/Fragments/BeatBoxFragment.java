package com.bignerdranch.android.beatbox.Fragments;

import android.databinding.DataBindingUtil;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.bignerdranch.android.beatbox.Models.BeatBox;
import com.bignerdranch.android.beatbox.Models.BeatBoxViewModel;
import com.bignerdranch.android.beatbox.Models.Sound;
import com.bignerdranch.android.beatbox.Models.SoundViewModel;
import com.bignerdranch.android.beatbox.R;
import com.bignerdranch.android.beatbox.databinding.FragmentBeatBoxBinding;
import com.bignerdranch.android.beatbox.databinding.ListItemSoundBinding;

import java.util.List;

/**
 * Created by mateusz on 23.04.18.
 */


public class BeatBoxFragment extends Fragment {

    private BeatBox mBeatBox;
    public static BeatBoxFragment newInstance(){
        return  new BeatBoxFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeatBox=new BeatBox(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBeatBoxBinding binding= DataBindingUtil.inflate(inflater,R.layout.fragment_beat_box,container,false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        binding.recyclerView.setAdapter(new SoundAdapter(mBeatBox.getSounds()));
        binding.setBeatBoxViewModel(new BeatBoxViewModel(mBeatBox));

        return binding.getRoot();
    }

    private class SoundHolder extends RecyclerView.ViewHolder{
        private ListItemSoundBinding mBinding;
        public SoundHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
            mBinding=binding;
            mBinding.setViewModel(new SoundViewModel(mBeatBox));
        }

        public void bind(Sound sound){
            mBinding.getViewModel().setSound(sound);
            mBinding.executePendingBindings();
        }

    }

    private  class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{
        private List<Sound> mSounds;
        @Override
        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getActivity());
            ListItemSoundBinding binding=DataBindingUtil.inflate(inflater,R.layout.list_item_sound,parent,false);
            return new SoundHolder(binding);
        }
        public SoundAdapter(List<Sound> sounds){
            mSounds=sounds;
        }

        @Override
        public void onBindViewHolder(SoundHolder holder, int position) {
            holder.bind(mSounds.get(position));
        }

        @Override
        public int getItemCount() {
           return mSounds.size();
        }
    }
}
