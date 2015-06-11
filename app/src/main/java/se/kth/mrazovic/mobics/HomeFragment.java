package se.kth.mrazovic.mobics;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Set title in the action bar
        getActivity().setTitle(getString(R.string.mobics));

        // Attaching adapter to ViewPager
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.home_pager);
        TaskListPagerAdapter taskListPagerAdapter = new TaskListPagerAdapter(getChildFragmentManager(), getActivity());
        viewPager.setAdapter(taskListPagerAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.home_sliding_tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


}
