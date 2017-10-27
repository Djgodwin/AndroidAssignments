package damon.assignment4_sqlite;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Damon on 3/24/2017.
 */

public class FriendAddActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, FriendAddActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new FriendAddFragment();
    }
}
