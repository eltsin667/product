package SUBD.products;

import android.provider.BaseColumns;

public final class ProductCategories {
    private ProductCategories(){};

    public static final class Products implements BaseColumns {
        public static final String TABLE_NAME = "product";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_BARCODE =  "Barcode";
        public final static String COLUMN_WEIGHT = "Weight";
        public final static String COLUMN_COUNTRY = "Country";
        public final static String COLUMN_KKAL = "kkal";
        public final static String COLUMN_NAME = "Name";
        public final static String COLUMN_CONTENT = "content";

        public final static int _ID_NUM = 0;
        public final static int COLUMN_BARCODE_NUM =  1;
        public final static int COLUMN_WEIGHT_NUM = 4;
        public final static int COLUMN_COUNTRY_NUM = 3;
        public final static int COLUMN_KKAL_NUM = 6;
        public final static int COLUMN_NAME_NUM = 2;
        public final static int COLUMN_CONTENT_NUM = 5;
    }


}
