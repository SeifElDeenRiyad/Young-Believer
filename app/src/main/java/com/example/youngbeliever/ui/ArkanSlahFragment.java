package com.example.youngbeliever.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.ArkanSlahModel;
import com.example.youngbeliever.utils.SpaceManager;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ArkanSlahFragment extends Fragment
{
    VideoView slahVideoView;
    MaterialCardView slahVideoContainer;
    FloatingActionButton fab;
    View overlay;
    TextView slahVideoTitle;
    MediaController mediaController;
    private OnBackPressedCallback videoBackCallback;

    public ArkanSlahFragment()
    {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.arkan_slah_list, container, false);
        ArkanSlahViewModel arkanSlahViewModel = new ViewModelProvider(this).get(ArkanSlahViewModel.class);

        slahVideoView = rootView.findViewById(R.id.slah_video_view);
        slahVideoContainer = rootView.findViewById(R.id.slah_video_container);
        fab = rootView.findViewById(R.id.fab_arkan_salah);
        overlay = rootView.findViewById(R.id.overlay_view_slah);
        slahVideoTitle = rootView.findViewById(R.id.slah_video_title);
        RecyclerView arkanSlahRecycler = rootView.findViewById(R.id.arkan_slah_recycler);

        mediaController = new MediaController(requireContext());
        slahVideoView.setMediaController(mediaController);
        mediaController.setAnchorView(slahVideoView);
        mediaController.hide();

        ArkanSlahAdapter adapter = new ArkanSlahAdapter();
        arkanSlahRecycler.setAdapter(adapter);
        arkanSlahRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        SpaceManager spaceManager = new SpaceManager();
        FrameLayout view = rootView.findViewById(R.id.slah_page);
        spaceManager.setBottomPadding(view);

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
                        int videoName = arkanSlahModel.getSlahWay();
                        playVideo(videoName);
                    }
                });
            }
        });
        fab.setOnClickListener(v -> hideContainer());
        //back button logic
        videoBackCallback = new OnBackPressedCallback(false)
        {
            @Override
            public void handleOnBackPressed()
            {
                hideContainer();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback
                (getViewLifecycleOwner(), videoBackCallback);
        return rootView;
    }
    //helper to play the video by parsing the setting the destination
    //and calling the show() function to show the necessary components
    private void playVideo(int videoName)
    {
        String videoPath;
        if (videoName == R.string.slah_way_1)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.one;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_2)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.two;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_3)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.three;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_4)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.four;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_5)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.five;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_6)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.six;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_7)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.seven;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_8)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.eight;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_9)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.nine;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_10)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.ten;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_11)
        {
            videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.eleven;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
    }
    //function to show the necessary components when needed
    private void showContainer(int videoName)
    {
        videoBackCallback.setEnabled(true);
        slahVideoContainer.setVisibility(View.VISIBLE);
        slahVideoTitle.setVisibility(View.VISIBLE);
        overlay.setVisibility(View.VISIBLE);
        slahVideoView.setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);
        slahVideoTitle.setText(videoName);
    }
    //function to hide the necessary components when needed
    public void hideContainer()
    {
        videoBackCallback.setEnabled(false);
        if (slahVideoView.isPlaying())
        {
            slahVideoView.stopPlayback();
        }
        slahVideoView.setVisibility(View.GONE);
        slahVideoTitle.setVisibility(View.GONE);
        overlay.setVisibility(View.GONE);
        fab.setVisibility(View.GONE);
        slahVideoContainer.setVisibility(View.GONE);
    }
    @Override
    public void onPause()
    {
        super.onPause();
        if (slahVideoView.isPlaying())
        {
            slahVideoView.stopPlayback();
        }
    }
}