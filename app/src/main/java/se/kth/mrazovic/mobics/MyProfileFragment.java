package se.kth.mrazovic.mobics;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MyProfileFragment extends Fragment {
    private static int ACTION_EDIT_PROFILE_ID  = Menu.FIRST;


    public MyProfileFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Context context) {
        MyProfileFragment fragment = new MyProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
        // The fragment modifies option menu actions
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(getString(R.string.my_profile));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_profile, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        // Remove all menu action items
        menu.clear();
        // Add new menu action for editing profile
        MenuItem item = menu.add(Menu.NONE, ACTION_EDIT_PROFILE_ID, Menu.NONE, R.string.action_edit_profile);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        item.setIcon(R.drawable.ic_edit);
    }


}
