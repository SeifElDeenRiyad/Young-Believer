package com.example.youngbeliever.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.StoriesModel;

import java.util.ArrayList;

public class StoriesViewModel extends ViewModel
{
    public MutableLiveData<ArrayList<StoriesModel>> storiesData = new MutableLiveData<>();

    public void getStoryData()
    {
        storiesData.setValue(getStoryDataFromDataBase());
    }

    private ArrayList<StoriesModel> getStoryDataFromDataBase()
    {
        ArrayList<StoriesModel> storiesModel = new ArrayList<>();
        storiesModel.add(new StoriesModel(R.string.prophets_stories1, "stories/adam.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories2, "stories/nooh.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories3, "stories/edres.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories4, "stories/hood.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories5, "stories/saleh.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories6, "stories/ibrahimismail.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories7, "stories/loot.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories8, "stories/eshaqyaakob.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories9, "stories/yosef.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories10, "stories/shoeb.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories11, "stories/ayob.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories12, "stories/yones.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories13, "stories/moosaharoon.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories14, "stories/dawod.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories15, "stories/soliman.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories16, "stories/elias.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories17, "stories/elyasa.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories18, "stories/zykefl.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories19, "stories/zakryayehia.pdf"));
        storiesModel.add(new StoriesModel(R.string.prophets_stories20, "stories/esa.pdf"));
        return storiesModel;
    }
}