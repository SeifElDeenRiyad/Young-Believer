package com.example.youngbeliever.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.DuasModel;

import java.util.ArrayList;

public class DuasAdapter extends RecyclerView.Adapter<DuasAdapter.DuasViewHolder>
{
    private ArrayList<DuasModel> duasList = new ArrayList<>();
    private DuasAdapter.itemClickListener itemClickListener;

    @NonNull
    @Override
    public DuasAdapter.DuasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new DuasViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.duas_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DuasAdapter.DuasViewHolder holder, int position)
    {
        if(duasList.get(position).hasImage())
        {
            holder.duaProphet.setImageResource(duasList.get(position).getDuaProphet());
            holder.duaProphet.setVisibility(View.VISIBLE);
        }
        else {
            holder.duaProphet.setVisibility(View.GONE);
        }

        if(duasList.get(position).hasBsmla())
        {
            holder.bsmla.setText(duasList.get(position).getBsmla());
            holder.bsmla.setVisibility(View.VISIBLE);
        }
        else {
            holder.bsmla.setVisibility(View.GONE);
        }

        holder.dua.setText(duasList.get(position).getDua());
        holder.duaInfo.setText(duasList.get(position).getDuaInfo());

        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClick(duasList.get(position)));
    }

    @Override
    public int getItemCount()
    {
        return duasList.size();
    }

    public void setList(ArrayList<DuasModel> duasList, DuasAdapter.itemClickListener itemClickListener)
    {
        this.duasList = duasList;
        this.itemClickListener = itemClickListener;
        notifyDataSetChanged();
    }

    public interface itemClickListener
    {
        void onItemClick(DuasModel DuasModel);
    }

    public static class DuasViewHolder extends RecyclerView.ViewHolder
    {
        TextView dua, duaInfo, bsmla;
        ImageView duaProphet;
        public DuasViewHolder(@NonNull View itemView)
        {
            super(itemView);
            dua = itemView.findViewById(R.id.dua);
            duaInfo = itemView.findViewById(R.id.dua_info);
            duaProphet = itemView.findViewById(R.id.dua_prophet);
            bsmla = itemView.findViewById(R.id.bsmla);
        }
    }
}