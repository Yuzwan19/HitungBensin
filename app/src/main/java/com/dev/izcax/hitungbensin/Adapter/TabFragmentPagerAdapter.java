package com.dev.izcax.hitungbensin.Adapter;

/**
 * Created by Izcax on 27/09/2016.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.dev.izcax.hitungbensin.Fragment.Tab1Fragment;
import com.dev.izcax.hitungbensin.Fragment.Tab2Fragment;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    //nama tab nya
    String[] title = new String[]{
            "Motor", "Mobil"
    };

    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //method ini yang akan memanipulasi penampilan Fragment dilayar
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Tab1Fragment();
                break;
            case 1:
                fragment = new Tab2Fragment();
                break;
            default:
                fragment = null;
                break;
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return title.length;
    }
}
