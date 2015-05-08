package partyup.com.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks,ElectronicBarFragment.OnFragmentInteractionListener,
        RomanticBarFragment.OnFragmentInteractionListener,FragmentMap.OnFragmentInteractionListener {

    //private Toolbar mToolbar;
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_blacktoolbar);
        mTitle = getTitle();

        //mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);



        //setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);




        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        mNavigationDrawerFragment.setup(
                R.id.fragment_drawer,
                (DrawerLayout) findViewById(R.id.drawer));
    }

    private CharSequence mTitle;


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

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
                fragmentExecuter(new ViewPageTypeBars());

                break;
            case 1:
                fragmentExecuter(new FragmentMap());

                break;


        }
        //startActivity(new Intent(this,ViewPageTypeBars.class));
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();


    }


    Fragment oldFargment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private void fragmentExecuter(Fragment fragment){


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

    }

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
