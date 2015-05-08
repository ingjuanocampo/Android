package partyup.com.myapplication.DataBaseManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import partyup.com.myapplication.utiles.Definitions;


/**
 * Created by user on 19/03/2015.
 */
public class HandlerOffline {
    private Context mContext;

    private DatabaseControl mDatabaseOffline;


    public HandlerOffline(Context context){
        this.mContext=context;
        this.mDatabaseOffline = new DatabaseControl(context, Definitions.POLFA_PATH,Definitions.DB_OFFLINE);

    }



    public Cursor getDataAC(int type){
        Cursor dbCursor =null;
            try {
                mDatabaseOffline.open();
                dbCursor=mDatabaseOffline.select(Definitions.TABLET_AC_OFFLINE,Definitions.KEY_TIPO_AC, String.valueOf(type));
                     // dbCursor.getString(dbCursor.getColumnIndex(Definitions.KEY_ID_ROW));
            }catch (Exception e){
                e.printStackTrace();
            }

        return dbCursor;
    }
    /**
     *
     * @return
     */
    public int getNoOffileAcction(){

        int noAcctionsOffile=0;

        try {
            mDatabaseOffline.open();
                noAcctionsOffile= mDatabaseOffline.countRegisters(Definitions.TABLET_AC_OFFLINE,"");
        }catch (Exception e){
            e.printStackTrace();
        }
        return noAcctionsOffile;

    }

    /**
     *
     * @return
     */
    public int getNoOffileAcction(int type){

        int noAcctionsOffile=0;

        try {
            mDatabaseOffline.open();
        noAcctionsOffile= mDatabaseOffline.countRegisters(Definitions.TABLET_AC_OFFLINE," where "+ Definitions.KEY_TIPO_AC+ " = '" + type +"'");
        }catch (Exception e){
            e.printStackTrace();
        }
        return noAcctionsOffile;

    }

    /**
     *
     * @param Data
     * @param TokenId
     * @param TipoAc
     * @return Id_Row on DB
     */
    public int setOfflineAcction(String Data,String TokenId,int TipoAc){

        int id_row=0;

        try {
            mDatabaseOffline.open();

            ContentValues valuestoInsert= new ContentValues();

            valuestoInsert.put(Definitions.KEY_DATA,Data);
            valuestoInsert.put(Definitions.KEY_TOKEN,TokenId);
            valuestoInsert.put(Definitions.KEY_TIPO_AC,TipoAc);

            id_row=(int)mDatabaseOffline.insertRegister(Definitions.TABLET_AC_OFFLINE,valuestoInsert);


            mDatabaseOffline.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return id_row;

    }


    /**
     *
     * @param Data
     * @param id_local
     * @param id_server
     * @return Id_Row on DB
     */
    public int setOfflineFile(String Data,int id_local,int id_server){


        int id_row=0;
        try {
            mDatabaseOffline.open();

            ContentValues valuestoInsert= new ContentValues();

            valuestoInsert.put(Definitions.KEY_DATA,Data);
            valuestoInsert.put(Definitions.KEY_ID_LOCAL,id_local);
            valuestoInsert.put(Definitions.KEY_ID_SERVER,id_server);

            id_row=(int) mDatabaseOffline.insertRegister(Definitions.TABLET_ARCHIVOS,valuestoInsert);


            mDatabaseOffline.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return id_row;
    }


    /**
     *
     * @param Id_row
     * @return
     */
    public int  deleteOfflineAcctionControl(String Id_row){

        int id=0;
        try {
            mDatabaseOffline.open();

            id= mDatabaseOffline.deleteRegister(Definitions.TABLET_AC_OFFLINE,Definitions.KEY_ID_ROW,Id_row);

            mDatabaseOffline.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return id;
    }


    /**
     * Obtiene el numero de imagenes (paginas de documentos tambien)
     * que se encuentre offile en la base de datos
     * @return
     */
    public int getNoFilesOffline(){

        int noAcctionsOffile=0;

        try {
            mDatabaseOffline.open();
            noAcctionsOffile= mDatabaseOffline.countRegisters(Definitions.TABLET_ARCHIVOS,"");
        }catch (Exception e){
            e.printStackTrace();
        }
        return noAcctionsOffile;

    }

    /**
     *
     * @param id_local
     * @param id_server
     * @return
     */
    public int updateOfflineFile(int id_local,int id_server){

        int id_row=0;
        try {
            mDatabaseOffline.open();

            ContentValues valuestoInsert= new ContentValues();

            valuestoInsert.put(Definitions.KEY_ID_SERVER,id_server);

            id_row=(int) mDatabaseOffline.updateRegister(Definitions.TABLET_ARCHIVOS,valuestoInsert,Definitions.KEY_ID_LOCAL+" = '"+id_local+"'");


            mDatabaseOffline.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return id_row;
    }

    /**
     *
     * @param Id_row
     * @return
     */
    public int deleteOfflineFile(String Id_row){

        int id=0;
        try {
            mDatabaseOffline.open();

            id= mDatabaseOffline.deleteRegister(Definitions.TABLET_ARCHIVOS,Definitions.KEY_ID_ROW,Id_row);

            mDatabaseOffline.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return id;
    }






    public Cursor getFilesOfflineReady2Send(){

        Cursor dbCursor =null;
        try {
            mDatabaseOffline.open();
            dbCursor=mDatabaseOffline.selectWhereDiferent(Definitions.TABLET_ARCHIVOS,Definitions.KEY_ID_SERVER, String.valueOf(0));
            // dbCursor.getString(dbCursor.getColumnIndex(Definitions.KEY_ID_ROW));
        }catch (Exception e){
            e.printStackTrace();
        }

        return dbCursor;

    }




}
