package com.orphanage.apps.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orphanage.apps.HomeActivity;
import com.orphanage.apps.R;
import com.orphanage.apps.adapters.MyDonationsAdapter;

public class MyDonationsFragment extends BaseFragment {

    private RecyclerView rvMyDonations;
    private MyDonationsAdapter myDonationsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mydonations,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity)getContext()).tvScreenTitle.setText("My Donations");

        rvMyDonations = view.findViewById(R.id.rvMyDonations);
        rvMyDonations.setLayoutManager(new LinearLayoutManager(getContext()));
        myDonationsAdapter = new MyDonationsAdapter();
        rvMyDonations.setAdapter(myDonationsAdapter);

    }
}
