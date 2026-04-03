package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.DuasModel;
import com.example.youngbeliever.utils.SpaceManager;

import java.util.ArrayList;

public class DuasQuranFragment extends Fragment
{
    public DuasQuranFragment()
    {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.duas_list, container, false);
        DuasQuranViewModel duasQuranViewModel = new ViewModelProvider(this).get(DuasQuranViewModel.class);

        RecyclerView duasQuranRecycler = rootView.findViewById(R.id.duas_recycler);

        DuasAdapter adapter = new DuasAdapter();
        duasQuranRecycler.setAdapter(adapter);
        duasQuranRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        //duasQuranRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(duasQuranRecycler);

        duasQuranViewModel.getQuranDua();
        duasQuranViewModel.duaData.observe(getViewLifecycleOwner(), new Observer<ArrayList<DuasModel>>()
        {
            @Override
            public void onChanged(ArrayList<DuasModel> duasModels)
            {
                adapter.setList(duasModels, new DuasAdapter.itemClickListener()
                {
                    @Override
                    public void onItemClick(DuasModel DuasModel)
                    {
                    }
                });
            }
        });
        return rootView;
    }
}