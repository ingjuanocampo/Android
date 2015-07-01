package partyup.com.myapplication.Provider;

import android.content.Context;

import java.util.ArrayList;

import partyup.com.myapplication.ElectronicBarFragment;
import partyup.com.myapplication.FragmentBar;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.BarFragmentObject;
import partyup.com.myapplication.Objects.Category;

/**
 * Created by juan.ocampo on 17/06/2015.
 */
public abstract class ProviderBase {

    public static final Category BarCategory= new Category("Bar","1");
    public static final Category CasinoCategory= new Category("Casino","2");
    public static final Category RestauranCategory= new Category("Restaurantes","3");
    public static final Category DiscoCategory= new Category("Disco","4");



    private Context mContext;

    public abstract void getBars(Category category,OnProviderResponse activity,int page);

    public abstract void getCitiesStrings(OnProviderResponse activity);

    public ArrayList<BarFragmentObject> getFragmentsBars(){

        ArrayList<BarFragmentObject> mBarsType = new ArrayList<>();
        mBarsType.add(new BarFragmentObject("BARES",new FragmentBar())); //ElectronicBarFragment.newInstance(BarCategory.getId())));
        mBarsType.add(new BarFragmentObject("DISCOS",new ElectronicBarFragment())); // ElectronicBarFragment.newInstance(DiscoCategory.getId())));
        mBarsType.add(new BarFragmentObject("RESTAURANTES", new ElectronicBarFragment())); // ElectronicBarFragment.newInstance(RestauranCategory.getId());
        mBarsType.add(new BarFragmentObject("CASINOS", new ElectronicBarFragment())); //ElectronicBarFragment.newInstance(CasinoCategory.getId())));



        //mBarsType.add(new BarFragmentObject("XXXs", new ElectronicBarFragment()));
        //mBarsType.add(new BarFragmentObject("GAYSs", new ElectronicBarFragment()));
        return mBarsType;
    }


    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public Context getmContext() {
        return mContext;
    }



}
