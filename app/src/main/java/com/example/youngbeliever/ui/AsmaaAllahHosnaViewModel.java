package com.example.youngbeliever.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.AsmaaAllahHosnaModel;

import java.util.ArrayList;

public class AsmaaAllahHosnaViewModel extends ViewModel
{
    public MutableLiveData<ArrayList<AsmaaAllahHosnaModel>> asmAllahData = new MutableLiveData<>();

    public void getAsmaaAllah()
    {
        asmAllahData.setValue(getAsmAllahFromDataBase());
    }

    private ArrayList<AsmaaAllahHosnaModel> getAsmAllahFromDataBase()
    {
        ArrayList<AsmaaAllahHosnaModel> asmaaAllahData = new ArrayList<>();
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm1, R.string.asm_meaning1));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm2, R.string.asm_meaning2));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm3, R.string.asm_meaning3));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm4, R.string.asm_meaning4));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm5, R.string.asm_meaning5));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm6, R.string.asm_meaning6));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm7, R.string.asm_meaning7));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm8, R.string.asm_meaning8));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm9, R.string.asm_meaning9));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm10, R.string.asm_meaning10));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm11, R.string.asm_meaning11));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm12, R.string.asm_meaning12));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm13, R.string.asm_meaning13));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm14, R.string.asm_meaning14));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm15, R.string.asm_meaning15));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm16, R.string.asm_meaning16));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm17, R.string.asm_meaning17));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm18, R.string.asm_meaning18));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm19, R.string.asm_meaning19));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm20, R.string.asm_meaning20));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm21, R.string.asm_meaning21));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm22, R.string.asm_meaning22));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm23, R.string.asm_meaning23));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm24, R.string.asm_meaning24));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm25, R.string.asm_meaning25));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm26, R.string.asm_meaning26));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm27, R.string.asm_meaning27));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm28, R.string.asm_meaning28));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm29, R.string.asm_meaning29));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm30, R.string.asm_meaning30));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm31, R.string.asm_meaning31));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm32, R.string.asm_meaning32));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm33, R.string.asm_meaning33));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm34, R.string.asm_meaning34));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm35, R.string.asm_meaning35));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm36, R.string.asm_meaning36));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm37, R.string.asm_meaning37));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm38, R.string.asm_meaning38));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm39, R.string.asm_meaning39));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm40, R.string.asm_meaning40));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm41, R.string.asm_meaning41));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm42, R.string.asm_meaning42));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm43, R.string.asm_meaning43));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm44, R.string.asm_meaning44));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm45, R.string.asm_meaning45));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm46, R.string.asm_meaning46));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm47, R.string.asm_meaning47));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm48, R.string.asm_meaning48));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm49, R.string.asm_meaning49));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm50, R.string.asm_meaning50));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm51, R.string.asm_meaning51));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm52, R.string.asm_meaning52));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm53, R.string.asm_meaning53));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm54, R.string.asm_meaning54));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm55, R.string.asm_meaning55));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm56, R.string.asm_meaning56));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm57, R.string.asm_meaning57));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm58, R.string.asm_meaning58));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm59, R.string.asm_meaning59));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm60, R.string.asm_meaning60));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm61, R.string.asm_meaning61));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm62, R.string.asm_meaning62));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm63, R.string.asm_meaning63));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm64, R.string.asm_meaning64));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm65, R.string.asm_meaning65));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm66, R.string.asm_meaning66));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm67, R.string.asm_meaning67));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm68, R.string.asm_meaning68));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm69, R.string.asm_meaning69));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm70, R.string.asm_meaning70));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm71, R.string.asm_meaning71));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm72, R.string.asm_meaning72));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm73, R.string.asm_meaning73));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm74, R.string.asm_meaning74));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm75, R.string.asm_meaning75));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm76, R.string.asm_meaning76));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm77, R.string.asm_meaning77));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm78, R.string.asm_meaning78));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm79, R.string.asm_meaning79));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm80, R.string.asm_meaning80));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm81, R.string.asm_meaning81));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm82, R.string.asm_meaning82));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm83, R.string.asm_meaning83));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm84, R.string.asm_meaning84));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm85, R.string.asm_meaning85));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm86, R.string.asm_meaning86));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm87, R.string.asm_meaning87));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm88, R.string.asm_meaning88));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm89, R.string.asm_meaning89));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm90, R.string.asm_meaning90));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm91, R.string.asm_meaning91));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm92, R.string.asm_meaning92));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm93, R.string.asm_meaning93));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm94, R.string.asm_meaning94));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm95, R.string.asm_meaning95));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm96, R.string.asm_meaning96));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm97, R.string.asm_meaning97));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm98, R.string.asm_meaning98));
        asmaaAllahData.add(new AsmaaAllahHosnaModel(R.string.asm99, R.string.asm_meaning99));
        return asmaaAllahData;
    }
}