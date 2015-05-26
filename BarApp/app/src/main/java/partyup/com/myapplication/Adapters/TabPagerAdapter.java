package partyup.com.myapplication.Adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import partyup.com.myapplication.ElectronicBarFragment;
import partyup.com.myapplication.Objects.BarFragmentObject;
import partyup.com.myapplication.RomanticBarFragment;


public class TabPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<BarFragmentObject> mFragmets;
    public TabPagerAdapter(FragmentManager fm,ArrayList<BarFragmentObject> data) {

        super(fm);
        this.mFragmets=data;
        // TODO Auto-generated constructor stub
    }
    @Override
    public Fragment getItem(int i) {
        /*switch (i) {
            case 0:
                //Fragement for Android Tab
                return new ElectronicBarFragment();
            case 1:
                //Fragment for Ios Tab
                return new RomanticBarFragment();
        }*/
        return mFragmets.get(i).getFragment();
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mFragmets.size(); //No of Tabs
    }
}
