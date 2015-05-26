package partyup.com.myapplication.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.method.CharacterPickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import partyup.com.myapplication.Interfaces.OnClickBarItem;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.R;

/**
 * Created by user on 07/05/2015.
 */
public class RecyclerAdapterBar extends RecyclerView.Adapter<RecyclerAdapterBar.PersonViewHolder>{

    private ArrayList<Bar> mBars= new ArrayList<>();
    private static OnClickBarItem mActividad;


    public RecyclerAdapterBar(ArrayList<Bar> bars, OnClickBarItem actividad){
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
        holder.personName.setText(mBars.get(position).getmName());
        holder.personAge.setText(mBars.get(position).getmSchedule());
        // personViewHolder.personPhoto.setImageResource(mBars.get(position).photoId);
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
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.bar_name);
            personAge = (TextView)itemView.findViewById(R.id.bar_hour);
            personPhoto = (ImageView)itemView.findViewById(R.id.bar_photo);



        }


    }

}