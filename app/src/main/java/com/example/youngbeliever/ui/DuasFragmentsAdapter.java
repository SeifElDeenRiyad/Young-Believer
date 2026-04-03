package com.example.youngbeliever.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class DuasFragmentsAdapter extends FragmentStateAdapter
{
    public DuasFragmentsAdapter(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        return switch (position)
        {
            case 0 -> new DuasQuranFragment();
            case 1 -> new DuasRasolFragment();
            case 2 -> new DuasRosolFragment();
            default ->throw new IllegalArgumentException("Invalid position");
        };
    }

    @Override
    public int getItemCount()
    {
        return 3;
    }
}