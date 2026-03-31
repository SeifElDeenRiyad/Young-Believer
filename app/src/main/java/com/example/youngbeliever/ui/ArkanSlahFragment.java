package com.example.youngbeliever.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.ArkanSlahModel;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ArkanSlahFragment extends Fragment
{
    VideoView slahVideoView;
    ArkanSlahViewModel arkanSlahViewModel;
    public ArkanSlahFragment()
    {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.arkan_slah_list, container, false);
        arkanSlahViewModel = new ViewModelProvider(this).get(ArkanSlahViewModel.class);

        slahVideoView = rootView.findViewById(R.id.slah_video_view);
        MaterialCardView slahVideoContainer = rootView.findViewById(R.id.slah_video_container);
        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        MediaController mediaController = new MediaController(requireContext());
        slahVideoView.setMediaController(mediaController);
        mediaController.setAnchorView(slahVideoView);

        RecyclerView arkanSlahRecycler = rootView.findViewById(R.id.arkan_slah_recycler);
        ArkanSlahAdapter adapter = new ArkanSlahAdapter();

        arkanSlahRecycler.setAdapter(adapter);
        arkanSlahRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        arkanSlahViewModel.getSlahWay();

        arkanSlahViewModel.slahWay.observe(getViewLifecycleOwner(), new Observer<ArrayList<ArkanSlahModel>>()
        {
            @Override
            public void onChanged(ArrayList<ArkanSlahModel> arkanSlahModels)
            {
                adapter.setList(arkanSlahModels, new ArkanSlahAdapter.itemClickListener()
                {
                    @Override
                    public void onItemClick(ArkanSlahModel arkanSlahModel)
                    {
                        slahVideoContainer.setVisibility(View.VISIBLE);
                        fab.setVisibility(View.VISIBLE);
                        int videoName = arkanSlahModel.getSlahWay();
                        playVideo(videoName);
                    }
                });
            }
        });

        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                slahVideoView.stopPlayback();
                slahVideoContainer.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
            }
        });

        return rootView;
    }

    private void playVideo(int videoName)
    {
        String videoPath;
        if (videoName == R.string.slah_way_1)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.one;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
        else if (videoName == R.string.slah_way_2)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.two;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
        else if (videoName == R.string.slah_way_3)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.three;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
        else if (videoName == R.string.slah_way_4)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.four;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
        else if (videoName == R.string.slah_way_5)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.five;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
        else if (videoName == R.string.slah_way_6)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.six;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
        else if (videoName == R.string.slah_way_7)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.seven;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
        else if (videoName == R.string.slah_way_8)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.eight;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
        else if (videoName == R.string.slah_way_9)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.nine;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
        else if (videoName == R.string.slah_way_10)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.ten;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
        else if (videoName == R.string.slah_way_11)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.eleven;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            slahVideoView.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(slahVideoView.isPlaying())
        {
            slahVideoView.stopPlayback();
        }
    }
}
