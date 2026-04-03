package com.example.youngbeliever.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.ArkanSlahModel;

import java.util.ArrayList;

public class ArkanSlahAdapter extends RecyclerView.Adapter<ArkanSlahAdapter.ArkanSlahViewHolder>
{
    ArrayList<ArkanSlahModel> slahsList = new ArrayList<>();
    itemClickListener itemClickListener;
    @NonNull
    @Override
    public ArkanSlahAdapter.ArkanSlahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new ArkanSlahViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.arkan_slah_item, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull ArkanSlahAdapter.ArkanSlahViewHolder holder, int position)
    {
        holder.slahWay.setText(slahsList.get(position).getSlahWay());

        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClick(slahsList.get(position)));
    }
    @Override
    public int getItemCount()
    {
        return slahsList.size();
    }
    public void setList(ArrayList<ArkanSlahModel> arkanSlahModels, itemClickListener itemClickListener)
    {
        this.slahsList = arkanSlahModels;
        this.itemClickListener = itemClickListener;
        notifyDataSetChanged();
    }
    public interface itemClickListener
    {
        void onItemClick(ArkanSlahModel arkanSlahModel);
    }
    public static class ArkanSlahViewHolder extends RecyclerView.ViewHolder
    {
        TextView slahWay;
        public ArkanSlahViewHolder(@NonNull View itemView)
        {
            super(itemView);
            slahWay = itemView.findViewById(R.id.slah_video_title);
        }
    }
}