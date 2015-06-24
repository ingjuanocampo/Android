package partyup.com.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.PipedOutputStream;
import java.util.List;

import partyup.com.myapplication.R;

/**
 * Created by juan.ocampo on 24/06/2015.
 */
public class ArrayAdapterCities extends ArrayAdapter<String> {
    private Context mContext;
    private int mResource;
    private List<String> mData;
    public ArrayAdapterCities(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResource=resource;
        this.mData=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.view_row_city,parent,false);
        Holder.txtString= (TextView)view.findViewById(R.id.txt_item_city);
        Holder.txtString.setText(mData.get(position));




        return view;
    }

    public static class Holder{

        public static TextView txtString;





    }


}
