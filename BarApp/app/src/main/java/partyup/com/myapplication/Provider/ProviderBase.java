package partyup.com.myapplication.Provider;

import android.content.Context;

import java.util.ArrayList;

import partyup.com.myapplication.ElectronicBarFragment;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.BarFragmentObject;
import partyup.com.myapplication.Objects.Category;

/**
 * Created by juan.ocampo on 17/06/2015.
 */
public abstract class ProviderBase {

    private Context mContext;

    public abstract void getBars(Category category,OnProviderResponse activity);

    public ArrayList<BarFragmentObject> getFragmentsBars(){

        ArrayList<BarFragmentObject> mBarsType = new ArrayList<>();
        mBarsType.add(new BarFragmentObject("BARES",new ElectronicBarFragment()));
        mBarsType.add(new BarFragmentObject("DISCOS", new ElectronicBarFragment()));
        mBarsType.add(new BarFragmentObject("RESTAURANTES",new ElectronicBarFragment()));
        //mBarsType.add(new BarFragmentObject("XXXs", new ElectronicBarFragment()));
        //mBarsType.add(new BarFragmentObject("GAYSs", new ElectronicBarFragment()));
        mBarsType.add(new BarFragmentObject("CASINOS", new ElectronicBarFragment()));

        return mBarsType;
    }


    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public Context getmContext() {
        return mContext;
    }
}
