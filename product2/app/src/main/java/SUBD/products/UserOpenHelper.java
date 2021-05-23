package SUBD.products;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class UserOpenHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "users.db";
    private static final int TABLE_VERSION = 1;

    public UserOpenHelper(Context context) {
        super(context, TABLE_NAME, null, TABLE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Users.TABLE_NAME + " (" + Users._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Users.COLUMN_LOGIN + " TEXT, " + Users.COLUMN_PASSWORD + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static final class Users implements BaseColumns {
        public static final String TABLE_NAME = "users";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_LOGIN = "login";
        public final static String COLUMN_PASSWORD =  "password";
    }
}
