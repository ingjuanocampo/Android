package partyup.com.myapplication.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import partyup.com.myapplication.Interfaces.OnClickBarItem;
import partyup.com.myapplication.Interfaces.OnLastServerItem;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.ColorsTheme;
import partyup.com.myapplication.R;

/**
 * Created by user on 07/05/2015.
 */
public class RecyclerAdapterBar extends RecyclerView.Adapter<RecyclerAdapterBar.PersonViewHolder> implements OnLastServerItem{

    private final Context mContext;
    private ArrayList<Bar> mBars= new ArrayList<>();
    private static OnClickBarItem mActividad;
    private boolean isLastItem=false;
    private ProgressBar pg;


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

        try{

            holder.txtHours.setText(mBars.get(position).getBars_week_schedules().get(0).getStart_week_day()+" - " +
                    mBars.get(position).getBars_week_schedules().get(0).getEnd_week_day());

        }catch (NullPointerException | IndexOutOfBoundsException e){

        }



        holder.txtBarPrice.setText(mBars.get(position).getPrice());
        holder.txtBarAddress.setText(mBars.get(position).getmAddress());
        Picasso.with(mContext).
                load(mBars.get(position).getImage_url())
                .placeholder(R.drawable.keep_calm_and_still_loading_bk)
                .into(holder.imgBarPhoto);

        holder.lnCardview.setBackgroundColor(getColorId(ColorsTheme.valueOf(mBars.get(position).getColor())));


        // ;
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActividad.onClickBar(position);
            }
        });

        if(!isLastItem && position==(mBars.size()-1)){
            holder.buttonProgressBar.setVisibility(View.VISIBLE);

            mActividad.onLastElement();
        }else {
            holder.buttonProgressBar.setVisibility(View.GONE);

        }

        pg=holder.buttonProgressBar;


    }

    private int getColorId(ColorsTheme colorsTheme) {

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

    @Override
    public int getItemCount() {
        return mBars.size();
    }

    @Override
    public void onLastServerItem() {
        isLastItem=true;
        pg.setVisibility(View.GONE);
    }


    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtBarName;
        TextView txtHours;
        ImageView imgBarPhoto;
        TextView txtBarPrice;
        TextView txtBarAddress;
        LinearLayout lnCardview;
        ProgressBar buttonProgressBar;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            txtBarName = (TextView)itemView.findViewById(R.id.bar_name);
            txtHours = (TextView)itemView.findViewById(R.id.bar_hour);
            imgBarPhoto = (ImageView)itemView.findViewById(R.id.bar_photo);
            txtBarPrice= (TextView)itemView.findViewById(R.id.bar_price);
            txtBarAddress= (TextView)itemView.findViewById(R.id.bar_dir);
            lnCardview=(LinearLayout)itemView.findViewById(R.id.linear_cardview_item);
            buttonProgressBar=(ProgressBar)itemView.findViewById(R.id.linear_progress);

        }


    }

}