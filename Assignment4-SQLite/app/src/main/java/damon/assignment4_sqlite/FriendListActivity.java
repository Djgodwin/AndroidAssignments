package damon.assignment4_sqlite;

import android.support.v4.app.Fragment;

/**
 * Created by Damon on 3/23/2017.
 */

public class FriendListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FriendListFragment();
    }
}
