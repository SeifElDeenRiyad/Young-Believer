package com.example.youngbeliever.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.ArkanSlahModel;

import java.util.ArrayList;

public class ArkanSlahViewModel extends ViewModel
{
    public MutableLiveData<ArrayList<ArkanSlahModel>> slahWay = new MutableLiveData<>();

    public void getSlahWay()
    {
        slahWay.setValue(getSlahWayFromDataBase());
    }

    private ArrayList<ArkanSlahModel> getSlahWayFromDataBase()
    {
        ArrayList<ArkanSlahModel> slahModels = new ArrayList<>();
        slahModels.add(new ArkanSlahModel(R.string.slah_way_1));
        slahModels.add(new ArkanSlahModel(R.string.slah_way_2));
        slahModels.add(new ArkanSlahModel(R.string.slah_way_3));
        slahModels.add(new ArkanSlahModel(R.string.slah_way_4));
        slahModels.add(new ArkanSlahModel(R.string.slah_way_5));
        slahModels.add(new ArkanSlahModel(R.string.slah_way_6));
        slahModels.add(new ArkanSlahModel(R.string.slah_way_7));
        slahModels.add(new ArkanSlahModel(R.string.slah_way_8));
        slahModels.add(new ArkanSlahModel(R.string.slah_way_9));
        slahModels.add(new ArkanSlahModel(R.string.slah_way_10));
        slahModels.add(new ArkanSlahModel(R.string.slah_way_11));
        return slahModels;
    }
}
