package com.example.youngbeliever.utils;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//helper class to  does not overlap with the bottom system bars
public class SpaceManager
{
    //Sets padding at the bottom of the view to avoid lost text in the systems bars.
    public void setBottomPadding(View view)
    {
        //initial padding from the view itself
        int initialBottomPadding = view.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener()
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