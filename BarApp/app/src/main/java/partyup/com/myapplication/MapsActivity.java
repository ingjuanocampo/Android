package partyup.com.myapplication;

import android.content.Intent;
import android.location.Location;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.Category;
import partyup.com.myapplication.Objects.ColorsTheme;
import partyup.com.myapplication.Provider.HandlerProvider;
import partyup.com.myapplication.Provider.OnProviderResponse;
import partyup.com.myapplication.utiles.AndroidUtiles;
import partyup.com.myapplication.utiles.Definitions;
import partyup.com.myapplication.utiles.GsonConverter;

public class MapsActivity extends AppCompatActivity implements GoogleMap.OnMyLocationChangeListener, View.OnClickListener,GoogleMap.OnMarkerClickListener,GoogleMap.OnMapClickListener{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available
    private Toolbar mToolbar;
    private FloatingActionButton mFABBtn;
    private LinearLayout mLinearSubBtns;
    private boolean isShowingSubBtns=false;
    private Animation mAnimRotate, mAnimOff, mAnimOn,mAnimRotateInverse, mAnimFadeIn, mAnimFadeOut;
    private LinearLayout mLinearMarketDetails;
    private boolean isVisibleDetails=false;
    private ArrayList<Bar>  mBars= new ArrayList<>();
    private Map <Marker,Integer> mMarksMap;
    private TextView txtPrice,txtName,txtDir;
    private ImageView imgClose;
    private ImageView imgBar;
    private LinearLayout lnViewDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);
        setUpMapIfNeeded();
        mToolbar= (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        moveCameratoCurrentCity();
        findWidgetById();



        getDataFromProvider();

        setAnimatios();



    }

    private void findWidgetById() {

        mFABBtn= (FloatingActionButton)findViewById(R.id.fab_btn_more_map);
        mFABBtn.setOnClickListener(this);
        mLinearSubBtns= (LinearLayout)findViewById(R.id.linear_sub_btn_maps);
        mLinearMarketDetails=(LinearLayout)findViewById(R.id.linear_view_market_details);
        imgBar=(ImageView)findViewById(R.id.img_bar_marker);
        imgClose=(ImageView)findViewById(R.id.img_close_marker_details);
        txtDir=(TextView)findViewById(R.id.txt_address_marker);
        txtName=(TextView)findViewById(R.id.txt_bar_name_marker);
        txtPrice=(TextView)findViewById(R.id.txt_price_marker);
        lnViewDetails =(LinearLayout)findViewById(R.id.linear_marker_details);

        //Preview Market Details


    }

    private void setAnimatios() {
        mAnimRotate= AnimationUtils.loadAnimation(this,R.anim.rotate);
        mAnimOff =AnimationUtils.loadAnimation(this,R.anim.translate_down);
        mAnimOn =AnimationUtils.loadAnimation(this,R.anim.grow_from_bottom);
        mAnimRotateInverse=AnimationUtils.loadAnimation(this,R.anim.rotate_inverse);
        mAnimFadeIn=AnimationUtils.loadAnimation(this,R.anim.abc_slide_in_top);
        mAnimFadeOut=AnimationUtils.loadAnimation(this,R.anim.slide_out_overrided);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();

    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(4.667118, -74.066265)));
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationChangeListener(this);
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);
    }

    @Override
    public void onMyLocationChange(Location location) {

        //CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),location.getLongitude()), 17);
        //mMap.moveCamera(cameraUpdate);

    }


    private void moveCameratoCurrentCity(){
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(4.667118, -74.066265), 10);
        mMap.moveCamera(cameraUpdate);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_btn_more_map:
                if(isShowingSubBtns){
                    isShowingSubBtns=false;
                    mLinearSubBtns.startAnimation(mAnimOff);
                    mLinearSubBtns.setLayoutAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            mLinearSubBtns.setVisibility(View.GONE);

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    //mLinearSubBtns.setVisibility(View.GONE);
                    mFABBtn.startAnimation(mAnimRotateInverse);


                }else {
                    mLinearSubBtns.setVisibility(View.VISIBLE);
                    mLinearSubBtns.startAnimation(mAnimOn);
                    mFABBtn.startAnimation(mAnimRotate);
                    isShowingSubBtns=true;

                }


                break;
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        //if(!isVisibleDetails){
            mLinearMarketDetails.setVisibility(View.VISIBLE);
            mLinearMarketDetails.startAnimation(mAnimFadeIn);
            isVisibleDetails=true;

            final Bar preViewBar=mBars.get(mMarksMap.get(marker));

            Picasso.
                    with(this).
                    load(preViewBar.getImage_url()).placeholder(R.drawable.keep_calm_and_still_loading_bk).
                    into(imgBar);
            txtPrice.setText(preViewBar.getPrice());
            txtName.setText(preViewBar.getmName());
            txtDir.setText(preViewBar.getmAddress());
            imgClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    closeDetailsWindows();
                }
            });

       lnViewDetails.setBackgroundColor(AndroidUtiles.getColorId(ColorsTheme.valueOf(preViewBar.getColor()), this));

        lnViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent= new Intent(MapsActivity.this,ActivitySiteDetails.class);
                detailIntent.putExtra(Definitions.Extra_1,GsonConverter.object2StringGson(preViewBar));
                startActivityForResult(detailIntent,0);

            }
        });






        //}




        return false;
    }



    @Override
    public void onMapClick(LatLng latLng) {

        closeDetailsWindows();


    }

    private void closeDetailsWindows() {
        if(isVisibleDetails){
            isVisibleDetails=false;
            mLinearMarketDetails.startAnimation(mAnimFadeOut);
            mLinearMarketDetails.setLayoutAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mLinearMarketDetails.setVisibility(View.GONE);


                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lnViewDetails.setOnClickListener(null);
        }

    }

    private int count = 0;

    public void getDataFromProvider() {

        mMarksMap= new HashMap<>();


        HandlerProvider.getProvider().getBars(new Category("",""), new OnProviderResponse() {
            @Override
            public void onSucessResponse(Object responce) {
                mBars=(ArrayList<Bar>)responce;



                for(Bar bar:mBars){
                    mMarksMap.put(mMap.addMarker(new MarkerOptions().position(bar.getCordinates()).icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_BLUE))), count++);

                }
            }
        },1);


    }
}
