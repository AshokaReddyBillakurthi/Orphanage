package com.orphanage.apps.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orphanage.apps.HomeActivity;
import com.orphanage.apps.R;
import com.orphanage.apps.fragments.FeatureCharitiesDetailsFragment;

public class FeatureCharitiesAdapter extends RecyclerView.Adapter<FeatureCharitiesAdapter.FeatureCharitiesViewHolder>{

    private Context mContext;

    public FeatureCharitiesAdapter(Context context){
        this.mContext = context;
    }

    @NonNull
    @Override
    public FeatureCharitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_charities_item_cell,parent,false);
        return new FeatureCharitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeatureCharitiesViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mContext.getResources().getDrawable(R.drawable.home_page_banner))
                .into(holder.ivCharitieImg);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class FeatureCharitiesViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivCharitieImg;
        public FeatureCharitiesViewHolder(final View itemView) {
            super(itemView);
            ivCharitieImg = itemView.findViewById(R.id.ivCharitieImg);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragment = new FeatureCharitiesDetailsFragment();
                    ((HomeActivity)itemView.getContext()).loadFragment(fragment);
                }
            });
        }
    }
}
