package damon.assignment4_sqlite;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.UUID;

/**
 * Created by Damon on 3/22/2017.
 */

public class FriendCursorWrapper extends CursorWrapper {

    public FriendCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Friend getFriend() {
        String idString = getString(getColumnIndex(FriendDbSchema.FriendTable.Cols.ID));
        String firstName = getString(getColumnIndex(FriendDbSchema.FriendTable.Cols.FIRSTNAME));
        String lastName = getString(getColumnIndex(FriendDbSchema.FriendTable.Cols.LASTNAME));
        String emailAddress = getString(getColumnIndex(FriendDbSchema.FriendTable.Cols.EMAILADDRESS));

        Friend friend = new Friend(UUID.fromString(idString));
        friend.setFirstName(firstName);
        friend.setLastName(lastName);
        friend.setEmailAddress(emailAddress);

        return friend;
    }
}
