package com.example.youngbeliever.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.AsmaaAllahHosnaModel;

import java.util.ArrayList;

public class AsmaaAllahHosnaAdapter extends RecyclerView.Adapter<AsmaaAllahHosnaAdapter.AsmaaAllahHosnaViewHolder>
{
    private ArrayList<AsmaaAllahHosnaModel> AsmaaAllah = new ArrayList<>();
    private itemClickListener itemClickListener;
    @NonNull
    @Override
    public AsmaaAllahHosnaAdapter.AsmaaAllahHosnaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new AsmaaAllahHosnaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.asma_allah_hosna_item, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull AsmaaAllahHosnaAdapter.AsmaaAllahHosnaViewHolder holder, int position)
    {
        holder.asmAllah.setText(AsmaaAllah.get(position).getAsmAllah());

        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClick(AsmaaAllah.get(position)));
    }
    @Override
    public int getItemCount()
    {
        return AsmaaAllah.size();
    }
    public void setList(ArrayList<AsmaaAllahHosnaModel> asmaAllah, AsmaaAllahHosnaAdapter.itemClickListener itemClickListener)
    {
        this.AsmaaAllah = asmaAllah;
        this.itemClickListener = itemClickListener;
        notifyDataSetChanged();
    }
    public interface itemClickListener
    {
        void onItemClick(AsmaaAllahHosnaModel asmaaAllahModel);
    }
    public static class AsmaaAllahHosnaViewHolder extends RecyclerView.ViewHolder
    {
        TextView asmAllah;
        public AsmaaAllahHosnaViewHolder(@NonNull View itemView)
        {
            super(itemView);
            asmAllah = itemView.findViewById(R.id.asm_allah);
        }
    }
}
