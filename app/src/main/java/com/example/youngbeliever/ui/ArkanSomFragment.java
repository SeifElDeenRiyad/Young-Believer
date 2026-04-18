package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.youngbeliever.R;
import com.example.youngbeliever.utils.FragmentSetter;

public class ArkanSomFragment extends Fragment
{
    public ArkanSomFragment()
    {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        FragmentSetter fragmentSetter = new FragmentSetter();
        return fragmentSetter.setupFragment(inflater, container, R.layout.arkan_som_layout, R.id.arkan_som_scroll, 0);
    }
}