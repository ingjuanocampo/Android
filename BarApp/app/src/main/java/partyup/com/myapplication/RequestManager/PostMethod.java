package partyup.com.myapplication.RequestManager;

import android.net.Uri;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.CharBuffer;

import partyup.com.myapplication.utiles.Definitions;


/**
 * Created by Juan Manuel on 23/12/2014.
 */
public class PostMethod {

    //public final static String urlbase = "http://192.168.1.113/SICON/";//Privada
    public final static String urlbase= "http://atlas.marcohern.com";


    //public final static String urlbase="http://181.143.141.30/SICON/";//Publica


    private String url =urlbase+ "/bars";





    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PostMethod() {

    }


    /**
     *
     * @param dataout
     * @param complement
     * @return
     */
    public JSONObject SendtoServer(String dataout,String complement){
        JSONObject datain= new JSONObject();
        String res;

        try {
            res = postToServer(url+complement, dataout);
            datain.put("DataResponse", res);
            datain.put("error", "false");
            datain.put("msg", "post ok");
        } catch (Exception e) {
            e.printStackTrace();
            try {

                String msnError = e.getCause().getMessage();
                try {
                    datain.put("data", "null");
                    datain.put("error", "true");
                    if (msnError.contains("ENETUNREACH"))
                        datain.put("msg", "Por favor revisa tu conexión a internet");
                    else if ((msnError.contains("ECONNREFUSED"))) {
                        datain.put("msg", "El servicio no esta disponible, por favor intenta más tarde.");
                    } else {
                        datain.put("msg", "Falló la comunicación");

                    }
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }catch (Exception e1){
                e1.printStackTrace();;
                try {
                    datain.put("msg", "Falló la comunicación");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        return datain;
    }


    /**
     *      * Method deprecated
     * @param serverUrl
     * @param json
     * @return
     * @throws IOException
     */
    private String postToServerHTTPS(String serverUrl, String json) throws IOException {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("https",
                SSLSocketFactory.getSocketFactory(), 443));

        HttpParams httpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, 45000);
        HttpConnectionParams.setSoTimeout(httpparams, 45000);


        SingleClientConnManager mgr = new SingleClientConnManager(httpparams, schemeRegistry);

        HttpClient client = new DefaultHttpClient(mgr, httpparams);
        HttpPost post = new HttpPost(serverUrl);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");


        StringEntity strEntity = new StringEntity(json, "UTF-8");
        post.setEntity(strEntity);


        HttpResponse response = client.execute(post);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent(), "UTF-8"));
        String jsonResultStr = reader.readLine();

        return jsonResultStr;
    }

    /*HttpConnectionParams.setConnectionTimeout(httpparams, 45000);
    HttpConnectionParams.setSoTimeout(httpparams, 45000);*/

