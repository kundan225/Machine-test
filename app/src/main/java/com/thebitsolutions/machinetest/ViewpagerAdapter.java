package com.thebitsolutions.machinetest;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.thebitsolutions.machinetest.fragments.LoginFragment;
import com.thebitsolutions.machinetest.fragments.SignUpFragment;
;

public class ViewpagerAdapter extends FragmentStateAdapter {
    private int tab_num=2;

    public ViewpagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new LoginFragment();
        }
        return new SignUpFragment();
    }

    @Override
    public int getItemCount() {
        return tab_num;
    }
}
