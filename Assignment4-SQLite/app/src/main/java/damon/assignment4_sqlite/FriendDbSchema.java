package damon.assignment4_sqlite;

/**
 * Created by Damon on 3/22/2017.
 */

public class FriendDbSchema {

    public static final class FriendTable {
        public static final String NAME = "friends";

        public static final class Cols {
            public static final String ID = "id";
            public static final String FIRSTNAME = "firstname";
            public static final String LASTNAME = "lastname";
            public static final String EMAILADDRESS = "emailaddress";
        }
    }
}
