package com.orphanage.apps.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orphanage.apps.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>{

    private List<Drawable> drawableList;
    private Context mContext;

    public GalleryAdapter(Context context){
        this.drawableList = new ArrayList<>();
        this.mContext = context;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item_cell,parent,false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Glide.with(mContext)
                .load(drawableList.get(position))
                .into(holder.ivCharitieImg);
    }

    public void refresh(List<Drawable> drawableList){
        this.drawableList = drawableList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return drawableList.size();
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder{

        ImageView ivCharitieImg;
        public GalleryViewHolder(View itemView) {
            super(itemView);
            ivCharitieImg = itemView.findViewById(R.id.ivCharitieImg);
        }
    }
}
