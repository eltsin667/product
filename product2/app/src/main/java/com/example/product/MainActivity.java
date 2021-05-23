package com.example.product;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;
import android.content.Intent;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button scanButton, newProduct;
    Intent intent, addIntent;
    String scanContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newProduct = (Button)findViewById(R.id.addproduct);
        scanButton = (Button)findViewById(R.id.scan);

        scanButton.setOnClickListener(this);
        newProduct.setOnClickListener(this);

        addIntent = new Intent(MainActivity.this, NewproductActivity.class);
        intent = new Intent(MainActivity.this, SecondActivity.class);


    }
    // сканер и вывод нужного значения
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.scan):
                IntentIntegrator integrator = new IntentIntegrator(this);
                integrator.initiateScan();
                break;
            case (R.id.addproduct):
                startActivity(addIntent);
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, i);
        if (result != null) {
            scanContent = result.getContents();
            intent.putExtra("BARCODE", scanContent);
            startActivity(intent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Ничего не найдено!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
