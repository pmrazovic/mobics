package se.kth.mrazovic.mobics.fragments;


import android.content.Context;
import android.os.Bundle;
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
import se.kth.mrazovic.mobics.adapters.TaskListPagerAdapter;


public class HomeFragment extends Fragment {
    public static final String TAG = "se.kth.mrazovic.mobics.HOME_FRAGMENT";

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
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.home_pager);
        TaskListPagerAdapter taskListPagerAdapter = new TaskListPagerAdapter(getChildFragmentManager(), getActivity());
        viewPager.setAdapter(taskListPagerAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.home_sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_tasks, menu);
    }


}
