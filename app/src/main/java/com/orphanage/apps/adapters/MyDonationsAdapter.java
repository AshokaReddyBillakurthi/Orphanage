package com.orphanage.apps.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orphanage.apps.R;

public class MyDonationsAdapter extends RecyclerView.Adapter<MyDonationsAdapter.MyDonationsViewHolder>{

    @NonNull
    @Override
    public MyDonationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mydonations_list_item_cell,
                parent,false);
        return new MyDonationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDonationsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class MyDonationsViewHolder extends RecyclerView.ViewHolder{

        public MyDonationsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
