package partyup.com.myapplication.Adapters;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import partyup.com.myapplication.Interfaces.OnDocHelpChange;
import partyup.com.myapplication.R;

/**
 * Created by juan.ocampo on 23/06/2015.
 */
public class PageAdapterHelp extends PagerAdapter {

    private LayoutInflater inflater;
    private LinearLayout mLinearDocs;
    private ImageView imgDoc;
    private OnDocHelpChange mOnchangeDocState;

    private int [] ImagesR;
    public PageAdapterHelp (LayoutInflater layoutInflater, int[] data, OnDocHelpChange callback){
        this.ImagesR=data;
        inflater=layoutInflater;
        mOnchangeDocState=callback;
    }

    /**
     * @return the number of pages to display
     */
    @Override
    public int getCount() {
        return ImagesR.length;
    }

    /**
     * @return true if the value returned from {@link #instantiateItem(ViewGroup, int)} is the
     * same object as the {@link View} added to the {@link ViewPager}.
     */
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

    // BEGIN_INCLUDE (pageradapter_getpagetitle)
    /**
     * Return the title of the item at {@code position}. This is important as what this method
     * <p>
     * Here we construct one using the position value, but for real application the title should
     * refer to the item's contents.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return "Item " + (position + 1);
    }
    // END_INCLUDE (pageradapter_getpagetitle)

    /**
     * Instantiate the {@link View} which should be displayed at {@code position}. Here we
     * inflate a layout from the apps resources and then change the text view to signify the position.
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Inflate a new layout from our resources
        View view = inflater.inflate(R.layout.view_help_row,
                container, false);
        // Add the newly created View to the ViewPager
        container.addView(view);

        // Retrieve a TextView from the inflated View, and update it's text

        ImageView img= (ImageView)view.findViewById(R.id.img_help);
        img.setImageResource(ImagesR[position]);
        mLinearDocs = (LinearLayout)view.findViewById(R.id.linear_docs);

        //mOnchangeDocState.onDockChange(get);

        // Return the View
        return view;
    }



    /**
     * Destroy the item from the {@link ViewPager}. In our case this is simply removing the
     * {@link View}.
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}