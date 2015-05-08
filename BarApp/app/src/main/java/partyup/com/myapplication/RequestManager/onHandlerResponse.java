package partyup.com.myapplication.RequestManager;



/**
 * Created by user on 24/12/2014.
 */
public interface onHandlerResponse {

    public void onPostResponse(String Msn, Boolean isErrorLayer, String ErrorCode, String Data);
    public void onFailResponse(String Msn, String Operation, String Data);
    public void onLoginOut(String Msn, String Data);

}
