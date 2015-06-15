package se.kth.mrazovic.mobics.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.kth.mrazovic.mobics.R;


public class FavoriteTasksFragment extends Fragment {
    public static final String TAG = "se.kth.mrazovic.mobics.FAVORITE_TASKS_FRAGMENT";


    public FavoriteTasksFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Context context) {
        FavoriteTasksFragment fragment = new FavoriteTasksFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(getString(R.string.favorite_tasks));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tasks, container, false);
    }


}
