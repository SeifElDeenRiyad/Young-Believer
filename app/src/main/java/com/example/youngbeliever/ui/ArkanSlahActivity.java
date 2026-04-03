package com.example.youngbeliever.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.ArkanSlahModel;
import com.example.youngbeliever.utils.BackButtonManager;
import com.example.youngbeliever.utils.DrawerNavigationAppBarManager;
import com.example.youngbeliever.utils.SpaceManager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ArkanSlahActivity extends AppCompatActivity
{
    DrawerNavigationAppBarManager drawerNavigationAppBarManager;
    VideoView slahVideoView;
    MaterialCardView slahVideoContainer;
    FloatingActionButton fab;
    View overlay;
    TextView slahVideoTitle;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arkan_slah_activity);
        ArkanSlahViewModel arkanSlahViewModel = new ViewModelProvider(this).get(ArkanSlahViewModel.class);

        slahVideoView = findViewById(R.id.slah_video_view);
        slahVideoContainer = findViewById(R.id.slah_video_container);
        fab = findViewById(R.id.fab_arkan_salah);
        overlay = findViewById(R.id.overlay_view_slah);
        slahVideoTitle = findViewById(R.id.slah_video_title);
        DrawerLayout arkanSlahDrawer = findViewById(R.id.arkan_slah_drawer_layout);
        NavigationView arkanSlahNavigation = findViewById(R.id.arkan_slah_navigation_view);
        MaterialToolbar arkanSlahToolbar = findViewById(R.id.app_toolbar);
        RecyclerView arkanSlahRecycler = findViewById(R.id.arkan_slah_recycler);

        BackButtonManager backButtonManager = new BackButtonManager();

        drawerNavigationAppBarManager = new DrawerNavigationAppBarManager();
        drawerNavigationAppBarManager.setup(this, arkanSlahDrawer, arkanSlahNavigation, arkanSlahToolbar, R.id.arkan_eslam);
        drawerNavigationAppBarManager.syncCheckedItem();

        mediaController = new MediaController(this);
        slahVideoView.setMediaController(mediaController);
        mediaController.setAnchorView(slahVideoView);
        mediaController.hide();

        ArkanSlahAdapter adapter = new ArkanSlahAdapter();
        arkanSlahRecycler.setAdapter(adapter);
        arkanSlahRecycler.setLayoutManager(new LinearLayoutManager(this));

        SpaceManager spaceManager = new SpaceManager();
        FrameLayout view = findViewById(R.id.slah_page);
        spaceManager.setBottomPadding(view);

        arkanSlahViewModel.getSlahWay();
        arkanSlahViewModel.slahWay.observe(this, new Observer<ArrayList<ArkanSlahModel>>()
        {
            @Override
            public void onChanged(ArrayList<ArkanSlahModel> slahModels)
            {
                adapter.setList(slahModels, new ArkanSlahAdapter.itemClickListener()
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
        backButtonManager.specialBackFromActivityVideo(
                this, arkanSlahDrawer, slahVideoContainer,
                fab, overlay, slahVideoView);
    }
    //helper to play the video by parsing the setting the destination
    //and calling the show() function to show the necessary components
    private void playVideo(int videoName)
    {
        String videoPath;
        if (videoName == R.string.slah_way_1)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.one;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_2)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.two;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_3)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.three;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_4)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.four;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_5)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.five;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_6)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.six;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_7)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.seven;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_8)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.eight;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_9)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.nine;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_10)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.ten;
            slahVideoView.setVideoURI(Uri.parse(videoPath));
            showContainer(videoName);
            slahVideoView.start();
            mediaController.hide();
            slahVideoView.postDelayed(() -> mediaController.hide(), 200);
        }
        else if (videoName == R.string.slah_way_11)
        {
            videoPath = "android.resource://" + this.getPackageName() + "/" + R.raw.eleven;
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