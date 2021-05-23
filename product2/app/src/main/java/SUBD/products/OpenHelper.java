package SUBD.products;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import SUBD.products.ProductCategories.Products;

public class OpenHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "allProducts.db";
    private static final int TABLE_VERSION = 1;

    public OpenHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, TABLE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PRODUCT_TABLE = "CREATE TABLE " + Products.TABLE_NAME + " (" + Products._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Products.COLUMN_BARCODE + " TEXT, " + Products.COLUMN_NAME + " TEXT, " + Products.COLUMN_COUNTRY + " TEXT, "
                + Products.COLUMN_WEIGHT + " TEXT, " + Products.COLUMN_CONTENT + " TEXT, "
                + Products.COLUMN_KKAL + " TEXT);";
        db.execSQL(SQL_CREATE_PRODUCT_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
