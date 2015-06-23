package se.kth.mrazovic.mobics.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import se.kth.mrazovic.mobics.R;
import se.kth.mrazovic.mobics.activities.MainActivity;
import se.kth.mrazovic.mobics.activities.NewHumanTaskActivity;
import se.kth.mrazovic.mobics.activities.NewSensingTaskActivity;
import se.kth.mrazovic.mobics.adapters.TaskListPagerAdapter;


public class HomeFragment extends Fragment {
    public static final String TAG = "se.kth.mrazovic.mobics.HOME_FRAGMENT";
    private ViewPager mViewPager;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Context context) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The fragment modifies option menu actions
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Set a toolbar to replace ActionBar
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        // Set title in the action bar
        getActivity().setTitle(getString(R.string.mobics));
        // Add menu up icon
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

        // Attaching adapter to ViewPager
        mViewPager = (ViewPager) view.findViewById(R.id.home_pager);
        TaskListPagerAdapter taskListPagerAdapter = new TaskListPagerAdapter(getChildFragmentManager(), getActivity());
        mViewPager.setAdapter(taskListPagerAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.home_sliding_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        // Set onClickListener for floating action button
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_create_new);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNewTaskActivity();
            }
        });

        return view;
    }

    public void launchNewTaskActivity() {
        int fragmentIndex = mViewPager.getCurrentItem();
        if (fragmentIndex == 0) {
            Intent intent = new Intent(getActivity(), NewHumanTaskActivity.class);
            startActivity(intent);
        } else if (fragmentIndex == 1) {
            Intent intent = new Intent(getActivity(), NewSensingTaskActivity.class);
            startActivity(intent);

        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_tasks, menu);
    }


}
