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
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.DuasModel;
import com.example.youngbeliever.utils.FragmentSetter;

import java.util.ArrayList;

public class DuasRosolFragment extends Fragment
{
    public DuasRosolFragment()
    {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        FragmentSetter fragmentSetter = new FragmentSetter();
        DuasRosolViewModel duasRosolViewModel = new ViewModelProvider(this).get(DuasRosolViewModel.class);

        View rootView = fragmentSetter.setupRecyclerFragment(inflater, container, R.layout.duas_list, R.id.duas_recycler);

        RecyclerView duasRosolRecycler = rootView.findViewById(R.id.duas_recycler);
        DuasAdapter adapter = new DuasAdapter();
        duasRosolRecycler.setAdapter(adapter);
        //azkarRosolRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        duasRosolViewModel.getRosolDua();
        duasRosolViewModel.duaData.observe(getViewLifecycleOwner(), new Observer<ArrayList<DuasModel>>()
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