package com.example.youngbeliever.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.AzkarModel;

import java.util.ArrayList;

public class AzkarSbahViewModel extends ViewModel
{
    public MutableLiveData<ArrayList<AzkarModel>> azkarSbahList = new MutableLiveData<>();

    public void getAzkarSbahList()
    {
        azkarSbahList.setValue(setAzkarSbahFromDatabase());
    }

    private ArrayList<AzkarModel> setAzkarSbahFromDatabase()
    {
        ArrayList<AzkarModel> azkarModels = new ArrayList<>();
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times1, R.string.bsmla, R.string.sbah_zekr1, R.string.sbah_zekr_reward1));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times2, R.string.bsmla, R.string.sbah_zekr2, R.string.sbah_zekr_reward2));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times3, R.string.bsmla, R.string.sbah_zekr3, R.string.sbah_zekr_reward2));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times4, R.string.bsmla, R.string.sbah_zekr4, R.string.sbah_zekr_reward2));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times5, 0, R.string.sbah_zekr5, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times6, 0, R.string.sbah_zekr6, R.string.sbah_zekr_reward6));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times7, 0, R.string.sbah_zekr7, R.string.sbah_zekr_reward7));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times8, 0, R.string.sbah_zekr8, R.string.sbah_zekr_reward8));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times9, 0, R.string.sbah_zekr9, R.string.sbah_zekr_reward9));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times10, 0, R.string.sbah_zekr10, R.string.sbah_zekr_reward10));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times11, 0, R.string.sbah_zekr11, R.string.sbah_zekr_reward11));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times12, 0, R.string.sbah_zekr12, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times13, 0, R.string.sbah_zekr13, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times14, 0, R.string.sbah_zekr14, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times15, 0, R.string.sbah_zekr15, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times16, 0, R.string.sbah_zekr16, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times17, 0, R.string.sbah_zekr17, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times18, 0, R.string.sbah_zekr18, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times19, 0, R.string.sbah_zekr19, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times20, 0, R.string.sbah_zekr20, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times21, 0, R.string.sbah_zekr21, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times22, 0, R.string.sbah_zekr22, R.string.sbah_zekr_reward22));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times23, 0, R.string.sbah_zekr23, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times24, 0, R.string.sbah_zekr24, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times25, 0, R.string.sbah_zekr25, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times26, 0, R.string.sbah_zekr26, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times27, 0, R.string.sbah_zekr27, R.string.zekr_general_reward));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times28, 0, R.string.sbah_zekr28, R.string.sbah_zekr_reward28));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times29, 0, R.string.sbah_zekr29, R.string.sbah_zekr_reward29));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times30, 0, R.string.sbah_zekr30, R.string.sbah_zekr_reward30));
        azkarModels.add(new AzkarModel(R.string.sbah_zekr_times31, 0, R.string.sbah_zekr31, R.string.sbah_zekr_reward31));
        return azkarModels;
    }
}
