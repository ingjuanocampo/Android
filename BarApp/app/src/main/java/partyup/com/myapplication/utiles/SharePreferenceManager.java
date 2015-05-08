package partyup.com.myapplication.utiles;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by user on 24/12/2014.
 */
public class SharePreferenceManager {

    private Context mContext;
    private SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public SharePreferenceManager(Context context){
        this.mContext=context;

        prefs = PreferenceManager
                .getDefaultSharedPreferences(mContext);
        editor=prefs.edit();
    }

    public String getStringMemory(String Tag){
        return prefs.getString(Tag,"");
    }
    public int getIntMemory(String Tag){
        return prefs.getInt(Tag,0);
    }
    public float getFloatMemory(String Tag){
        return prefs.getFloat(Tag,0);
    }
    public boolean getBooleanMemory(String Tag){
        return prefs.getBoolean(Tag,false);
    }
    public long getLongMemmory(String Tag){
        return prefs.getLong(Tag,0);
    }


    public void putInMemory(String Tag, Object object){
        try {
            if (object instanceof Integer){
                editor.putInt(Tag,(Integer)object);
            }else if (object instanceof Float){
                editor.putFloat(Tag,(Float)object);
            }else if (object instanceof String){
                editor.putString(Tag,(String)object);
            }else if (object instanceof Boolean){
                editor.putBoolean(Tag,(Boolean)object);
            }else if (object instanceof Long){
                editor.putLong(Tag,(Long)object);
            }
            editor.commit();

        }catch (Exception e){
            Log.e("SharePrefeceManager", "No se puede escribir en memoria");
        }
    }


    public void clearAllData() {
        editor.clear();
        editor.commit();

    }
}
