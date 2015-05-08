package partyup.com.myapplication.RequestManager;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;




/**
 * Created by user on 23/12/2014.
 */

public class HandlerService{ /*implements ServicesConsumer{

    private Context mContext;
    ManagerAsynTask mExecutor;
    private onHandlerResponse mHandlerResponse;
    private SharePreferenceManager Mem;
    private String mOperationReques="";
    private GsonConverter mConvert;
    private Definitions Def;
    private String imei;
    private AndroidUtiles mUtil;


    public HandlerService(Context context){

        this.mContext=context;
        mExecutor= new ManagerAsynTask(HandlerService.this,mContext);
        Mem= new SharePreferenceManager(mContext);
        mConvert= new GsonConverter();
        Def=new Definitions();
        mUtil=new AndroidUtiles(mContext);


        if(Mem.getStringMemory(Definitions.DEVICE_ID).equals("")){
            Mem.putInMemory(Definitions.DEVICE_ID, mUtil.getImei());
        }

    }

    public void sendImage(ImagenesPolfa imagenesPolfa,int i){

        mOperationReques=Definitions.OP_FILE_UPLOAD;


        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(imagenesPolfa);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
            dataOut.put("Function", String.valueOf(i));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);

    }

    public void updateAC(PuestoControl puestoControl){


        mOperationReques=Definitions.OP_UPDATE_AC;

        PuestoControl localPuestoControl = mConvert.GSON2PuestoControl(mConvert.Object2GSON(puestoControl));


        localPuestoControl.setmDocumentos(null);
        localPuestoControl.setImagenesPolfa(null);


        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(localPuestoControl);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);
    }


    public void querydAcctionControl(PuestoControl puestoControl){


        mOperationReques=Definitions.OP_QUERY_AC;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(puestoControl);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);
    }

    public void queryIddAcctionControl(PuestoControl puestoControl){


        mOperationReques=Definitions.OP_QUERYID_AC;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(puestoControl);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);
    }


    public void sendAcctionControl(PuestoControl puestoControl,int Id_Row){


        PuestoControl localPuestoControl = mConvert.GSON2PuestoControl(mConvert.Object2GSON(puestoControl));


        localPuestoControl.setmDocumentos(null);
        localPuestoControl.setImagenesPolfa(null);

        int tipo = Integer.valueOf(puestoControl.getId_tipo_accion());
        switch (tipo) {
            case Definitions.AGREGAR_PUESTO_CONTROL:
                mOperationReques = Def.OP_AGREGAR_PUESTO_CONTROL;
                break;
            case Definitions.AGREGAR_VISITA_CONTROL:
                mOperationReques = Def.OP_AGREGAR_VISITA_CONTROL;
                break;
            case Definitions.AGREGAR_INSPECCION_PASAJEROS:
                mOperationReques = Def.OP_AGREGAR_INSPECCION_VIAJEROS;
                break;
            case Definitions.AGREGAR_INSPECCION_CARGA:
                mOperationReques = Def.OP_AGREGAR_INPECCION_CARGA;
                break;
        }

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(localPuestoControl);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
            dataOut.put("Function", String.valueOf(Id_Row));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);
    }

    public void queryResponsalbePolfa(PoliceResponsable responsable){
        mOperationReques=Def.OP_CHECK_RESPONSABLE;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(responsable);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);


    }


    public void addVehicle(Vehiculo vehiculo, int Id_Row){
        mOperationReques=Def.OP_ADD_VEHICLE;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(vehiculo);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
            dataOut.put("Function", String.valueOf(Id_Row));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);
    }


    public void queryVehicle(Vehiculo vehiculo){
        mOperationReques=Def.OP_QUERY_VEHICLE;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(vehiculo);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);

    }

    public void queryPerson(Persona persona){
        mOperationReques=Def.OP_QUERY_PERSON;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(persona);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);


    }

    public void queryCompany(Empresa empresaQuery){
        mOperationReques=Def.OP_QUERY_COMPANY;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(empresaQuery);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);

    }

    public void addPerson (Persona persona,int Id_Row){
        mOperationReques=Def.OP_ADD_PERSON;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(persona);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
            dataOut.put("Function", String.valueOf(Id_Row));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);
    }

    public void addCompany (Empresa empresa,int Id_Row){
        mOperationReques=Def.OP_ADD_COMPANY;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(empresa);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
            dataOut.put("Function", String.valueOf(Id_Row));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);
    }



    public void loginTask(User user){
        mOperationReques=Def.OP_LOGIN;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);
        String data=mConvert.Object2GSON(user);

        try {
            JSONObject dataJson = new JSONObject(data);

            dataOut.put("Data",dataJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);
    }


    public void getHash(){
        mOperationReques=Def.OP_HASH;

        JSONObject dataOut= new JSONObject();
        //dataOut= getHeader(mOperationReques);


        try {
            dataOut.put("Client","android");
            dataOut.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            dataOut.put("Operation",mOperationReques);
            dataOut.put("Token",Mem.getStringMemory(Def.TOKEN));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mExecutor.execute(dataOut.toString(), mOperationReques);

    }


    public void getDominios()
    {
        mExecutor.execute("","",Def.GET);
    }

    public void setOnHandlerResponse(onHandlerResponse activity){
        mHandlerResponse=activity;

    }

    private JSONObject getHeader(JSONObject json,String mOperationReques) {

        try {
            json.put("Client","android");
            json.put("Deviceid",Mem.getStringMemory(Def.DEVICE_ID));
            json.put("Operation",mOperationReques);
            json.put("Token",Mem.getStringMemory(Def.TOKEN));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void processResponce(JSONObject json) {

        try {

            String isLocalError="",locaMsn="";
            isLocalError=json.optString("error");
            locaMsn=json.optString("msg");

            Log.w("HandlerService-isError", isLocalError);
            Log.w("HandlerService-localMsn", locaMsn);

            if(isLocalError.equals("false")){
                JSONObject dataResponse=new JSONObject(json.optString("DataResponse"));
                String debugMsnResponse="";
                boolean isErrorResponse=false;
                String ErrorCodeResponse="";
                String operation="";
                String ResponseType="";
                String Token="";
                String MsnResponse="";

                isErrorResponse=dataResponse.optBoolean("Error");

                Log.w("Data-Response", dataResponse.toString());

                if(!isErrorResponse) {

                    operation = dataResponse.optString("Operation");
                    MsnResponse = dataResponse.optString("Message");
                    ErrorCodeResponse = dataResponse.optString("ErrorCode");
                    Token = dataResponse.optString("Token");//Ojo en get dominoos viene "" simpreee

                    //Mem.putInMemory(Def.TOKEN, Token);
                        Log.i("HandlerServce-OP:", operation);
                        mHandlerResponse.onPostResponse(MsnResponse, isErrorResponse, ErrorCodeResponse, dataResponse.toString());
                }else {

                    ResponseType=dataResponse.optString("ResponseType");
                    if (ResponseType.equals("ERRORDESESION")){
                        MsnResponse = dataResponse.optString("Message");
                        mHandlerResponse.onLoginOut(MsnResponse,dataResponse.toString());
                    }else {
                        debugMsnResponse = dataResponse.optString("DebugMessage");
                        MsnResponse = dataResponse.optString("Message");
                        ErrorCodeResponse = dataResponse.optString("ErrorCode");
                        Log.w("Debug-MSN", debugMsnResponse);

                        mHandlerResponse.onFailResponse(MsnResponse, operation, dataResponse.toString());
                    }


                }

            }else {
                mHandlerResponse.onFailResponse(locaMsn, mOperationReques, json.toString());
                Log.e("HandlerServce-Error:", "Error Comunicacion");

            }

        } catch (Exception e){
            e.printStackTrace();
            mHandlerResponse.onFailResponse("El servicio no se encuentra habilitado temporalmente", mOperationReques, "");
            Log.e("HandlerServce-Error:", "Error Exepction");

        }


    }*/

}
