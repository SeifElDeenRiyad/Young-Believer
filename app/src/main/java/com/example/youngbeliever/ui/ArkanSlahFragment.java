package com.example.youngbeliever.ui;

import android.content.Intent;
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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ArkanSlahFragment extends Fragment
{
    public ArkanSlahFragment()
    {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.arkan_slah_layout, container, false);
        ScrollView view = rootView.findViewById(R.id.arkan_slah_scroll);
        ExtendedFloatingActionButton fab = rootView.findViewById(R.id.salah_breakdown_btn);

        fab.setOnClickListener(view1 ->
        {
            Intent intent = new Intent(requireActivity(), ArkanSlahActivity.class);
            startActivity(intent);
        });

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(view);

        return rootView;
    }
}