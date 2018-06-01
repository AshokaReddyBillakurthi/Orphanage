package com.orphanage.apps.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orphanage.apps.HomeActivity;
import com.orphanage.apps.R;

public class OurWorkFragment extends BaseFragment {

    private ImageView ivOurWork;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ourwork, container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivOurWork = view.findViewById(R.id.ivOurWork);
        Glide.with(getContext())
                .load(getResources().getDrawable(R.drawable.ourwork_banner))
                .into(ivOurWork);

        ((HomeActivity)getContext()).tvScreenTitle.setText("Our Work");
    }
}
