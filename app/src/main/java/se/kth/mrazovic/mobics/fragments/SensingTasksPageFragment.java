package se.kth.mrazovic.mobics.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.kth.mrazovic.mobics.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SensingTasksPageFragment extends Fragment {


    public SensingTasksPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sensing_tasks_page, container, false);
    }


}
