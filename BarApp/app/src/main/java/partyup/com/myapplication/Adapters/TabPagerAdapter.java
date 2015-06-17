package partyup.com.myapplication.Adapters;


import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

import partyup.com.myapplication.Objects.BarFragmentObject;
import partyup.com.myapplication.R;


public class TabPagerAdapter extends PagerAdapter {
    private ArrayList<BarFragmentObject> mFragmets;
    private Activity mActivity;
    private FragmentManager mFragmentManager;
    public TabPagerAdapter(ArrayList<BarFragmentObject> data,FragmentManager fragmentManager) {

        //super(fm);
        this.mFragmets=data;
        //this.mActivity =context;
        this.mFragmentManager=fragmentManager;

        // TODO Auto-generated constructor stub
    }
    /*@Override
    public Fragment getItem(int i) {
        /*switch (i) {
            case 0:
                //Fragement for Android Tab
                return new ElectronicBarFragment();
            case 1:
                //Fragment for Ios Tab
                return new RomanticBarFragment();
        }*
        return mFragmets.get(i).getFragment();
    }*/
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mFragmets.size(); //No of Tabs
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Retrieve a TextView from the inflated View, and update it's text
       /* TextView title = (TextView) view.findViewById(R.id.item_title);
        title.setText(String.valueOf(position + 1));*/

        //fragmentExecuter(mFragmets.get(position).getFragment());
        //container.addView(mFragmets.get(position).getFragment().getView());

        Log.i("", "instantiateItem() [position: " + position + "]");

        // Return the View
        return mFragmets.get(position).getFragment();
    }
    /**
     * Destroy the item from the {@link android.support.v4.view.ViewPager}. In our case this is simply removing the
     * {@link View}.
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //container.removeView((View) object);
        Log.i("", "destroyItem() [position: " + position + "]");
    }

    /**
     * @return true if the value returned from {@link #instantiateItem(ViewGroup, int)} is the
     * same object as the {@link View} added to the {@link android.support.v4.view.ViewPager}.
     */
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

    /**
     * Return the title of the item at {@code position}. This is important as what this method
     * returns is what is displayed in the {@link }.
     * <p>
     * Here we construct one using the position value, but for real application the title should
     * refer to the item's contents.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmets.get(position ).getTitle();
    }
    // END_INCLUDE (pageradapter_getpagetitle)


    Fragment oldFargment;

   /*private void fragmentExecuter(Fragment fragment){


        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();


        if(fragment!=null){
            if(!fragment.isAdded()){

                if (oldFargment!=null)
                    fragmentTransaction.remove(oldFargment);

                fragmentTransaction.add(R.id.container, fragment);
                //fragmentTransaction.addToBackStack(fragment.getTag());

                fragmentTransaction.commit();

            }else if(oldFargment!=fragment){

                fragmentTransaction.remove(oldFargment);

                fragmentTransaction.replace(R.id.container, fragment);

                fragmentTransaction.commit();
            }

            oldFargment=fragment;

        }

    }*/

}
