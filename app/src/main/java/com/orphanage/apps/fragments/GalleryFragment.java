package com.orphanage.apps.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orphanage.apps.HomeActivity;
import com.orphanage.apps.R;
import com.orphanage.apps.adapters.GalleryAdapter;
import com.orphanage.apps.utils.DataManager;

import java.util.List;

public class GalleryFragment extends BaseFragment {

    private RecyclerView rvGallery;
    private GalleryAdapter galleryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeActivity)getContext()).tvScreenTitle.setText("Gallery");

        List<Drawable> drawableList = DataManager.getInstance(getContext()).getGalleryImages();
        rvGallery = view.findViewById(R.id.rvGallery);
        rvGallery.setLayoutManager(new GridLayoutManager(getContext(),3));
        galleryAdapter = new GalleryAdapter(getContext());
        rvGallery.setAdapter(galleryAdapter);

        if(null!=drawableList&&!drawableList.isEmpty()){
            galleryAdapter.refresh(drawableList);
        }

    }
}
