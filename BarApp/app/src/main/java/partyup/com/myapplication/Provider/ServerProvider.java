package partyup.com.myapplication.Provider;

import android.util.Log;

import java.util.ArrayList;

import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.Category;
import partyup.com.myapplication.RequestManager.ManagerAsynTask;
import partyup.com.myapplication.RequestManager.ServicesConsumer;
import partyup.com.myapplication.utiles.Definitions;
import partyup.com.myapplication.utiles.GsonConverter;

/**
 * Created by juan.ocampo on 18/06/2015.
 */
public class ServerProvider extends ProviderBase {

    private static ProviderBase instance;

    public static ProviderBase getInstance(){
        if (instance==null){
            instance = new ServerProvider();
        }

        return instance;
    }

    private ArrayList<Bar> Bars;
    @Override
    public void getBars(Category category, final OnProviderResponse activity,int page) {


        ManagerAsynTask mExcutor= new ManagerAsynTask(new ServicesConsumer() {
            @Override
            public void processResponce(String json) {
               Bars = GsonConverter.gson2ArrayBars(json);
                Log.w("Bar", Bars.get(1).getmName());

                activity.onSucessResponse(Bars);


            }
        },getmContext());

        mExcutor.execute(Definitions.GET,"/bars");



    }

    @Override
    public void getCitiesStrings(OnProviderResponse activity) {



    }
}
