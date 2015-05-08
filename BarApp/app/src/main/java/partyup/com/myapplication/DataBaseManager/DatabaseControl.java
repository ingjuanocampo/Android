package partyup.com.myapplication.DataBaseManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by user on 12/03/2015.
 *
 *
 */
public class DatabaseControl {

    private Context mContext;
    private DBHelper mDbHelper;
    private SQLiteDatabase mDatabase;


    public DatabaseControl(Context context,String path,String dbName){
        this.mContext=context;
        this.mDbHelper=new DBHelper(context,path,dbName);
    }

    public void close (){
        mDbHelper.close();
    }

    public DatabaseControl open() throws SQLException {
        mDatabase= mDbHelper.openDataBase(); //mDbHelper.getWritableDatabase();
        return this;
    }

    public Cursor select (String FromTable){


        Cursor cr=mDatabase.rawQuery("Select * From "+FromTable, null);//("SELECT name FROM sqlite_master WHERE type='table'",null); //

        return  cr;
    }

    public Cursor select (String x,String FromTable){

        Cursor cr=mDatabase.rawQuery("Select "+ x + " From "+FromTable, null);//("SELECT name FROM sqlite_master WHERE type='table'",null); //

        return  cr;

    }

    public Cursor select(String FromTable,String where,String data){
        Cursor cr=mDatabase.rawQuery("Select * From "+FromTable+" Where "+where +"= '"+data+"' ", null);

        return  cr;
    }

    public Cursor select(String FromTable,String where,String data,String AND){
        Cursor cr=mDatabase.rawQuery("Select * From "+FromTable+" Where "+where +"= '"+data+"' ", null);

        return  cr;
    }


    public Cursor selectWhereDiferent(String FromTable,String where,String data){
        Cursor cr=mDatabase.rawQuery("Select * From "+FromTable+" Where "+where +" != '"+data+"' ", null);

        return  cr;
    }


    //ESTE
    public Cursor select(String FromTable,String coparation,String data,String OrderBy,String Order){
        Cursor cr=mDatabase.rawQuery("Select * From "+FromTable+" Where "+coparation +"= '"+data+"' "+
                " ORDER BY "+  OrderBy + " "+Order, null);
        return  cr;
    }


    public Cursor select(String FromTable,String where,String data,String AND,String OrderBy,String Order){
        Cursor cr=mDatabase.rawQuery("Select * From "+FromTable+" Where "+where +"= '"+data+"' "+AND+
                " ORDER BY "+  OrderBy + " "+Order, null);

        return  cr;
    }

    public Cursor selectOrderby(String FromTable,String OrderBy,String Order){

        Cursor cr=mDatabase.rawQuery("Select * From "+FromTable+
                " ORDER BY "+  OrderBy + " "+Order, null);
        return  cr;

    }

    public long insertRegister(String table,ContentValues values){

        return mDatabase.insert(table, null, values);

    }

    public long updateRegister (String table,ContentValues valuestoUpdate,String where){
        return mDatabase.update(table, valuestoUpdate, where, null);
    }
    
    public int countRegisters(String table,String where){

        int total=0;
        String sqlTotal = "SELECT count(*) AS total FROM "+table+where;
        Cursor dbCursor = mDatabase.rawQuery(sqlTotal, null);

        for (dbCursor.moveToFirst(); !dbCursor.isAfterLast(); dbCursor.moveToNext()) {
            total = dbCursor.getInt(dbCursor.getColumnIndex("total"));
        }

        return total;

    }


    public int deleteRegister(String table,String where,String data){

            try
            {
                return mDatabase.delete(table, where + "=" + data, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;

    }


}
