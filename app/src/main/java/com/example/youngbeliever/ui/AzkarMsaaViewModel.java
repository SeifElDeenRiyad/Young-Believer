package com.example.youngbeliever.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.AzkarModel;

import java.util.ArrayList;

public class AzkarMsaaViewModel extends ViewModel
{
    public MutableLiveData<ArrayList<AzkarModel>> azkarMsaaList = new MutableLiveData<>();

    public void getAzkarMsaaList()
    {
        azkarMsaaList.setValue(getAzkarMsaaListFromDatabase());
    }

    private ArrayList<AzkarModel> getAzkarMsaaListFromDatabase()
    {
        ArrayList<AzkarModel> azkarModels = new ArrayList<>();
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times1, R.string.bsmla, R.string.msaa_zekr1, R.string.msaa_zekr_reward1));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times2, R.string.bsmla, R.string.msaa_zekr2, R.string.msaa_zekr_reward2));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times3, R.string.bsmla, R.string.msaa_zekr3, R.string.msaa_zekr_reward3));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times4, R.string.bsmla, R.string.msaa_zekr4, R.string.msaa_zekr_reward3));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times5, R.string.bsmla, R.string.msaa_zekr5, R.string.msaa_zekr_reward3));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times6, 0, R.string.msaa_zekr6, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times7, 0, R.string.msaa_zekr7, R.string.msaa_zekr_reward7));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times8, 0, R.string.msaa_zekr8, R.string.msaa_zekr_reward8));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times9, 0, R.string.msaa_zekr9, R.string.msaa_zekr_reward9));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times10, 0, R.string.msaa_zekr10, R.string.msaa_zekr_reward10));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times11, 0, R.string.msaa_zekr11, R.string.msaa_zekr_reward11));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times12, 0, R.string.msaa_zekr12, R.string.msaa_zekr_reward12));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times13, 0, R.string.msaa_zekr13, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times14, 0, R.string.msaa_zekr14, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times15, 0, R.string.msaa_zekr15, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times16, 0, R.string.msaa_zekr16, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times17, 0, R.string.msaa_zekr17, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times18, 0, R.string.msaa_zekr18, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times19, 0, R.string.msaa_zekr19, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times20, 0, R.string.msaa_zekr20, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times21, 0, R.string.msaa_zekr21, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times22, 0, R.string.msaa_zekr22, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times23, 0, R.string.msaa_zekr23, R.string.msaa_zekr_reward23));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times24, 0, R.string.msaa_zekr24, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times25, 0, R.string.msaa_zekr25, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times26, 0, R.string.msaa_zekr26, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times27, 0, R.string.msaa_zekr27, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times28, 0, R.string.msaa_zekr28, R.string.msaa_zekr_reward28));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times29, 0, R.string.msaa_zekr29, R.string.msaa_zekr_reward29));
        azkarModels.add(new AzkarModel(R.string.msaa_zekr_times30, 0, R.string.msaa_zekr30, R.string.msaa_zekr_reward30));
        return azkarModels;
    }
}
