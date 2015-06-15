package se.kth.mrazovic.mobics.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import se.kth.mrazovic.mobics.R;
import se.kth.mrazovic.mobics.fragments.HumanTasksPageFragment;
import se.kth.mrazovic.mobics.fragments.SensingTasksPageFragment;

/**
 * Created by Petar Mrazovic on 11.06.15..
 */
public class TaskListPagerAdapter extends FragmentStatePagerAdapter {
    private final int PAGE_COUNT = 2;
    private final int TAB_TITLES[] = new int[]{R.string.human_tasks, R.string.sensing_tasks};
    private Context mContext;

    public TaskListPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public Fragment getItem(int item) {
        Fragment pageFragment = null;
        switch (item){
            case 0:
                pageFragment = (Fragment) new HumanTasksPageFragment();
                break;
            case 1:
                pageFragment = (Fragment) new SensingTasksPageFragment();
                break;
        }

        return pageFragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return mContext.getResources().getString(TAB_TITLES[position]);
    }
}
