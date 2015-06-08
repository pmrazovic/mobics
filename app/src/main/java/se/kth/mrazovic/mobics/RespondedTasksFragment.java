package se.kth.mrazovic.mobics;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RespondedTasksFragment extends Fragment {


    public RespondedTasksFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Context context) {
        RespondedTasksFragment fragment = new RespondedTasksFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(getString(R.string.responded_tasks));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_responded_tasks, container, false);
    }


}
