package se.kth.mrazovic.mobics.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import se.kth.mrazovic.mobics.fragments.FavoriteTasksFragment;
import se.kth.mrazovic.mobics.fragments.HomeFragment;
import se.kth.mrazovic.mobics.fragments.MyProfileFragment;
import se.kth.mrazovic.mobics.R;
import se.kth.mrazovic.mobics.fragments.RespondedTasksFragment;
import se.kth.mrazovic.mobics.fragments.SensorsFragment;
import se.kth.mrazovic.mobics.fragments.SentTasksFragment;


public class MainActivity extends AppCompatActivity {
    private final String CURRENT_CONTENT_TAG = "se.kth.mrazovic.mobics.CURRENT_CONTENT_TAG";
    private final String CURRENT_CONTENT_NAV_ITEM = "se.kth.mrazovic.mobics.CURRENT_CONTENT_NAV_ITEM";

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Fragment mCurrentContent;
    private String mCurrentContentTag;
    private MenuItem mCurrentContentNavItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make status bar transparent for SDK 21 and higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);

        // Set a toolbar to replace ActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Add menu up icon
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
            mCurrentContentTag = savedInstanceState.getString(CURRENT_CONTENT_TAG);
            mCurrentContent = (Fragment) fragmentManager.findFragmentByTag(mCurrentContentTag);
            mCurrentContentNavItem = navigationView.getMenu().findItem(savedInstanceState.getInt(CURRENT_CONTENT_NAV_ITEM));
        }
        // Create fragment for the first time
        if (mCurrentContent == null || mCurrentContentTag == null) {
            mCurrentContent = HomeFragment.newInstance(this);
            mCurrentContentTag = HomeFragment.TAG;
            mCurrentContentNavItem = navigationView.getMenu().findItem(R.id.nav_home);
        }
        // Replace fragment and check corresponding navigation item
        fragmentManager.beginTransaction().replace(R.id.content_frame, mCurrentContent, mCurrentContentTag).commit();
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
        Fragment newContent = null;
        String newContentTag = null;

        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                newContent = (Fragment) HomeFragment.newInstance(this);
                newContentTag = HomeFragment.TAG;
                break;
            case R.id.nav_favorites:
                newContent = (Fragment) FavoriteTasksFragment.newInstance(this);
                newContentTag = FavoriteTasksFragment.TAG;
                break;
            case R.id.nav_responded:
                newContent = (Fragment) RespondedTasksFragment.newInstance(this);
                newContentTag = RespondedTasksFragment.TAG;
                break;
            case R.id.nav_sent:
                newContent = (Fragment) SentTasksFragment.newInstance(this);
                newContentTag = SentTasksFragment.TAG;
                break;
            case R.id.nav_profile:
                newContent = (Fragment) MyProfileFragment.newInstance(this);
                newContentTag = MyProfileFragment.TAG;
                break;
            case R.id.nav_sensors:
                newContent = (Fragment) SensorsFragment.newInstance(this);
                newContentTag = SensorsFragment.TAG;
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_help:
                // Start new activity
                Intent helpIntent = new Intent(this, HelpActivity.class);
                startActivity(helpIntent);
                break;
            case R.id.nav_about:
                // Start new activity
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }

        // Replace content fragment of new activity is not started
        if (newContent != null && newContentTag != null) {
            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, newContent, newContentTag).commit();
            mCurrentContent = newContent;
            mCurrentContentTag = newContentTag;

            // Highlight the selected item, update the title, and close the drawer
            mCurrentContentNavItem = menuItem;
            mCurrentContentNavItem.setChecked(true);
        }
        mDrawerLayout.closeDrawers();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save currently checked navigation item
        outState.putString(CURRENT_CONTENT_TAG, mCurrentContentTag);
        outState.putInt(CURRENT_CONTENT_NAV_ITEM, mCurrentContentNavItem.getItemId());
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
