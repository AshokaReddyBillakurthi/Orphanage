package com.orphanage.apps.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orphanage.apps.HomeActivity;
import com.orphanage.apps.R;
import com.orphanage.apps.fragments.AboutUsFragment;
import com.orphanage.apps.fragments.ContactUsFragment;
import com.orphanage.apps.fragments.FeatureCharitiesFragment;
import com.orphanage.apps.fragments.MyDonationsFragment;
import com.orphanage.apps.fragments.OurMissionFragment;
import com.orphanage.apps.model.MenuItem;
import com.orphanage.apps.utils.AppConstents;
import com.orphanage.apps.utils.DialogUtils;

import java.util.ArrayList;
import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder>{

    private List<MenuItem> menuItemList;

    public MenuItemAdapter(){
        this.menuItemList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_cell,parent,false);
        return new MenuItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemViewHolder holder, int position) {
        holder.ivIcon.setImageDrawable(menuItemList.get(position).icon);
        holder.tvItemName.setText(menuItemList.get(position).name+"");
    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    public void refresh(List<MenuItem> menuItemList){
        this.menuItemList = menuItemList;
        notifyDataSetChanged();
    }

    class MenuItemViewHolder extends RecyclerView.ViewHolder{
        ImageView ivIcon;
        TextView tvItemName;
        public MenuItemViewHolder(final View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String title = tvItemName.getText().toString();
                    ((HomeActivity)itemView.getContext()).closeDrawer();
                    Fragment fragment = null;
                    switch (title){
                        case AppConstents.HOME:{
                            ((HomeActivity)itemView.getContext()).setMenuVisible();
                            ((HomeActivity)itemView.getContext()).navigation.setSelectedItemId(R.id.navigation_home);
                            break;
                        }
                        case AppConstents.ABOUT_US:{
                            ((HomeActivity)itemView.getContext()).setBackVisible();
                            fragment = new AboutUsFragment();
                            break;
                        }
                        case AppConstents.OUR_MISSION:{
                            ((HomeActivity)itemView.getContext()).setBackVisible();
                            fragment = new OurMissionFragment();
                            break;
                        }
                        case AppConstents.OUR_WORK:{
                            ((HomeActivity)itemView.getContext()).setBackVisible();
                            ((HomeActivity)itemView.getContext()).navigation.setSelectedItemId(R.id.navigation_work);
                            break;
                        }
                        case AppConstents.DONATE:{
                            ((HomeActivity)itemView.getContext()).setBackVisible();
                            ((HomeActivity)itemView.getContext()).navigation.setSelectedItemId(R.id.navigation_donate);
                            break;
                        }
                        case AppConstents.MY_DONATION:{
                            ((HomeActivity)itemView.getContext()).setBackVisible();
                            fragment = new MyDonationsFragment();
                            break;
                        }
                        case AppConstents.GALLERY:{
                            ((HomeActivity)itemView.getContext()).setBackVisible();
                            ((HomeActivity)itemView.getContext()).navigation.setSelectedItemId(R.id.navigation_gallery);
                            break;
                        }
                        case AppConstents.REGISTER:{
                            ((HomeActivity)itemView.getContext()).setBackVisible();
                            ((HomeActivity)itemView.getContext()).navigation.setSelectedItemId(R.id.navigation_user);
                            break;
                        }
                        case AppConstents.FEATURE_CHARITIES:{
                            ((HomeActivity)itemView.getContext()).setBackVisible();
                            fragment = new FeatureCharitiesFragment();
                            break;
                        }
                        case AppConstents.CONTACT_US:{
                            ((HomeActivity)itemView.getContext()).setBackVisible();
                            fragment = new ContactUsFragment();
                            break;
                        }
                        case AppConstents.LOGOUT:{
                            ((HomeActivity)itemView.getContext()).closeDrawer();
                            DialogUtils.showDialog(itemView.getContext(),"Do you want to Logout?",
                                    AppConstents.LOGOUT,true);
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    ((HomeActivity)itemView.getContext()).loadFragment(fragment);
                }
            });
        }
    }
}
