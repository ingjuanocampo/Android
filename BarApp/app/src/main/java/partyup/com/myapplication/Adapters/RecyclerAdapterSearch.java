package partyup.com.myapplication.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import partyup.com.myapplication.Interfaces.OnClickBarItem;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.ColorsTheme;
import partyup.com.myapplication.R;

/**
 * Created by juan.ocampo on 23/06/2015.
 */
public class RecyclerAdapterSearch extends RecyclerView.Adapter<RecyclerAdapterSearch.SearchViewHolder>{

    private final Context mContext;
    private ArrayList<Bar> mBars= new ArrayList<>();
    private static OnClickBarItem mActividad;


    public RecyclerAdapterSearch(ArrayList<Bar> bars, OnClickBarItem actividad,Context context){
        this.mContext=context;
        mActividad=actividad;
        this.mBars= bars;

    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_search_results, parent, false);
        SearchViewHolder pvh = new SearchViewHolder(v);
        return pvh;

    }

    @Override
    public void onBindViewHolder(RecyclerAdapterSearch.SearchViewHolder holder, final int position) {
        holder.txtBarName.setText(mBars.get(position).getmName());
       // holder.txtHours.setText(mBars.get(position).getmSchedule());
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


    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtBarName;
        //TextView txtHours;
        ImageView imgBarPhoto;
        TextView txtBarPrice;
        TextView txtBarAddress;
        LinearLayout lnCardview;

        SearchViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            txtBarName = (TextView)itemView.findViewById(R.id.txt_bar_name_search);
           // txtHours = (TextView)itemView.findViewById(R.id.bar_hour);
            imgBarPhoto = (ImageView)itemView.findViewById(R.id.img_bar_search);
            txtBarPrice= (TextView)itemView.findViewById(R.id.txt_price_search);
            txtBarAddress= (TextView)itemView.findViewById(R.id.txt_address_search);
            lnCardview=(LinearLayout)itemView.findViewById(R.id.linear_search);




        }


    }

}
