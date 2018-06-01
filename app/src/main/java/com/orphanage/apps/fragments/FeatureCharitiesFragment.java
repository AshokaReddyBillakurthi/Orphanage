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
import com.orphanage.apps.adapters.FeatureCharitiesAdapter;

public class FeatureCharitiesFragment extends BaseFragment {

    private RecyclerView rvFratureCharities;
    private FeatureCharitiesAdapter featureCharitiesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_featurec_charities, container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity)getContext()).tvScreenTitle.setText("Feature Charities");

        rvFratureCharities = view.findViewById(R.id.rvFratureCharities);
        rvFratureCharities.setLayoutManager(new LinearLayoutManager(getContext()));
        featureCharitiesAdapter = new FeatureCharitiesAdapter(getContext());
        rvFratureCharities.setAdapter(featureCharitiesAdapter);
    }
}
