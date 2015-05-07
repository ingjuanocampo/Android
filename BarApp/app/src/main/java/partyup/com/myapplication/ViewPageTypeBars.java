package partyup.com.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import partyup.com.myapplication.Adapters.AdapterViewPagerTypeBars;
import partyup.com.myapplication.Objects.BarFragmentObject;

/**
 * Created by Juan on 07/05/2015.
 */
public class ViewPageTypeBars  extends Fragment implements ElectronicBarFragment.OnFragmentInteractionListener,
                RomanticBarFragment.OnFragmentInteractionListener{
    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    AdapterViewPagerTypeBars mBarsTypePagerAdapter;
    ViewPager mViewPager;

    private ArrayList<BarFragmentObject> mBarsType;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private View mViewContainer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        mViewContainer= inflater.inflate(R.layout.viewpagertypesbar,container,false);

        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.

         mBarsType= new ArrayList<>();
        mBarsType.add(new BarFragmentObject("Electronica",new ElectronicBarFragment()));
        mBarsType.add(new BarFragmentObject("Romanticos",new RomanticBarFragment()));
        mBarsTypePagerAdapter =
                new AdapterViewPagerTypeBars(
                        getChildFragmentManager(),mBarsType);
        mViewPager = (ViewPager) mViewContainer.findViewById(R.id.pager);
        mViewPager.setAdapter(mBarsTypePagerAdapter);

        return mViewContainer;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}