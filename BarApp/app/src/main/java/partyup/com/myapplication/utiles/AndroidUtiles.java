package partyup.com.myapplication.utiles;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import partyup.com.myapplication.Objects.ColorsTheme;
import partyup.com.myapplication.R;


/**
 * Created by user on 16/01/2015.
 */
public class AndroidUtiles {
    private Context mContex;
    private Activity mActivity;
    public AndroidUtiles(Context contex){
       this.mContex=contex;

    }



    private AlertDialog alert;

    /**
     *
     * @param title
     * @param Msn
     * @param mContext
     */
    public void showDialog(String title,String Msn,Context mContext){

        if(!((Activity) mContext).isFinishing()){

            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle(title);
            builder.setMessage(Msn)
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                        }
                    });
            if(alert!=null){
                if(!alert.isShowing()) {
                    alert = builder.create();
                    alert.show();
                }
            }else {
                alert = builder.create();
                alert.show();
            }

        }else {
            Log.w("ERROR", "La actividad es finalizada no se puede mostrar el msn UI" + Msn);
        }

    }

    public void showDialog(String title,String Msn,Context mContext, final onDialogResponce handlerResponnse){

        if(!((Activity) mContext).isFinishing()){

            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle(title);
            builder.setMessage(Msn)
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                            handlerResponnse.onResponse(true);

                        }
                    });
            if(alert!=null){
                if(!alert.isShowing()) {
                    alert = builder.create();
                    alert.show();
                }
            }else {
                alert = builder.create();
                alert.show();
            }

        }else {
            Log.w("ERROR", "La actividad es finalizada no se puede mostrar el msn UI" + Msn);
        }

    }
    boolean responce=false;

    /**
     *
     * @param title
     * @param Msn
     * @param mContext
     * @return
     */
    public boolean showDialogCuestion(String title,String Msn,Context mContext, final onDialogResponce handlerResponnse){

        if(!((Activity) mContext).isFinishing()){

            AlertDialog.Builder builder = new AlertDialog.Builder(mContext); //,AlertDialog.THEME_HOLO_DARK);
            builder.setTitle(title);
            builder.setMessage(Msn)
                    .setCancelable(false)
                    .setNegativeButton("NO",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            handlerResponnse.onResponse(false);
                        }
                    })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                            handlerResponnse.onResponse(true);
                        }
                    });
            if(alert!=null){
                if(!alert.isShowing()) {
                    alert = builder.create();
                    alert.show();
                }
            }else {
                alert = builder.create();
                alert.show();
            }

        }else {
            Log.w("ERROR", "La actividad es finalizada no se puede mostrar el msn UI" + Msn);
        }
        return responce;

    }

    public interface onDialogResponce {
        public void onResponse(boolean response);
    }
    /**
     *
     * @param view
     */
   public static  void keyBoardHide(View view,Context mContex){

       InputMethodManager imm = (InputMethodManager)mContex.getSystemService(
               Context.INPUT_METHOD_SERVICE);
       imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    /**
     *
     * @param email
     * @return
     */
    public boolean validEmail(String email){

        return new EmailFormatValidator().validate(email);
    }

    /**
     * RETORNA EL STRING DE UN NUMERO MENOS A 10 EN 2 DIGITOS
     * @param number
     * @return
     */
    public String checkDigit(int number)
    {
        return number<=9?"0"+number: String.valueOf(number);
    }



    public boolean isLenghtValid(String str,int lenght){
        return str.length()>lenght;
    }


    public boolean connectStatus()
    {
        ConnectivityManager conectividad = (ConnectivityManager)
                mContex.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conectividad != null)
        {
            NetworkInfo[] informacion = conectividad.getAllNetworkInfo();

            if(informacion != null)
                for (int i= 0; i< informacion.length; i++)
                    if (informacion[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;

        }// fin de if conectividad
        return false;
    }


    public String getImei(){

            TelephonyManager telephonyManager = (TelephonyManager)mContex.getSystemService(Context.TELEPHONY_SERVICE);


        return telephonyManager.getDeviceId();
    }


    public String encodeImage2base64(Bitmap image) {
        Bitmap immagex = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }


  /*  public String encodeString2Base64(String str){
        return Party.com.myapplication.utiles.Base64.encodeBytes(str.getBytes());
                //str.getBytes(),
                //Base64.DEFAULT);

    }*/



    public String setCurrentTimeOnView() {


        final Calendar c = Calendar.getInstance();
        int Hour = c.get(Calendar.HOUR_OF_DAY);
        int Mins = c.get(Calendar.MINUTE);
        int Day = c.get(Calendar.DAY_OF_MONTH);
        int Month = c.get(Calendar.MONTH);
        int Year = c.get(Calendar.YEAR);

        //yyyyMMdd:HH:mm:ss
        return checkDigit(Year)+checkDigit(Month+1)+checkDigit(Day)+":"+checkDigit(Hour)+":"+checkDigit(Mins)+":00";
    }



    private ProgressDialog mProgressDialog;

    public void showDialogProgress() {
        if(mProgressDialog==null)
            mProgressDialog = new ProgressDialog(mContex);
        else if(mProgressDialog.isShowing())
            mProgressDialog.dismiss();

        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("Enviando Información");
        mProgressDialog.show();
    }

    public void showDialogProgress(String msn) {
        if(mProgressDialog==null)
            mProgressDialog = new ProgressDialog(mContex);
        else if(mProgressDialog.isShowing())
            mProgressDialog.dismiss();

        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(msn);
        mProgressDialog.show();
    }

    public void dismissDialogProgress(){

        if(mProgressDialog!=null){
            if(mProgressDialog.isShowing())
                mProgressDialog.dismiss();
        }
    }


    public String getDateInNormalFormat(String datestr){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd:hh:mm:ss");

        SimpleDateFormat fmt2= new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = fmt.parse(datestr);
            return fmt2.format(date);
        }
        catch(Exception pe) {
            return "";

        }
    }


    public Bitmap redimensionarImagenMaximo(Bitmap mBitmap, float newWidth, float newHeigth){
        //Redimensionamos
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeigth) / height;
        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // recreate the new Bitmap
        return Bitmap.createBitmap(mBitmap, 0, 0, width, height, matrix, false);
    }



    /**
     * Metodo que recorta una imagen a un tamañao especifico.
     * @param bitmap
     * @param newWidth
     * @param newHeight
     * @return
     */
    public Bitmap recutImage(Bitmap bitmap, int newWidth,int newHeight) {



        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        //Primero se escala la imagen a un multiplo de nuevo tamaño

        int factorwidth=1280;
        int factorheigh=1020;
        if (width>=1920 && height>=1530){
            factorwidth=1920;
            factorheigh=1530;
        }
        else if(width<1920 && width >=1280 && height<1530 && height>=1020){
            factorwidth=1280;
            factorheigh=1020;
        }
        else if (width >=1280 && height>=1020){
            factorwidth=1280;
            factorheigh=1020;
        }
        else{
            factorwidth=640;
            factorheigh=510;
        }


        Bitmap recut=null;

        try {
            recut = Bitmap.createBitmap(bitmap, (int) (width - factorwidth) / 2, (int) (height - factorheigh) / 2, factorwidth, factorheigh);

        } catch (Exception e) {
            // TODO: handle exception
        }


        //return recut;

        if(recut!=null)
            return  Bitmap.createScaledBitmap(recut, newWidth, newHeight, true);//Normalmente
        else
            return  Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true);


    }


   /* public static Bitmap createScaledBitmap(Bitmap unscaledBitmap, int dstWidth, int dstHeight,
                                            ScalingLogic scalingLogic) {
        Rect srcRect = calculateSrcRect(unscaledBitmap.getWidth(), unscaledBitmap.getHeight(),
                dstWidth, dstHeight, scalingLogic);
        Rect dstRect = calculateDstRect(unscaledBitmap.getWidth(), unscaledBitmap.getHeight(),
                dstWidth, dstHeight, scalingLogic);
        Bitmap scaledBitmap = Bitmap.createBitmap(dstRect.width(), dstRect.height(),
                Config.ARGB_8888);
        Canvas canvas = new Canvas(scaledBitmap);
        canvas.drawBitmap(unscaledBitmap, srcRect, dstRect, new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaledBitmap;
    }*/

    public static Bitmap scaleCenterCrop(Bitmap source, int newHeight, int newWidth)
    {
        int sourceWidth = source.getWidth();
        int sourceHeight = source.getHeight();
        float xScale = (float) newWidth / sourceWidth;
        float yScale = (float) newHeight / sourceHeight;
        float scale = Math.max(xScale, yScale);

        //get the resulting size after scaling
        float scaledWidth = scale * sourceWidth;
        float scaledHeight = scale * sourceHeight;

        //figure out where we should translate to
        float dx = (newWidth - scaledWidth) / 2;
        float dy = (newHeight - scaledHeight) / 2;

        Bitmap dest = Bitmap.createBitmap(newWidth, newHeight, source.getConfig());
        Canvas canvas = new Canvas(dest);
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        matrix.postTranslate(dx, dy);
        canvas.drawBitmap(source, matrix, null);
        return dest;
    }


    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    public static Bitmap drawableToBitmap (Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888 );
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public static int getColorId(ColorsTheme colorsTheme,Context mContext) {

        switch (colorsTheme){
            case RED:
                return mContext.getResources().getColor(R.color.redToolbar);
            case GREEN:
                return mContext.getResources().getColor(R.color.yellowToobar);
            case PINK:
                return mContext.getResources().getColor(R.color.pinkToobar);
            case PURPLE:
                return mContext.getResources().getColor(R.color.purpleToobar);
            case PURPLE_B:
                return mContext.getResources().getColor(R.color.purpleBToobar);
            case BLUE:
                return mContext.getResources().getColor(R.color.blueToobar);
            case BLUE_C:
                return mContext.getResources().getColor(R.color.blueCToobar);
            case CYAN:
                return mContext.getResources().getColor(R.color.cyanToobar);
            case CYAN_B:
                return mContext.getResources().getColor(R.color.cyanBToobar);
            case ORANGE:
                return mContext.getResources().getColor(R.color.orangeToobar);
            case DEEP_ORANGE:
                return mContext.getResources().getColor(R.color.deeporangeToobar);
            case BROWN:
                return mContext.getResources().getColor(R.color.browToobar);
            case GRAY:
                return mContext.getResources().getColor(R.color.greyToobar);
            default:
                return mContext.getResources().getColor(R.color.browToobar);

        }


    }



}
