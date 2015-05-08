package partyup.com.myapplication.utiles;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import partyup.com.myapplication.R;


/**
 * Created by user on 13/02/2015.
 */
public class PopUpHandler {

    private Context mContext;
    private int mResourseId;

    private View popupView;
    private PopupWindow popupWindow;
    public PopUpHandler(Context context,int resource){
        this.mContext=context;
        this.mResourseId=resource;
    }


    public View showPopUpLayaot() {
        LayoutInflater layoutInflater
                = (LayoutInflater) mContext
                .getSystemService(mContext.LAYOUT_INFLATER_SERVICE);


        popupView = layoutInflater.inflate(mResourseId, null);

         popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setAnimationStyle(R.anim.zoom_in);
        popupWindow.setFocusable(true);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
            }
        }, 100);

        return popupView;
    }

    public void closePopUpView(){

        popupWindow.dismiss();

    }
}
