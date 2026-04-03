package com.example.youngbeliever.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.HomeModel;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel
{
    public MutableLiveData<ArrayList<HomeModel>> homeSections = new MutableLiveData<>();

    public void getHomeSections()
    {
        homeSections.setValue(getHomeSectionsFromDatabase());
    }

    private ArrayList<HomeModel> getHomeSectionsFromDatabase()
    {
        ArrayList<HomeModel> sectionList = new ArrayList<>();
        sectionList.add(new HomeModel(R.drawable.holy_quran_image, R.string.holy_quran));
        sectionList.add(new HomeModel(R.drawable.arkaneslam, R.string.islam_pillars));
        sectionList.add(new HomeModel(R.drawable.azkar, R.string.al_azkar));
        sectionList.add(new HomeModel(R.drawable.duas, R.string.duas));
        sectionList.add(new HomeModel(R.drawable.qess_rosl, R.string.prophets_stories));
        sectionList.add(new HomeModel(R.drawable.asmaaallah, R.string.asmaa_allah_hosna));
        return sectionList;
    }
}