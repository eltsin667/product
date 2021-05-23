package com.example.product;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;

import SUBD.products.OpenHelper;
import SUBD.products.ProductCategories.Products;

public class NewproductActivity extends AppCompatActivity implements View.OnClickListener {
    Button Acception;
    Intent mainAct;
    EditText Barcode, Name, Country, Weight, ExpirationDate, Kkal;
    OpenHelper Helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newproduct);

        mainAct = new Intent(NewproductActivity.this, MainActivity.class);
        Barcode = (EditText)findViewById(R.id.barcode);
        Name = (EditText)findViewById(R.id.name);
        Country = (EditText)findViewById(R.id.country);
        Weight = (EditText)findViewById(R.id.weight);
        ExpirationDate = (EditText)findViewById(R.id.date);
        Kkal = (EditText)findViewById(R.id.kkal);


        Acception = (Button)findViewById(R.id.accept);
        Acception.setOnClickListener(this);
        Helper = new OpenHelper(this);
        db = Helper.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {
        ContentValues content = new ContentValues();


        String barcode = Barcode.getText().toString();
        String name = Name.getText().toString();
        String country = Country.getText().toString();
        String weight = Weight.getText().toString();
        String date = ExpirationDate.getText().toString();
        String kkal = Kkal.getText().toString();

        if (v.getId() == R.id.accept) {

            content.put(Products.COLUMN_BARCODE, barcode);
            content.put(Products.COLUMN_NAME, name);
            content.put(Products.COLUMN_COUNTRY, country);
            content.put(Products.COLUMN_WEIGHT, weight);
            content.put(Products.COLUMN_CONTENT, date);
            content.put(Products.COLUMN_KKAL, kkal);
            db.insert(Products.TABLE_NAME, null, content);
            startActivity(mainAct);
        }
    }
}