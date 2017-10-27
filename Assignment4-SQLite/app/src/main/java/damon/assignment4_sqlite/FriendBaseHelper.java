package damon.assignment4_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Damon on 3/22/2017.
 */

public class FriendBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "friendBase.db";

    public FriendBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + FriendDbSchema.FriendTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                FriendDbSchema.FriendTable.Cols.ID + " INTEGER, " +
                FriendDbSchema.FriendTable.Cols.FIRSTNAME + " TEXT, " +
                FriendDbSchema.FriendTable.Cols.LASTNAME + " TEXT, " +
                FriendDbSchema.FriendTable.Cols.EMAILADDRESS + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
