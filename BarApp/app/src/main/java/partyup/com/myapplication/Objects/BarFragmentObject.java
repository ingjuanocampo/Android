package partyup.com.myapplication.Objects;


import android.support.v4.app.Fragment;

/**
 * Created by user on 07/05/2015.
 */
public class BarFragmentObject {

    public BarFragmentObject(String title,Fragment fragment){
        this.mTitle =title;
        this.mFragment =fragment;

    }

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        this.mFragment = fragment;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    private Fragment mFragment;
    private String mTitle;

}
