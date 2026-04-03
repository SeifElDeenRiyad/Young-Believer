package com.example.youngbeliever.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.HomeModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>
{
    private ArrayList<HomeModel> sectionList = new ArrayList<>();
    private itemClickListener itemClickListener;
    //inflates the view
    @NonNull
    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new HomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false));
    }
    //Setting date at view and right position && captureClicks
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position)
    {
        holder.sectionImage.setImageResource(sectionList.get(position).getSectionImage());
        holder.sectionName.setText(sectionList.get(position).getSectionName());

        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClick(sectionList.get(position)));
    }
    //return the whole list
    @Override
    public int getItemCount()
    {
        return sectionList.size();
    }
    //set the data in the recycler
    public void setList(ArrayList<HomeModel> sectionList, itemClickListener itemClickListener)
    {
        this.sectionList = sectionList;
        this.itemClickListener = itemClickListener;
        notifyDataSetChanged();
    }
    //Interface for ClickListener
    public interface itemClickListener
    {
        void onItemClick(HomeModel homeModel);
    }
    //holds the views
    public static class HomeViewHolder extends RecyclerView.ViewHolder
    {
        ImageView sectionImage;
        TextView sectionName;
        public HomeViewHolder(@NonNull View itemView)
        {
            super(itemView);
            sectionImage = itemView.findViewById(R.id.section_image);
            sectionName = itemView.findViewById(R.id.section_name);
        }
    }
}