package com.example.youngbeliever.utils;

import android.view.View;
import android.widget.VideoView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

//helper class controls the back button behavior
public class BackButtonManager
{
    public void simpleBackFromActivity(AppCompatActivity activity, DrawerLayout drawer)
    {
        //overrides Back Behavior
        activity.getOnBackPressedDispatcher().addCallback(activity, new OnBackPressedCallback(true)
        {
            @Override
            public void handleOnBackPressed()
            {
                if (drawer.isDrawerOpen(GravityCompat.START))
                {
                    drawer.closeDrawer(GravityCompat.START);

                }
                else
                {
                    // default behavior (like old super.onBackPressed)
                    setEnabled(false);
                    activity.getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });
    }
    public void specialBackFromActivity(AppCompatActivity activity, DrawerLayout drawer, MaterialCardView cardView, FloatingActionButton fab, View overlay)
    {
        //overrides Back Behavior
        activity.getOnBackPressedDispatcher().addCallback(activity, new OnBackPressedCallback(true)
        {
            @Override
            public void handleOnBackPressed()
            {
                if (drawer.isDrawerOpen(GravityCompat.START))
                {
                    drawer.closeDrawer(GravityCompat.START);

                }
                else if(cardView.isShown())
                {
                    cardView.setVisibility(View.GONE);
                    fab.setVisibility(View.GONE);
                    overlay.setVisibility(View.GONE);
                }
                else
                {
                    // default behavior (like old super.onBackPressed)
                    setEnabled(false);
                    activity.getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });
    }

    public void specialBackFromActivityVideo(AppCompatActivity activity, DrawerLayout drawer, MaterialCardView cardView,
                                             FloatingActionButton fab, View overlay, VideoView view)
    {
        //overrides Back Behavior
        activity.getOnBackPressedDispatcher().addCallback(activity, new OnBackPressedCallback(true)
        {
            @Override
            public void handleOnBackPressed()
            {
                if (drawer.isDrawerOpen(GravityCompat.START))
                {
                    drawer.closeDrawer(GravityCompat.START);

                }
                else if(cardView.isShown())
                {
                    cardView.setVisibility(View.GONE);
                    fab.setVisibility(View.GONE);
                    overlay.setVisibility(View.GONE);
                    view.stopPlayback();
                    view.setVisibility(View.GONE);
                }
                else
                {
                    // default behavior (like old super.onBackPressed)
                    setEnabled(false);
                    activity.getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });
    }
}