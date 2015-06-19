package partyup.com.myapplication.RequestManager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import partyup.com.myapplication.utiles.Definitions;
import partyup.com.myapplication.utiles.GsonConverter;


/**
 * Created by Juan Manuel on 23/12/2014.
 */
public class ManagerAsynTask extends AsyncTask<String, Void, String > {

    private ServicesConsumer consumer;
    private String recibido;
    private JSONObject resultadoPost;
    public JSONObject resultGet;
    private String complement="";
    private Context contexto;
    private String Type= Definitions.GET; //By defualt
    private String result;


    /**
     *
     * @param params
     * 1. Type [POST or GET]
     * 2. Url Complement
     * 3. Data if there are POST
     * @return
     */
    @Override
    protected String doInBackground(String... params) {
        PostMethod server = new PostMethod();
        this.Type=params[0];
        this.complement=params[1];


        if (Type.equals(Definitions.GET))
            /*resultadoPost =*/
            try {//Get Here
                result=server.GetFromServerURL(complement); //
                // GsonConverter.gson2ArrayBars(result);

            } catch (IOException e) {
                e.printStackTrace();
            }
        else {
            try {
               //this.out=params[2];

                //POST here
                //resultGet=server.getFromServer2(PostMethod.urlbase+"SAC3SERVICES/SQL/POLFA2.db"); //getFromServer("http://192.168.1.113/SICON/SQL/POLFA2.db");
                //FileHelper mFile= new FileHelper(contexto,Definitions.DOMINIOS);
                //mFile.saveIntoFile(resultGet);

                //return resultGet;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public ManagerAsynTask(ServicesConsumer consumer, Context contexto)
    {
        this.consumer = consumer;
        this.recibido = null;
        this.resultadoPost = null;
        this.contexto = contexto;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        Log.i("Desde: ", "onPostManagerAsyn");

        consumer.processResponce(result);//(this.resultadoPost);
        super.onPostExecute(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        // TODO Auto-generated method stub
        super.onCancelled();
    }



}
