package partyup.com.myapplication.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import partyup.com.myapplication.ElectronicBarFragment;
import partyup.com.myapplication.Objects.BarFragmentObject;
import partyup.com.myapplication.RomanticBarFragment;

/**
 * Created by user on 07/05/2015.
 */


public class AdapterViewPagerTypeBars extends FragmentPagerAdapter {
    public AdapterViewPagerTypeBars(FragmentManager fm,ArrayList<BarFragmentObject> data) {
        super(fm);
        this.mFragments=data;
    }

    private ArrayList<BarFragmentObject> mFragments;

    @Override
    public Fragment getItem(int i) {


        return  mFragments.get(i).getFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mFragments.get(position).getTitle();
    }
}