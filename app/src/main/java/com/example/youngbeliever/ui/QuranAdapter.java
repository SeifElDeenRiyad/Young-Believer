package com.example.youngbeliever.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.QuranModel;

import java.util.ArrayList;

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.QuranViewHolder>
{
    ArrayList<QuranModel> suras = new ArrayList<>();
    itemClickListener itemClickListener;
    @NonNull
    @Override
    public QuranAdapter.QuranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new QuranViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_item, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull QuranAdapter.QuranViewHolder holder, int position)
    {
        holder.suraNum.setText(suras.get(position).getSuraNum());
        holder.suraName.setText(suras.get(position).getSuraName());
        holder.suraRevelation.setText(suras.get(position).getSuraRevelation());
        holder.suraAyahNum.setText(suras.get(position).getSuraAyahNum());

        holder.itemView.setOnClickListener(v -> itemClickListener.onItemCLick(suras.get(position)));
    }
    @Override
    public int getItemCount()
    {
        return suras.size();
    }
    public void setList(ArrayList<QuranModel> quranModel, itemClickListener itemClickListener)
    {
        this.suras = quranModel;
        this.itemClickListener = itemClickListener;
        notifyDataSetChanged();
    }
    public interface itemClickListener
    {
        void onItemCLick(QuranModel quranModel);
    }
    public static class QuranViewHolder extends RecyclerView.ViewHolder
    {
        TextView suraNum, suraName, suraRevelation, suraAyahNum;
        public QuranViewHolder(@NonNull View itemView)
        {
            super(itemView);
            suraNum = itemView.findViewById(R.id.sura_num);
            suraName = itemView.findViewById(R.id.sura_name);
            suraRevelation = itemView.findViewById(R.id.sura_revelation);
            suraAyahNum = itemView.findViewById(R.id.sura_ayah_num);
        }
    }
}