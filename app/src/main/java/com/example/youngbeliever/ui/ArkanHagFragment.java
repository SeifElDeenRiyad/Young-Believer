package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.youngbeliever.R;
import com.example.youngbeliever.utils.SpaceManager;

public class ArkanHagFragment extends Fragment
{
    public ArkanHagFragment()
    {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.arkan_hag_layout, container, false);
        ScrollView scrollView = root.findViewById(R.id.arkan_hajj_scroll);

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(scrollView);

        return root;
    }
}