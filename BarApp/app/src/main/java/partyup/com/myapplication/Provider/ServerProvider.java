package partyup.com.myapplication.Provider;

import java.util.ArrayList;

import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.Category;
import partyup.com.myapplication.Objects.ResponseFormat;
import partyup.com.myapplication.RequestManager.ManagerAsynTask;
import partyup.com.myapplication.RequestManager.ServicesConsumer;
import partyup.com.myapplication.utiles.Definitions;
import partyup.com.myapplication.utiles.GsonConverter;

/**
 * Created by juan.ocampo on 18/06/2015.
 */
public class ServerProvider extends ProviderBase {

    private static final int pageLenght=10;

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
            public void processResponce(ResponseFormat responseFormat) {

               if(!responseFormat.isErrorLocal() && !responseFormat.isErrorServer() ){
                   Bars = GsonConverter.gson2ArrayBars(responseFormat.getData());

                   activity.onSucessResponse(Bars);
               }else {

                   activity.onFailResponse(responseFormat.getErrorMsn());
               }
            }
        },getmContext());

        if(category!=AllCategory)
            mExcutor.execute(Definitions.GET,"/bars",String.valueOf(page*pageLenght),String.valueOf(pageLenght),category.getName());
        else
            mExcutor.execute(Definitions.GET,"/bars",String.valueOf(page*pageLenght),String.valueOf(pageLenght));




    }

    @Override
    public void getCitiesStrings(OnProviderResponse activity) {



    }
}
