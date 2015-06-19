package partyup.com.myapplication.utiles;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import partyup.com.myapplication.Objects.Bar;

/**
 * Created by juan.ocampo on 18/06/2015.
 */
public class GsonConverter {


    public static String object2StringGson(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);

    }

    public static ArrayList<Bar> gson2ArrayBars(String data){
        Gson gson = new Gson();
        Type token = new TypeToken<ArrayList<Bar>>(){}.getType();

        return gson.fromJson(data, token);

    }

    public static Bar gson2Bar(String data){
        Gson gson = new Gson();
        Type token = new TypeToken<Bar>(){}.getType();

        return gson.fromJson(data,token);
    }

}
