package partyup.com.myapplication.utiles;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by user on 12/03/2015.
 */
public class FileHelper {

    private Context mContext;
    private String fileName="";
  // private String directory="";
    private File mFile;
    private File mDir;
    private FileOutputStream outputStream;



    public FileHelper (Context context,String name,String dir){
        this.mContext=context;
        this.fileName=name;
    //    this.directory=dir;

        File file = new File(dir, fileName);

    }

    public FileHelper (Context context,String name){
        this.mContext=context;
        this.fileName=name;
       // this.directory=mContext.getAssets().toString(); //mContext.getFilesDir().toString();
       this.mDir = new File(Definitions.POLFA_PATH );
        //this.mFile= new File( "",fileName);

        if (!mDir.exists())
        {
            mDir.mkdirs();
        }


        this.mFile = new File(mDir, name);

        if (!mFile.exists())
        {
            try {
                mFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void saveIntoFile (String input){
        try {
            outputStream = new FileOutputStream(fileName);//mContext.openFileOutput(fileName, Context.MODE_APPEND);
            outputStream.write(input.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InputStream readFile(){
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(mFile));
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return in;

    }













}
