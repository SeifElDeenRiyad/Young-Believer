package com.example.youngbeliever.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.AzkarModel;

import java.util.ArrayList;

public class AzkarAdapter extends RecyclerView.Adapter<AzkarAdapter.AzkarViewHolder>
{
    private ArrayList<AzkarModel> azkarList = new ArrayList<>();
    private AzkarAdapter.itemClickListener itemClickListener;

    @NonNull
    @Override
    public AzkarAdapter.AzkarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new AzkarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.azkar_item, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull AzkarAdapter.AzkarViewHolder holder, int position)
    {
        if(azkarList.get(position).getBsmla() == 0)
        {
            holder.bsmla.setVisibility(View.GONE);
        }
        else
        {
            holder.bsmla.setVisibility(View.VISIBLE);
            holder.bsmla.setText(azkarList.get(position).getBsmla());
        }
        holder.zekrTimes.setText(azkarList.get(position).getZekrTimes());
        holder.zekr.setText(azkarList.get(position).getZekr());
        holder.zekrReward.setText(azkarList.get(position).getZekrReward());

        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClick(azkarList.get(position)));
    }
    @Override
    public int getItemCount()
    {
        return azkarList.size();
    }
    public void setList(ArrayList<AzkarModel> azkarList, AzkarAdapter.itemClickListener itemClickListener)
    {
        this.azkarList = azkarList;
        this.itemClickListener = itemClickListener;
        notifyDataSetChanged();
    }
    public interface itemClickListener
    {
        void onItemClick(AzkarModel AzkarModel);
    }
    public static class AzkarViewHolder extends RecyclerView.ViewHolder
    {
        TextView zekrTimes, zekr, zekrReward, bsmla;
        public AzkarViewHolder(@NonNull View itemView)
        {
            super(itemView);
            zekrTimes = itemView.findViewById(R.id.zekr_times);
            bsmla = itemView.findViewById(R.id.bsmla);
            zekr = itemView.findViewById(R.id.zekr);
            zekrReward = itemView.findViewById(R.id.zekr_reward);
        }
    }
}