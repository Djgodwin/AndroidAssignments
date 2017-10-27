package damon.assignment4_sqlite;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class FriendDetailsActivity extends SingleFragmentActivity {

    private static final String EXTRA_FRIEND_ID = "id";

    public static Intent newIntent(Context packageContext, UUID friendId) {
        Intent intent = new Intent(packageContext, FriendDetailsActivity.class);
        intent.putExtra(EXTRA_FRIEND_ID, friendId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID friendId = (UUID) getIntent().getSerializableExtra(EXTRA_FRIEND_ID);
        return FriendDetailsFragment.newInstance(friendId);
    }
}
