package se.kth.mrazovic.mobics.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import se.kth.mrazovic.mobics.R;
import se.kth.mrazovic.mobics.adapters.HumanTaskAdapter;
import se.kth.mrazovic.mobics.model.HumanTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HumanTasksPageFragment extends Fragment {


    public HumanTasksPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_human_tasks_page, container, false);
        // Get the reference to recycler view
        RecyclerView taskList = (RecyclerView) layout.findViewById(R.id.task_list);
        // Layout manager positions item views inside the row and determines when it is time to recycle the views
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        taskList.setLayoutManager(linearLayoutManager);

        // Set adapter for recycle view
        HumanTaskAdapter humanTaskAdapter = new HumanTaskAdapter(getActivity(), createExampleTasks());
        taskList.setAdapter(humanTaskAdapter);
        // Set animation
        taskList.setItemAnimator(new DefaultItemAnimator());
        return layout;
    }

    // Creates dummy tasks (example data)
    // Will be removed and repplaced with real data
    private List<HumanTask> createExampleTasks() {
        List<HumanTask> tasks = new ArrayList<HumanTask>();
        tasks.add(new HumanTask(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 1, "@Wimp", 230, 270));
        tasks.add(new HumanTask(2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 2, "@Stannis", 120, 500));
        tasks.add(new HumanTask(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 3, "@Robert", 12, 50));
        tasks.add(new HumanTask(4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 4, "@Arya", 45, 50));
        tasks.add(new HumanTask(5, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 5, "@Cersei", 32, 60));
        tasks.add(new HumanTask(6, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 6, "@Sansa", 120, 600));
        tasks.add(new HumanTask(7, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 7, "@Theon", 875, 1255));
        tasks.add(new HumanTask(8, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 8, "@Jaime", 15, 78));
        tasks.add(new HumanTask(9, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 9, "@JonSnow", 1365, 2000));
        tasks.add(new HumanTask(10, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 10, "@SirJorah", 15, 17));
        tasks.add(new HumanTask(11, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac malesuada urna, non molestie sem. Vivamus risus mauris, pellentesque vitae urna vel, consectetur aliquam metus. Proin vitae tempor diam. Etiam. ", "13/07/2014 18:45", 11, "@Daenerys", 365, 456));
        return tasks;
    }


}
