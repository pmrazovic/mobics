package se.kth.mrazovic.mobics;

import android.support.v4.app.FragmentManager;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    private static final String CURRENT_CONTENT_TAG = "se.kth.mrazovic.mobics.current_content";
    private static final String CURRENT_CONTENT_NAV_ITEM = "se.kth.mrazovic.mobics.current_content_nav_item";

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private Fragment mCurrentContent;
    private MenuItem mCurrentContentNavItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a toolbar to replace ActionBar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        // Add menu and up icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find drawer layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Find drawer navigation view and implement OnNavigationItemSelectedListener interface
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(navigationView);
        // Setup action bar drawer toggle
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // Find the retained fragment on activity restarts
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            mCurrentContent = (Fragment) fragmentManager.findFragmentByTag(CURRENT_CONTENT_TAG);
            mCurrentContentNavItem = navigationView.getMenu().findItem(savedInstanceState.getInt(CURRENT_CONTENT_NAV_ITEM));
        }
        // Create fragment for the first time
        if (mCurrentContent == null) {
            mCurrentContent = HomeFragment.newInstance(this);
            mCurrentContentNavItem = navigationView.getMenu().findItem(R.id.nav_home);
        }
        // Replace fragment and check corresponding navigation item
        fragmentManager.beginTransaction().replace(R.id.content_frame, mCurrentContent, CURRENT_CONTENT_TAG).commit();
        mCurrentContentNavItem.setChecked(true);
    }

    // Implements OnNavigationItemSelectedListener interface
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                }
        );
    }

    // Replace fragments (or start new activity) on navigation item selected
    private void selectDrawerItem(MenuItem menuItem) {

        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                mCurrentContent = (Fragment) HomeFragment.newInstance(this);
                break;
            case R.id.nav_favorites:
                mCurrentContent = (Fragment) FavoriteTasksFragment.newInstance(this);
                break;
            case R.id.nav_responded:
                mCurrentContent = (Fragment) RespondedTasksFragment.newInstance(this);
                break;
            case R.id.nav_sent:
                mCurrentContent = (Fragment) SentTasksFragment.newInstance(this);
                break;
            case R.id.nav_profile:
                mCurrentContent = (Fragment) MyProfileFragment.newInstance(this);
                break;
            case R.id.nav_sensors:
                mCurrentContent = (Fragment) SensorsFragment.newInstance(this);
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_help:
                break;
            case R.id.nav_about:
                break;
        }

        if (mCurrentContent != null) {
            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, mCurrentContent, CURRENT_CONTENT_TAG).commit();

            // Highlight the selected item, update the title, and close the drawer
            mCurrentContentNavItem = menuItem;
            mCurrentContentNavItem.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save currently checked navigation item
        outState.putInt(CURRENT_CONTENT_NAV_ITEM, mCurrentContentNavItem.getItemId());
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
