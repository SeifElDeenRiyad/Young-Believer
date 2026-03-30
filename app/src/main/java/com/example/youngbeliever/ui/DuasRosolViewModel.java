package com.example.youngbeliever.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.DuasModel;

import java.util.ArrayList;

public class DuasRosolViewModel extends ViewModel
{
    public MutableLiveData<ArrayList<DuasModel>> duaData = new MutableLiveData<>();

    public void getRosolDua()
    {
        duaData.setValue(getDuaFromDataBase());
    }

    private ArrayList<DuasModel> getDuaFromDataBase()
    {
        ArrayList<DuasModel> duasList = new ArrayList<>();
        duasList.add(new DuasModel(R.drawable.adam, R.string.rosl_dua1, R.string.rosl_dua_info1, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.noah, R.string.rosl_dua2, R.string.rosl_dua_info2, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.ibrahim, R.string.rosl_dua3, R.string.rosl_dua_info3, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.hood, R.string.rosl_dua4, R.string.rosl_dua_info4, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.lot, R.string.rosl_dua5, R.string.rosl_dua_info5, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.yousef, R.string.rosl_dua6, R.string.rosl_dua_info6, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.sho3eb, R.string.rosl_dua7, R.string.rosl_dua_info7, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.mousa, R.string.rosl_dua8, R.string.rosl_dua_info8, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.ayoub, R.string.rosl_dua9, R.string.rosl_dua_info9, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.solaiman, R.string.rosl_dua10, R.string.rosl_dua_info10, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.younes, R.string.rosl_dua11, R.string.rosl_dua_info11, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.zakaria, R.string.rosl_dua12, R.string.rosl_dua_info12, R.string.bsmla));
        duasList.add(new DuasModel(R.drawable.yakoub, R.string.rosl_dua13, R.string.rosl_dua_info13, R.string.bsmla));
        return duasList;
    }
}