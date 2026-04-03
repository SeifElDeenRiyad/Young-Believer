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
import com.example.youngbeliever.models.AzkarModel;
import com.example.youngbeliever.utils.SpaceManager;

import java.util.ArrayList;

public class AzkarMsaaFragment extends Fragment
{
    public AzkarMsaaFragment()
    {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.azkar_list, container, false);
        AzkarMsaaViewModel azkarMsaaViewModel = new ViewModelProvider(this).get(AzkarMsaaViewModel.class);

        RecyclerView azkarMsaaRecycler = rootView.findViewById(R.id.azkar_recycler);

        AzkarAdapter adapter = new AzkarAdapter();
        azkarMsaaRecycler.setAdapter(adapter);
        azkarMsaaRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        //azkarMsaaRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(azkarMsaaRecycler);

        azkarMsaaViewModel.getAzkarMsaaList();
        azkarMsaaViewModel.azkarMsaaList.observe(getViewLifecycleOwner(), new Observer<ArrayList<AzkarModel>>()
        {
            @Override
            public void onChanged(ArrayList<AzkarModel> azkarModels)
            {
                adapter.setList(azkarModels, new AzkarAdapter.itemClickListener()
                {
                    @Override
                    public void onItemClick(AzkarModel AzkarModel)
                    {
                    }
                });
            }
        });
        return rootView;
    }
}