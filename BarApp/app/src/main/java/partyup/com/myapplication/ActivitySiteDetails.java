package partyup.com.myapplication;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import partyup.com.myapplication.Adapters.AdapterListDetails;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.ColorsTheme;
import partyup.com.myapplication.Objects.ItemDetails;
import partyup.com.myapplication.utiles.Definitions;
import partyup.com.myapplication.utiles.GsonConverter;


public class ActivitySiteDetails extends AppCompatActivity {


    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Bar mBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentParent= getIntent();
        Bundle extras= intentParent.getExtras();
        String strBar= extras.getString(Definitions.Extra_1);
        mBar= GsonConverter.gson2Bar(strBar);


        setCustomThemes((ColorsTheme.valueOf(mBar.getColor())));
        setContentView(R.layout.activity_activity_site_details);

        Toolbar mToolbar = (Toolbar)findViewById(R.id.toolbar);

        mCollapsingToolbarLayout= (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle(mBar.getmName());

        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imgBackGround= (ImageView)findViewById(R.id.backdrop);
        //imgBackGround.setImageResource(R.drawable.keep_calm_and_still_loading);

        Picasso.with(this)
                .load(mBar.getImage_url())
                .placeholder(R.drawable.keep_calm_and_still_loading)
                .into(imgBackGround);





        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);


        LinearLayoutManager mManager  = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mManager);

        AdapterListDetails mAdapter= new AdapterListDetails(getDatatoViews());

        mRecyclerView.setAdapter(mAdapter);

    }

    private List<ItemDetails> getDatatoViews() {

        ArrayList<ItemDetails> data= new ArrayList<>();


        ItemDetails item = new ItemDetails();

        item.setmImgResource(R.drawable.ic_description_black_24dp);
        item.setmData(mBar.getDescription());
        item.setFlags("trueDescriptor");

        data.add(item);
        item = new ItemDetails();

        item.setmImgResource(R.drawable.ic_directions_black_24dp);
        item.setmData(mBar.getmAddress());
        item.setmTitle("Dirección");
        item.setFlags("ButtonON");



        data.add(item);
        item = new ItemDetails();
        item.setmImgResource(R.drawable.ic_attach_money_black_24dp);
        item.setmData(mBar.getPrice());
        item.setmTitle("Precio Promedio");

        data.add(item);


        item = new ItemDetails();
        item.setmImgResource(R.drawable.ic_schedule_black_24dp);


        try{

            item.setmData(mBar.getBars_week_schedules().get(0).getStart_week_day()+" - " +
                    mBar.getBars_week_schedules().get(0).getEnd_week_day());

        }catch (NullPointerException | IndexOutOfBoundsException e){
            e.printStackTrace();
        }


        item.setmTitle("Horario");

        data.add(item);


        item = new ItemDetails();

        item.setmImgResource(R.drawable.ic_web_black_24dp);
        item.setmData(mBar.getPaymentsSystem());
        item.setmTitle("Medios de Pago");


        data.add(item);
        item = new ItemDetails();
        item.setmImgResource(R.drawable.ic_contact_phone_black_24dp);
        item.setmData(mBar.getPhones());
        item.setmTitle("Contacto");

        data.add(item);
        item = new ItemDetails();

        item.setmImgResource(R.drawable.ic_style_black_24dp);
        item.setmData(mBar.getCategory());
        item.setmTitle("Categoria");

        data.add(item);


        item = new ItemDetails();

        item.setmImgResource(R.drawable.ic_insert_link_black_24dp);
        item.setmData(mBar.getWebSite());
        item.setmTitle("Web Site");

        data.add(item);

        item = new ItemDetails();

        item.setmImgResource(R.drawable.ic_library_music_black_24dp);
        item.setmData(mBar.getMusicStyle());
        item.setmTitle("Musica");

        data.add(item);

        return data;


    }

    private void setCustomThemes(ColorsTheme color) {
        Window window = getWindow();

        switch (color){
            case RED:
                setColorTheme(R.style.AppThemeRed,R.color.redStatusBar);
                break;
            case GREEN:
                setColorTheme(R.style.AppThemeYellow,R.color.yellowStatusBar);
                break;
            case PINK:

                setColorTheme(R.style.AppThemePink,R.color.pinkStatusBar);
                break;
            case PURPLE:
                setColorTheme(R.style.AppThemePurple,R.color.purpleStatusBar);
                break;
            case PURPLE_B:
                setColorTheme(R.style.AppThemePurpleB,R.color.purpleBStatusBar);
                break;
            case BLUE:
                setColorTheme(R.style.AppThemeBlue,R.color.blueStatusBar);
                break;
            case BLUE_C:
                setColorTheme(R.style.AppThemeBlueC,R.color.blueCStatusBar);
                break;
            case CYAN:
                setColorTheme(R.style.AppThemeCyan,R.color.cyanStatusBar);
                break;
            case CYAN_B:
                setColorTheme(R.style.AppThemeCyanB,R.color.cyanBStatusBar);
                break;
            case ORANGE:
                setColorTheme(R.style.AppThemeOrange,R.color.orangeStatusBar);
                break;
            case DEEP_ORANGE:
                setColorTheme(R.style.AppThemeDeepOrange,R.color.deeporangeStatusBar);
                break;
            case BROWN:
                setColorTheme(R.style.AppThemeBrown,R.color.brownStatusBar);
                break;
            case GRAY:
                setColorTheme(R.style.AppThemeGrey,R.color.greyStatusBar);
                break;

        }


    }

    private void setColorTheme(int appTheme, int colorStatusBar) {
        Window window = getWindow();

        setTheme(appTheme);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
            window.setStatusBarColor(getResources().getColor(colorStatusBar));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_bar_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else {
            finish();
            return true;
        }

        //return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.w("onBackpressed","ActivitySite");
    }









}
