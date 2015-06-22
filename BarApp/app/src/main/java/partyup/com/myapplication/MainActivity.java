package partyup.com.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.internal.ne;

import java.util.ArrayList;

import partyup.com.myapplication.Adapters.AdapterViewPagerTypeBars;
import partyup.com.myapplication.Adapters.TabPagerAdapter;
import partyup.com.myapplication.Objects.BarFragmentObject;
import partyup.com.myapplication.Objects.Category;
import partyup.com.myapplication.Provider.HandlerProvider;
import partyup.com.myapplication.Provider.Provider;
import partyup.com.myapplication.Provider.ProviderType;
import partyup.com.myapplication.views.SlidingTabLayout;


public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks,ElectronicBarFragment.OnFragmentInteractionListener,
        RomanticBarFragment.OnFragmentInteractionListener,FragmentMap.OnFragmentInteractionListener,FragmentCrossoverBar.OnFragmentInteractionListener {

    //private Toolbar mToolbar;
    private NavigationDrawerFragment mNavigationDrawerFragment;

    ActionBar actionBar;
    //private Fragment fragmentBars;
    private Fragment fragmentMap;

    //private ArrayList<BarFragmentObject> mBarsType;

    private Provider mProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_blacktoolbar);
        mTitle = getTitle();

        //fragmentBars= new ViewPageTypeBars();

        //as
        fragmentMap = new FragmentMap();

        //mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);




        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        mNavigationDrawerFragment.setup(
                R.id.fragment_drawer,
                (DrawerLayout) findViewById(R.id.drawer));

        actionBar = getSupportActionBar();

        // Specify that tabs should be displayed in the action bar.



        //mBarsType= HandlerProvider.getProvider().getFragmentsBars();
        //HandlerProvider.getProvider().setmContext(this);


        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            SlidingTabsBasicFragment fragment = new SlidingTabsBasicFragment();
            transaction.replace(R.id.container, fragment);
            transaction.commit();
        }
    }


    /*private void setAllFragmets() {



        for (int i=0;i<mBarsType.size();i++){

            /**CREAR TABS
            ActionBar.Tab tab = actionBar.newTab()
                    .setText(mBarsType.get(i).getTitle())
                    .setTabListener(new TabsListener(
                            this,mBarsType.get(i).getTitle() , mBarsType.get(i).getFragment().getClass()));
            actionBar.addTab(tab);
        }


    }*/
    //AdapterViewPagerTypeBars mBarsTypePagerAdapter;
    //ViewPager mViewPager;

   // private ArrayList<BarFragmentObject> mBarsType;

  /*  private void setViewTabPager(){

        mBarsType= new ArrayList<>();
        mBarsType.add(new BarFragmentObject("ELECTRONICA",new ElectronicBarFragment()));
        mBarsType.add(new BarFragmentObject("ROMANTICO", new RomanticBarFragment()));

        mBarsTypePagerAdapter =
                new AdapterViewPagerTypeBars(
                        getSupportFragmentManager(),mBarsType);
        mViewPager = (ViewPager)findViewById(R.id.pager);
        try{
            if(mViewPager.getAdapter().getCount()==0){
                mViewPager.setAdapter(mBarsTypePagerAdapter);
            }
        }catch (Exception e){
            e.printStackTrace();
            mViewPager.setAdapter(mBarsTypePagerAdapter);

        }


    }*/

    private ViewPager Tab;
    private TabPagerAdapter TabAdapter;

    private void setSwipeTabMode() {
        /*TabAdapter = new TabPagerAdapter(getSupportFragmentManager(),mBarsType);
        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        actionBar = getSupportActionBar();
                        actionBar.setSelectedNavigationItem(position);
                    }
                });
        Tab.setAdapter(TabAdapter);*/


        Tab = (ViewPager)findViewById(R.id.pager);

       // TabAdapter = new TabPagerAdapter(this,mBarsType,getSupportFragmentManager());

        Tab.setAdapter(TabAdapter);
        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(Tab);




    }



    public class TabsListener  implements ActionBar.TabListener {

        private Fragment fragment;
        private final String tag;

        public TabsListener(Activity activity, String tag, Class cls) {
            this.tag = tag;
            fragment = Fragment.instantiate(activity, cls.getName());
        }

        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            //ft.replace(android.R.id.content, fragment);  //SOLO ESTO SE DEBE RESPLAZAR PARA INHABILITAR EL SWIPE
            //Toast.makeText(getApplicationContext(),tag,Toast.LENGTH_SHORT).show();
            //settitleActionBar(tag);
            View focus = getCurrentFocus();
            if (focus != null) {
               // mAD_utiles.keyBoardHide(focus);
            }
            Tab.setCurrentItem(tab.getPosition());
        }

        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            //ft.remove(fragment);// se movio para intentar matar fragmets
            View focus = getCurrentFocus();
            if (focus != null) {
               // mAD_utiles.keyBoardHide(focus);
            }
        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}
    }


    private CharSequence mTitle;


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    //Para retornar al menu habilitar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);


            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public void onNavigationDrawerItemSelected(int position) {


        switch (position){
            case 0:

                if (oldFargment!=null)
                    fragmentTransaction.remove(oldFargment);
                break;
            case 1:
                //fragmentExecuter(fragmentMap);
                Intent intent = new Intent(this,MapsActivity.class);
                startActivityForResult(intent,0);

                break;


        }
        //startActivity(new Intent(this,ViewPageTypeBars.class));
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();


    }


    Fragment oldFargment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
  /*  private void fragmentExecuter(Fragment fragment){


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();


        if(fragment!=null){
            if(!fragment.isAdded()){

                if (oldFargment!=null)
                    fragmentTransaction.remove(oldFargment);

                fragmentTransaction.add(R.id.container, fragment);
                //fragmentTransaction.addToBackStack(fragment.getTag());

                fragmentTransaction.commit();

            }else if(oldFargment!=fragment){

                fragmentTransaction.remove(oldFargment);

                fragmentTransaction.replace(R.id.container, fragment);

                fragmentTransaction.commit();
            }

            oldFargment=fragment;

        }

    }*/

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
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
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
