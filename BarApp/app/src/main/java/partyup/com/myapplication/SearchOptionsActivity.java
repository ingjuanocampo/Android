package partyup.com.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import partyup.com.myapplication.Adapters.RecyclerAdapterSearch;
import partyup.com.myapplication.Interfaces.OnClickBarItem;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.Category;
import partyup.com.myapplication.Provider.HandlerProvider;
import partyup.com.myapplication.Provider.OnProviderResponse;
import partyup.com.myapplication.utiles.AndroidUtiles;


public class SearchOptionsActivity extends AppCompatActivity implements OnClickBarItem, View.OnClickListener{


    private RecyclerView mRecyclerSearchResults;
    private LinearLayoutManager mLinearLayoutManager;
    private ProgressBar mProgressBar;
    private ArrayList<Bar> mBarsSearch;
    private ImageView mImgFilter;
    private RelativeLayout mRelativeSearch;
    private View mViewFilterAdd;
    private boolean isFilterOpen=false;
    private Animation mSlideDown;
    private Animation mSlideUp;
    private SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_options);
        Toolbar mToolBar= (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(mToolBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findWidgetById();


        mLinearLayoutManager= new LinearLayoutManager(this);

        mRecyclerSearchResults.setLayoutManager(mLinearLayoutManager);


        HandlerProvider.getProvider().setmContext(this);

        HandlerProvider.getProvider().getBars(new Category("",""), new OnProviderResponse() {
            @Override
            public void onSucessResponse(Object responce) {

                mBarsSearch = (ArrayList<Bar>) responce;
                RecyclerAdapterSearch adapter = new RecyclerAdapterSearch(mBarsSearch, SearchOptionsActivity.this, SearchOptionsActivity.this);
                mRecyclerSearchResults.setAdapter(adapter);


                mProgressBar.setVisibility(View.GONE);

                mRecyclerSearchResults.setVisibility(View.VISIBLE);


            }

            @Override
            public void onFailResponse(String msn) {

            }
        },1);

        mSlideDown= AnimationUtils.loadAnimation(this,R.anim.slide_down);
        mSlideUp= AnimationUtils.loadAnimation(this,R.anim.slide_up);

    }

    private void findWidgetById() {

        mRecyclerSearchResults=(RecyclerView)findViewById(R.id.recyclerview_search_results);
        mProgressBar= (ProgressBar)findViewById(R.id.progress_bar);
        mImgFilter= (ImageView)findViewById(R.id.img_filter_button);
        mImgFilter.setOnClickListener(this);
        mRelativeSearch=(RelativeLayout)findViewById(R.id.relative_search_results);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_options, menu);
        // Only show items in the action bar relevant to this screen
        // if the drawer is not showing. Otherwise, let the drawer
        // decide what to show in the action bar.
        //getMenuInflater().inflate(R.menu.main, menu);



        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.w("onQueryTextSubmit", query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.w("onQueryTextChange", newText);

                return false;
            }
        });


        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setIconified(false);




        /// LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // LinearLayout llZone = (LinearLayout)inflater.inflate(R.layout.view_schedule, searchView, false);


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
    public void onClickBar(int pos) {

    }

    @Override
    public void onLastElement() {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.img_filter_button:
                if(isFilterOpen){
                    if(mViewFilterAdd!=null)
                        mViewFilterAdd.clearAnimation();

                    mViewFilterAdd.startAnimation(mSlideUp);

                    mRelativeSearch.removeView(mViewFilterAdd);
                    mImgFilter.setImageResource(R.drawable.ic_expand_more_white_24dp);
                    isFilterOpen=false;


                }else {
                    if(mViewFilterAdd!=null)
                        mViewFilterAdd.clearAnimation();

                    AndroidUtiles.keyBoardHide(searchView,this);
                    mImgFilter.setImageResource(R.drawable.ic_expand_less_white_24dp);

                    if(mViewFilterAdd==null){
                        mViewFilterAdd=getLayoutInflater().inflate(R.layout.view_filter_search,mRelativeSearch,false);

                    }

                    mViewFilterAdd.startAnimation(mSlideDown);

                    mRelativeSearch.addView(mViewFilterAdd);
                    isFilterOpen=true;
                }





                break;
        }

    }
}
