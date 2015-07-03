package partyup.com.myapplication.RequestManager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import partyup.com.myapplication.Objects.ResponseFormat;
import partyup.com.myapplication.utiles.Definitions;


/**
 * Created by Juan Manuel on 23/12/2014.
 */
public class ManagerAsynTask extends AsyncTask<String, Void, ResponseFormat> {

    private ServicesConsumer consumer;
    private String recibido;
    private JSONObject resultadoPost;
    public JSONObject resultGet;
    private String complement="";
    private Context contexto;
    private String Type= Definitions.GET; //By defualt
    private ResponseFormat result= new ResponseFormat();
    private String PageLength="1";
    private Map<String,String> params= new HashMap<>();



    /**
     *
     * @param params
     * 1. Type [POST or GET]
     * 2. Url Complement
     * 3. Page Number
     * 4. Page length
     * 4. Category : bar,disco,casino,restaurant
     * 5. Data if there are POST
     * @return
     */
    @Override
    protected ResponseFormat doInBackground(String... params) {
        PostMethod server = new PostMethod();
        this.Type=params[0];
        this.complement=params[1];

        if(params.length>=3){
            this.params.put("o",params[2]);
            this.params.put("l",params[3]);
        }

        if(params.length>=5){
            this.params.put("category",params[4]);

        }

        if (Type.equals(Definitions.GET))
            /*resultadoPost =*/
            try {//Get Here
                result.setData(server.GetFromServerURL(complement,this.params)); //

                if(result.getData().equals("")){
                    result.setIsErrorLocal(true);
                    result.setErrorMsn("Error connection or empty response");
                }
                // GsonConverter.gson2ArrayBars(result);

            } catch (IOException e) {
                e.printStackTrace();
                result.setIsErrorLocal(true);
                result.setErrorMsn(e.getMessage());

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
    protected void onPostExecute(ResponseFormat result) {
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
