package com.example.youngbeliever.utils;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.ui.ArkanSlahActivity;
import com.example.youngbeliever.ui.AzkarAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class FragmentSetter
{
    public View setupFragment(LayoutInflater inflater, ViewGroup container, int layoutResId, int scrollViewId, int slahWayButtonId)
    {
        View root = inflater.inflate(layoutResId, container, false);
        ScrollView scrollView = root.findViewById(scrollViewId);

        if (slahWayButtonId != 0)
        {
            ExtendedFloatingActionButton slahWayButton = root.findViewById(slahWayButtonId);
            slahWayButton.setOnClickListener(view ->
                    view.getContext().startActivity(new Intent(view.getContext(), ArkanSlahActivity.class)));
        }

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(scrollView);

        return root;
    }
    public View setupRecyclerFragment(LayoutInflater inflater, ViewGroup container, int layoutResId, int recyclerId)
    {
        View root = inflater.inflate(layoutResId, container, false);

        RecyclerView recycler = root.findViewById(recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(root.getContext()));

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(recycler);

        return root;
    }
}