    /**
     *      * Method deprecated
     * @param serverUrl
     * @param json
     * @return
     * @throws Exception
     */
    private String postToServer(String serverUrl, String json) throws Exception {

        Log.w("Data-Send: ", json);
        Log.w("URL: ", serverUrl);

        HttpParams httpparams = new BasicHttpParams();

        HttpConnectionParams.setConnectionTimeout(httpparams, 50000);
        HttpConnectionParams.setSoTimeout(httpparams, 50000);


        HttpClient client = new DefaultHttpClient(httpparams);
        HttpPost post = new HttpPost(serverUrl);


        //sets a request header so the page receving the request
        //will know what to do with it
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");


        StringEntity stringEntity = new StringEntity(json, "UTF-8");
        post.setEntity(stringEntity);


        HttpResponse response = client.execute(post);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent(), "UTF-8"));
        String jsonResultStr = reader.readLine();


        Log.w("Data-response", jsonResultStr);
        return jsonResultStr;
    }

    /**
     * Method deprecated
     * @param serverUrl
     * @return
     * @throws Exception
     */
    public String getFromServer(String serverUrl) throws Exception {

        HttpParams httpparams = new BasicHttpParams();

        HttpConnectionParams.setConnectionTimeout(httpparams, 50000);
        HttpConnectionParams.setSoTimeout(httpparams, 50000);


        HttpClient client = new DefaultHttpClient(httpparams);
        HttpGet get = new HttpGet(serverUrl);


        HttpResponse response = client.execute(get);


        BufferedReader reader = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));


        String jsonResultStr = reader.readLine();




        return jsonResultStr;
    }


    /**
     * Method in use
     * @return
     * @throws IOException
     */
    public String GetFromServerURL(String complement) throws IOException {


        URL mURL= new URL(urlbase+complement);



        HttpURLConnection urlConnection = (HttpURLConnection) mURL.openConnection();
        urlConnection.setRequestProperty("Accept","application/json");
        urlConnection.setRequestMethod("GET");

        String jsonResultStr="";
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            Log.w("res",in.toString());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));


            StringBuilder total = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line);
            }

            jsonResultStr=total.toString();

        }finally{
                urlConnection.disconnect();
        }


        return jsonResultStr;





    }


    /**
     *      * Method deprecated
     * @param serverUrl
     * @return
     */
    public JSONObject getFromServer2(String serverUrl){

        JSONObject data= new JSONObject();
        JSONObject dataResponce= new JSONObject();
        try {
            dataResponce.put("Error",false);
            dataResponce.put("DebugMessage","");
            dataResponce.put("ErrorCode","");
            dataResponce.put("Function","");
            dataResponce.put("Message","");
            dataResponce.put("Operation","");
            dataResponce.put("ResponseTime","");
            dataResponce.put("Token","");



            data.put("DataResponse", dataResponce);
            data.put("error", "false");
            data.put("msg", "post ok");

            HttpParams httpparams = new BasicHttpParams();

            HttpConnectionParams.setConnectionTimeout(httpparams, 50000);
            HttpConnectionParams.setSoTimeout(httpparams, 50000);


            HttpClient client = new DefaultHttpClient(httpparams);
            HttpGet get = new HttpGet(serverUrl);


            HttpResponse response = client.execute(get);

            //set the path where we want to save the file
            //in this case, going to save it on the root directory of the
            //sd card.
            final File dir = new File(Definitions.POLFA_PATH);
            //create a new file, specifying the path, and the filename
            //which we want to save the file as.

            dir.mkdirs();

            File file = new File(dir, Definitions.DOMINIOS);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //this will be used to write the downloaded data into the file we created
            FileOutputStream fileOutput = new FileOutputStream(file);

            //fileOutput = new File(mDir, name);

            //this will be used in reading the data from the internet
            InputStream inputStream = response.getEntity().getContent(); //urlConnection.getInputStream();

            //this is the total size of the file
            //int totalSize = urlConnection.getContentLength();
            //variable to store total downloaded bytes
            int downloadedSize = 0;

            //create a buffer...
            byte[] buffer = new byte[1024];
            int bufferLength = 0; //used to store a temporary size of the buffer

            //now, read through the input buffer and write the contents to the file
            while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
                //add the data in the buffer to the file in the file output stream (the file on the sd card
                fileOutput.write(buffer, 0, bufferLength);
                //add up the size so we know how much is downloaded
                downloadedSize += bufferLength;
                //this is where you would do something to report the prgress, like this maybe

            }
            //close the output stream when done
            fileOutput.close();

//catch some possible errors...
        } catch (MalformedURLException e) {
            try {
                data.put("DataResponse", "");
                data.put("error", "true");
                data.put("msg", "post fail");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                data.put("DataResponse", "");
                data.put("error", "true");
                data.put("msg", "post fail");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        } catch (JSONException e) {
            try {
                data.put("DataResponse", "");
                data.put("error", "true");
                data.put("msg", "post fail");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }

        return  data;
    }

}
