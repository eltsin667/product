package com.example.product;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import SUBD.products.OpenHelper;
import SUBD.products.ProductCategories.Products;

public class SecondActivity extends AppCompatActivity {
    OpenHelper MyHelper;
    TextView text;
    String BARCODE, MainL = "dd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        MyHelper = new OpenHelper(this);
        text = (TextView)findViewById(R.id.textView);
        BARCODE = getIntent().getStringExtra("BARCODE");
        DatabaseProducts();
    }

    //База данных продуктов
    private void DatabaseProducts() {
        SQLiteDatabase DB = MyHelper.getReadableDatabase();
        Cursor cursor = DB.query(Products.TABLE_NAME, null, Products.COLUMN_BARCODE + " = '" + BARCODE + "'", null, null, null, null);
        //barcode = '12343598456'
        String product = null;
        Log.d(MainL, BARCODE);
        if(cursor != null && cursor.moveToFirst()){
            String Name = cursor.getString(Products.COLUMN_NAME_NUM);
            String Barcode = cursor.getString(Products.COLUMN_BARCODE_NUM);
            String Kkal = cursor.getString(Products.COLUMN_KKAL_NUM);
            String ExpirationDate = cursor.getString(Products.COLUMN_CONTENT_NUM);
            String Weight = cursor.getString(Products.COLUMN_WEIGHT_NUM);
            String Country = cursor.getString(Products.COLUMN_COUNTRY_NUM);
            Log.d(MainL, Barcode);
            product = "Штрих-код: " + Barcode + "\n" + "Название: " + Name + "\n" + "Страна: " + Country + "\n" + "Масса нетто(г): " + Weight + "\n" + "Пищевая ценность(ккал/100г): " + Kkal + "\n" + "Состав: " + ExpirationDate + "\n";
            text.setText(product);
            cursor.close();
        }
    }
}