package partyup.com.myapplication.DataBaseManager;


import android.annotation.SuppressLint;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import partyup.com.myapplication.utiles.Definitions;


public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private final Context myContext;
    private static String DATABASE_NAME ="";//= Definitions.DOMINIOS;
    @SuppressLint("SdCardPath")
    private static String DB_PATH = ""; // Context.getFilesDir().getPath()
    private SQLiteDatabase baseDatos;
    private static int state = -1;
    private static final String DATABASE_TABLE = Definitions.TABLE_DOMINIOS_POLFA;

    public DBHelper(Context context,String path,String name) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //DB_PATH=Definitions.POLFA_PATH;  ///"/POLFA_DB_COPY/"; //context.getFilesDir().getPath(); //Environment.getExternalStorageDirectory().getAbsolutePath() + "/POLFA_DB");//context.getFilesDir().getPath();

        this.DB_PATH=path;
        this.DATABASE_NAME=name;
        this.myContext = context;
        try {
            createDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a empty database on the system and rewrites it with your own
     * database.
     * */
    public void createDataBase() throws IOException {
        SQLiteDatabase db_Read = null;
        if (checkDataBase())
            state = 0;
        else {
            // By calling this method and empty database will be created into
            // the default system path
            // of your application so we are gonna be able to overwrite that
            // database with our database.
            db_Read = this.getReadableDatabase();// (DATABASE_NAME);
            db_Read.close();
            try {
                copyDataBase();
                Log.d("DATABASE CREATED", "SUCCESSFULLY!");
                state = 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each
     * time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READONLY);
           Map<String,String > map = checkDB.getSyncedTables();
            if(map.containsKey(Definitions.TABLE_DOMINIOS_POLFA))
                Log.w("Si", "");
        } catch (SQLiteException e) {// database does't exist yet.
            e.printStackTrace();

        }
        if (checkDB != null)
            checkDB.close();
        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     * */

    private void copyDataBase() throws IOException {
        // Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DATABASE_NAME);
        // Path to the just created empty db
        String outFileName = DB_PATH + DATABASE_NAME;
        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);
        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0)
            myOutput.write(buffer, 0, length);
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

  /*  private void copyDataBase() throws IOException {
        // Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DATABASE_NAME);
        // Path to the just created empty db
        File dir = new File(DB_PATH);
        dir.mkdirs();

        //String outFileName = DB_PATH + DATABASE_NAME;
        // Open the empty db as the output stream


        File file = new File(dir,DATABASE_NAME);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OutputStream myOutput = new FileOutputStream(file);
        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0)
            myOutput.write(buffer, 0, length);
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }*/
    /* private void copyDataBase() throws IOException {
        // Open your local db as the input stream
        //InputStream myInput = myContext.getAssets().open(DATABASE_NAME);

        FileHelper mFileHelper = new FileHelper(myContext,Definitions.DOMINIOS);
        InputStream myInput = mFileHelper.readFile();
        // Path to the just created empty db
        File dir = new File(DB_PATH);
        dir.mkdirs();

        //String outFileName = DB_PATH + DATABASE_NAME;
        // Open the empty db as the output stream


        File file = new File(dir, Definitions.DOMINIOS);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OutputStream myOutput = new FileOutputStream(file);
        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0)
            myOutput.write(buffer, 0, length);
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }*/

    /**
     * Open database in Specific path
     * DO NOT USE open() by default.
     * @return
     * @throws SQLException
     */
    public SQLiteDatabase openDataBase() throws SQLException {
        // Open the database
        this.close();
        String myPath = DB_PATH + DATABASE_NAME;
        return baseDatos = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized void close() {
        if (baseDatos != null)
            baseDatos.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    public SQLiteDatabase getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(SQLiteDatabase baseDatos) {
        this.baseDatos = baseDatos;
    }

    public static int getState() {
        return state;
    }

    public static void setState(int state) {
        DBHelper.state = state;
    }
}