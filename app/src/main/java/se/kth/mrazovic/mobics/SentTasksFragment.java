package se.kth.mrazovic.mobics;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SentTasksFragment extends Fragment {


    public SentTasksFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Context context) {
        SentTasksFragment fragment = new SentTasksFragment();
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
        getActivity().setTitle(getString(R.string.sent_tasks));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sent_tasks, container, false);
    }


}
