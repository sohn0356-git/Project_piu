package com.mp.piu_mobile_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.CustomViewHolder> {
    private ArrayList<Sheet> arrayList;
    private Context context;

    public SongAdapter(ArrayList<Sheet> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_song, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getAlbum())
                .into(holder.iv_album);
        holder.tv_title.setText(arrayList.get(position).getTitle());
        holder.tv_artist.setText(arrayList.get(position).getArtist());
        holder.tv_bpm.setText(arrayList.get(position).getBpm());
        holder.tv_level_s.setText(arrayList.get(position).getLevel_s());

        String[] level_s = arrayList.get(position).getLevel_s().split(String.valueOf(','));
        int[] num_s = new int[level_s.length];
        for(int i=0;i<level_s.length; i++){
            num_s[i] = Integer.parseInt(level_s[i]);
        }
    }

    @Override
    public int getItemCount() {
        return (arrayList!=null ? arrayList.size():0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        ImageView iv_album;
        TextView tv_title;
        TextView tv_artist;
        TextView tv_bpm;
        TextView tv_level_s;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.iv_album = itemView.findViewById(R.id.iv_album);
            this.tv_title = itemView.findViewById(R.id.tv_title);
            this.tv_artist = itemView.findViewById(R.id.tv_artist);
            this.tv_bpm = itemView.findViewById(R.id.tv_bpm);
            this.tv_level_s = itemView.findViewById(R.id.tv_level_s);
        }
    }
}
