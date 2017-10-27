package damon.assignment4_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Damon on 3/22/2017.
 */

public class FriendPersistence {

    private static FriendPersistence sfriendPersistence;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static FriendPersistence get(Context context) {
        if(sfriendPersistence == null) {
            sfriendPersistence = new FriendPersistence(context);
        }
        return sfriendPersistence;
    }

    private FriendPersistence(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new FriendBaseHelper(context).getWritableDatabase();
    }

    public void addFriend(Friend friend) {
        ContentValues values = getContentValues(friend);
        mDatabase.beginTransaction();
        mDatabase.insert(FriendDbSchema.FriendTable.NAME, null, values);
        mDatabase.setTransactionSuccessful();
        mDatabase.endTransaction();
    }

    public Friend getFriend(UUID id) {
        FriendCursorWrapper cursor = queryFriends(
                FriendDbSchema.FriendTable.Cols.ID + " = ?",
                new String[] { id.toString() }
        );

        try {
            if(cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getFriend();
        } finally {
            cursor.close();
        }
    }

    public List<Friend> getFriends() {
        List<Friend> friends = new ArrayList<>();

        FriendCursorWrapper cursor = queryFriends(null, null);

        try {
            cursor.moveToFirst();
            while(cursor.moveToNext()) {
                friends.add(cursor.getFriend());
            }
        } finally {
            cursor.close();
        }
        return friends;
    }

    public void updateFriend(Friend friend) {
        String idString = friend.getId().toString();
        ContentValues values = getContentValues(friend);

        mDatabase.update(FriendDbSchema.FriendTable.NAME, values,
                FriendDbSchema.FriendTable.Cols.ID + " = ?",
                new String[] { idString });
    }

    public void deleteFriend(Friend friend) {
        String idString = friend.getId().toString();

        mDatabase.delete(FriendDbSchema.FriendTable.NAME,
                FriendDbSchema.FriendTable.Cols.ID + " = ?",
                new String[] { idString });
    }

    private static ContentValues getContentValues(Friend friend) {
        ContentValues values = new ContentValues();
        values.put(FriendDbSchema.FriendTable.Cols.ID, friend.getId().toString());
        values.put(FriendDbSchema.FriendTable.Cols.FIRSTNAME, friend.getFirstName());
        values.put(FriendDbSchema.FriendTable.Cols.LASTNAME, friend.getLastName());
        values.put(FriendDbSchema.FriendTable.Cols.EMAILADDRESS, friend.getEmailAddress());

        return values;
    }

    private FriendCursorWrapper queryFriends(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                FriendDbSchema.FriendTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new FriendCursorWrapper(cursor);
    }
}
