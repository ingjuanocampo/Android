package partyup.com.myapplication.Objects;

import java.util.ArrayList;

/**
 * Created by user on 08/05/2015.
 */
public class Bars {
    private ArrayList<Bar> mBars= new ArrayList<>();
    private City mCity= new City();

    public City getmCity() {
        return mCity;
    }

    public void setmCity(City mCity) {
        this.mCity = mCity;
    }

    public ArrayList<Bar> getmBars() {
        return mBars;
    }

    public void setmBars(ArrayList<Bar> mBars) {
        this.mBars = mBars;
    }
}
