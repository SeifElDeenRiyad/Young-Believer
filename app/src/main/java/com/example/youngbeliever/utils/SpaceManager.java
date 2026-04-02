package com.example.youngbeliever.utils;

import android.view.View;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//helper class to make sure the bottom content of the app does
//overlap with the bottom system bars
public class SpaceManager
{
    //Sets padding at the bottom of the scroll view to avoid lost text in the systems bars.
    public void setBottomPadding(ScrollView scrollView)
    {
        //initial padding from the view itself
        int initialBottomPadding = scrollView.getPaddingBottom();

        //apply the listener on the scroll view
        ViewCompat.setOnApplyWindowInsetsListener(scrollView, new OnApplyWindowInsetsListener()
        {
            @NonNull
            @Override
            public WindowInsetsCompat onApplyWindowInsets(@NonNull View v, @NonNull WindowInsetsCompat insets)
            {
                //gets initial system bars values
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

                //apply the initial + the system bars padding at the bottom
                v.setPadding(
                        v.getPaddingLeft(),
                        v.getPaddingTop(),
                        v.getPaddingRight(),
                        initialBottomPadding + systemBars.bottom
                );
                return insets;
            }
        });
    }
}