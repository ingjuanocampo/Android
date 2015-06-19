package partyup.com.myapplication.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import partyup.com.myapplication.Interfaces.OnClickBarItem;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.R;

/**
 * Created by user on 07/05/2015.
 */
public class RecyclerAdapterBar extends RecyclerView.Adapter<RecyclerAdapterBar.PersonViewHolder>{

    private final Context mContext;
    private ArrayList<Bar> mBars= new ArrayList<>();
    private static OnClickBarItem mActividad;


    public RecyclerAdapterBar(ArrayList<Bar> bars, OnClickBarItem actividad,Context context){
        this.mContext=context;
        mActividad=actividad;
        this.mBars= bars;

    }

    @Override
    public RecyclerAdapterBar.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_bar, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;

    }

    @Override
    public void onBindViewHolder(RecyclerAdapterBar.PersonViewHolder holder, final int position) {
        holder.txtBarName.setText(mBars.get(position).getmName());
        holder.txtHours.setText(mBars.get(position).getmSchedule());
        holder.txtBarPrice.setText(mBars.get(position).getPrice());
        holder.txtBarAddress.setText(mBars.get(position).getmAddress());
        Picasso.with(mContext).
                load(mBars.get(position).getImage_url())
                .placeholder(R.drawable.keep_calm_and_still_loading_bk)
                .into(holder.imgBarPhoto);


        // ;
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActividad.onClickBar(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBars.size();
    }


    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtBarName;
        TextView txtHours;
        ImageView imgBarPhoto;
        TextView txtBarPrice;
        TextView txtBarAddress;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            txtBarName = (TextView)itemView.findViewById(R.id.bar_name);
            txtHours = (TextView)itemView.findViewById(R.id.bar_hour);
            imgBarPhoto = (ImageView)itemView.findViewById(R.id.bar_photo);
            txtBarPrice= (TextView)itemView.findViewById(R.id.bar_price);
            txtBarAddress= (TextView)itemView.findViewById(R.id.bar_dir);




        }


    }

}