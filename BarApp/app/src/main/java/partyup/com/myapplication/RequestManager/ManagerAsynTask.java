package partyup.com.myapplication.RequestManager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import partyup.com.myapplication.utiles.Definitions;


/**
 * Created by Juan Manuel on 23/12/2014.
 */
public class ManagerAsynTask extends AsyncTask<String, Void, JSONObject > {

    private ServicesConsumer actividad;
    private String recibido;
    private JSONObject resultadoPost;
    public JSONObject resultGet;
    private String complement="";
    private Context contexto;
    private String Type= Definitions.POST; //By defualt


    @Override
    protected JSONObject doInBackground(String... params) {
        PostMethod server = new PostMethod();
        this.recibido=params[0];
        this.complement=params[1];

        try {
            this.Type=params[2];

        }catch (Exception e){

        }

        if (Type.equals(Definitions.POST))
            resultadoPost =server.SendtoServer(recibido,complement);
        else {
            try {
                resultGet=server.getFromServer2(PostMethod.urlbase+"SAC3SERVICES/SQL/POLFA2.db"); //getFromServer("http://192.168.1.113/SICON/SQL/POLFA2.db");
                //FileHelper mFile= new FileHelper(contexto,Definitions.DOMINIOS);
                //mFile.saveIntoFile(resultGet);

                return resultGet;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resultadoPost;
    }

    public ManagerAsynTask(ServicesConsumer actividad, Context contexto)
    {
        this.actividad = actividad;
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
    protected void onPostExecute(JSONObject result) {
        Log.i("Desde: ", "onPostManagerAsyn");

        actividad.processResponce(result);//(this.resultadoPost);
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
