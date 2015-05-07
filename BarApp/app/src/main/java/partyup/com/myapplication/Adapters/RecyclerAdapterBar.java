package partyup.com.myapplication.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.R;

/**
 * Created by user on 07/05/2015.
 */
public class RecyclerAdapterBar extends RecyclerView.Adapter<RecyclerAdapterBar.PersonViewHolder>{

    ArrayList<Bar> mBars= new ArrayList<>();

    public RecyclerAdapterBar(ArrayList<Bar> bars){
        this.mBars= bars;

    }

    @Override
    public RecyclerAdapterBar.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_bar, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;

    }

    @Override
    public void onBindViewHolder(RecyclerAdapterBar.PersonViewHolder holder, int position) {
        holder.personName.setText(mBars.get(position).getmName());
        holder.personAge.setText(mBars.get(position).getmSchedule());
        // personViewHolder.personPhoto.setImageResource(mBars.get(position).photoId);
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