package com.orphanage.apps.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.orphanage.apps.R;
import com.orphanage.apps.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static DataManager dataManager;
    private Context mContext;

    private DataManager(Context context){
       this.mContext = context;
    }

    public static DataManager getInstance(Context context){
        if(dataManager == null)
            dataManager = new DataManager(context);

        return dataManager;
    }

    public List<MenuItem> getAllMenuItems(){
        List<MenuItem> menuItemList = null;
        MenuItem menuItem;
        try{
            menuItemList = new ArrayList<>();
            menuItem = new MenuItem();
            menuItem.name = AppConstents.HOME;
            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_home);
            menuItemList.add(menuItem);
            menuItem = new MenuItem();
            menuItem.name = AppConstents.ABOUT_US;
            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_aboutus);
            menuItemList.add(menuItem);
            menuItem = new MenuItem();
            menuItem.name = AppConstents.OUR_MISSION;
            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_mission);
            menuItemList.add(menuItem);
            menuItem = new MenuItem();
            menuItem.name = AppConstents.OUR_WORK;
            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_work);
            menuItemList.add(menuItem);
            menuItem = new MenuItem();
            menuItem.name = AppConstents.DONATE;
            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_favorite);
            menuItemList.add(menuItem);
            menuItem = new MenuItem();
            menuItem.name = AppConstents.MY_DONATION;
            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_mydonations);
            menuItemList.add(menuItem);
            menuItem = new MenuItem();
            menuItem.name = AppConstents.GALLERY;
            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_image);
            menuItemList.add(menuItem);
            menuItem = new MenuItem();
            menuItem.name = AppConstents.REGISTER;
            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_person);
            menuItemList.add(menuItem);
            menuItem = new MenuItem();
            menuItem.name = AppConstents.FEATURE_CHARITIES;
            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_charaties);
            menuItemList.add(menuItem);
            menuItem = new MenuItem();
            menuItem.name = AppConstents.CONTACT_US;
            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_phone);
            menuItemList.add(menuItem);
//            menuItem = new MenuItem();
//            menuItem.name = AppConstents.LOGOUT;
//            menuItem.icon = mContext.getResources().getDrawable(R.drawable.ic_logout);
//            menuItemList.add(menuItem);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return menuItemList;
    }


    public List<Drawable> getGalleryImages(){
        List<Drawable> drawableList = null;
        try{
            drawableList = new ArrayList<>();
            drawableList.add(mContext.getResources().getDrawable(R.drawable.one));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.two));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.three));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.four));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.five));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.six));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.seven));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.eight));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.nine));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.ten));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.eleven));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.twelve));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.thirteen));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.fourteen));
            drawableList.add(mContext.getResources().getDrawable(R.drawable.fifteen));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return drawableList;
    }
}
