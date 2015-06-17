package partyup.com.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import partyup.com.myapplication.Adapters.TabPagerAdapter;
import partyup.com.myapplication.Objects.BarFragmentObject;
import partyup.com.myapplication.views.SlidingTabLayout;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSlidingTabs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSlidingTabs extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TabPagerAdapter TabAdapter;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSlidingTabs.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSlidingTabs newInstance(String param1, String param2) {
        FragmentSlidingTabs fragment = new FragmentSlidingTabs();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentSlidingTabs() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_sliding_tabs, container, false);
        // Inflate the layout for this fragment
        ArrayList<BarFragmentObject> mBarsType = new ArrayList<>();
        mBarsType.add(new BarFragmentObject("Electronicos",new ElectronicBarFragment()));
        mBarsType.add(new BarFragmentObject("Romanticos", new ElectronicBarFragment()));
        mBarsType.add(new BarFragmentObject("Cross Over",new ElectronicBarFragment()));
        mBarsType.add(new BarFragmentObject("Bares", new ElectronicBarFragment()));

        ViewPager Tab = (ViewPager)view.findViewById(R.id.pager);

        TabAdapter = new TabPagerAdapter(mBarsType,getFragmentManager());

        Tab.setAdapter(TabAdapter);
        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(Tab);




        return view;
    }


}
