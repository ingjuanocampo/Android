package partyup.com.myapplication.Adapters;

import android.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import partyup.com.myapplication.Objects.ItemDetails;
import partyup.com.myapplication.R;

/**
 * Created by juan.ocampo on 12/06/2015.
 */
public class AdapterListDetails extends RecyclerView.Adapter<AdapterListDetails.Viewitem> {


    private List<ItemDetails> mData;

    public AdapterListDetails(List<ItemDetails> data){
        this.mData=data;


    }

    @Override
    public Viewitem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_schedule,parent,false);

        Viewitem v = new Viewitem(view);



        return v;
    }

    @Override
    public void onBindViewHolder(Viewitem holder, int position) {

        try {
            if(mData.get(position).getFlags().equals("trueDescriptor")){
                holder.txtDescripcion.setVisibility(View.VISIBLE);
                holder.txtDescripcion.setText(mData.get(position).getmData());
                holder.mTitle.setVisibility(View.GONE);
                holder.mData.setVisibility(View.GONE);
            }else if (mData.get(position).getFlags().equals("ButtonON")){
                holder.btnItem.setVisibility(View.VISIBLE);

            }

        }catch (NullPointerException e){

        }

        holder.mImageView.setImageResource(mData.get(position).getmImgResource());
        holder.mTitle.setText(mData.get(position).getmTitle());
        holder.mData.setText(mData.get(position).getmData());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class Viewitem extends RecyclerView.ViewHolder {


        private TextView mTitle;
        private TextView mData;
        private ImageView mImageView;
        private TextView txtDescripcion;
        private Button btnItem;

        public Viewitem(View itemView) {
            super(itemView);

            mTitle=(TextView)itemView.findViewById(R.id.txt_label_details);
            mImageView=(ImageView)itemView.findViewById(R.id.img_view_details);
            mData=(TextView)itemView.findViewById(R.id.text1_details);
            txtDescripcion=(TextView)itemView.findViewById(R.id.txt_label_description);
            btnItem=(Button)itemView.findViewById(R.id.btn_item_detail);




        }
    }






}
