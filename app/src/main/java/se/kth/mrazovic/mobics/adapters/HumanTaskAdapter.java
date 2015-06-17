package se.kth.mrazovic.mobics.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import se.kth.mrazovic.mobics.R;
import se.kth.mrazovic.mobics.model.HumanTask;

/**
 * Created by Petar Mrazovic on 15.06.15..
 */
public class HumanTaskAdapter extends RecyclerView.Adapter<HumanTaskAdapter.HumanTaskViewHolder> {
    private Context mContext;
    private List<HumanTask> mHumanTaskList;

    public HumanTaskAdapter(Context context, List<HumanTask> humanTaskList) {
        mContext = context;
        mHumanTaskList = humanTaskList;
    }

    @Override
    public int getItemCount() {
        return mHumanTaskList.size();
    }

    @Override
    public void onBindViewHolder(HumanTaskViewHolder humanTaskViewHolder, int i) {
        // Place task contents in views
        HumanTask task = mHumanTaskList.get(i);
        humanTaskViewHolder.userNickTextView.setText(task.getUserNick());
        humanTaskViewHolder.questionTextView.setText(task.getQuestion());
        // humanTaskViewHolder.categoryTextView.setText(task.getCategory());
        humanTaskViewHolder.createdAtTextView.setText(task.getCreatedAt());
        humanTaskViewHolder.numResponsesTextView.setText(Integer.toString(task.getNumResponses()) +
                " " + mContext.getResources().getString(R.string.responses));
        humanTaskViewHolder.numViewsTextView.setText(Integer.toString(task.getNumViews()) +
                " " + mContext.getResources().getString(R.string.views));
    }

    @Override
    public HumanTaskViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_human_task, viewGroup, false);

        return new HumanTaskViewHolder(itemView);
    }

    // View adapter class
    public static class HumanTaskViewHolder extends RecyclerView.ViewHolder {
        protected TextView userNickTextView;
        protected TextView questionTextView;
        protected TextView createdAtTextView;
        protected TextView numResponsesTextView;
        protected TextView numViewsTextView;
        protected TextView categoryTextView;
        protected ImageView userAvatar;

        public HumanTaskViewHolder(View view) {
            super(view);
            userNickTextView = (TextView) view.findViewById(R.id.user_nick);
            questionTextView = (TextView) view.findViewById(R.id.question);
            createdAtTextView = (TextView) view.findViewById(R.id.created_at);
            numResponsesTextView = (TextView) view.findViewById(R.id.num_responses);
            numViewsTextView = (TextView) view.findViewById(R.id.num_views);
            categoryTextView = (TextView) view.findViewById(R.id.category);
            userAvatar = (ImageView) view.findViewById(R.id.user_avatar);
        }
    }
}
