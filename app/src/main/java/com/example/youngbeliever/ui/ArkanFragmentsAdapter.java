package com.example.youngbeliever.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ArkanFragmentsAdapter  extends FragmentStateAdapter
{
    public ArkanFragmentsAdapter(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        return switch (position) {
            case 0 -> new ArkanShhadeFragment();
            case 1 -> new ArkanSlahFragment();
            case 2 -> new ArkanZkahFragment();
            case 3 -> new ArkanSomFragment();
            case 4 -> new ArkanHagFragment();
            default ->throw new IllegalArgumentException("Invalid position");
        };
    }
    @Override
    public int getItemCount()
    {
        return 5;
    }
}