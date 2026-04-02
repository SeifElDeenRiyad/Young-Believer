package com.example.youngbeliever.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.StoriesModel;

import java.util.ArrayList;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder>
{
    ArrayList<StoriesModel> storyList = new ArrayList<>();
    itemClickListener itemClickListener;

    @NonNull
    @Override
    public StoriesAdapter.StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new StoriesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.stories_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesAdapter.StoriesViewHolder holder, int position)
    {
        holder.storyName.setText(storyList.get(position).getStoryName());

        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClick(storyList.get(position)));
    }

    @Override
    public int getItemCount()
    {
        return storyList.size();
    }

    public interface itemClickListener
    {
        void onItemClick(StoriesModel storiesModel);
    }

    public void setList(ArrayList<StoriesModel> storyList, itemClickListener itemClickListener)
    {
        this.storyList = storyList;
        this.itemClickListener = itemClickListener;
        notifyDataSetChanged();
    }

    public static class StoriesViewHolder extends RecyclerView.ViewHolder
    {
        TextView storyName;
        public StoriesViewHolder(@NonNull View itemView)
        {
            super(itemView);
            storyName = itemView.findViewById(R.id.story_name);
        }
    }
}
