package com.example.product;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import SUBD.products.UserOpenHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button loginButton, regButton;
    UserOpenHelper user;
    EditText Password, Login;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        intent = new Intent(LoginActivity.this, MainActivity.class);
        user = new UserOpenHelper(this);

        loginButton = (Button)findViewById(R.id.login);
        regButton = (Button)findViewById(R.id.reg);

        loginButton.setOnClickListener(this);
        regButton.setOnClickListener(this);

        Password = (EditText)findViewById(R.id.password);
        Login = (EditText)findViewById(R.id.LOGIN);

    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db = user.getWritableDatabase();
        ContentValues content = new ContentValues();

        String login = Login.getText().toString();
        String password = Password.getText().toString();
        content.put(UserOpenHelper.Users.COLUMN_LOGIN, login);
        content.put(UserOpenHelper.Users.COLUMN_PASSWORD, password);

        if (v.getId() == R.id.reg) {
            boolean flag1 = true;

            String[] massive = {UserOpenHelper.Users.COLUMN_LOGIN};
            Cursor cursor = db.query(UserOpenHelper.Users.TABLE_NAME, massive, null, null, null, null, null);
            int index = cursor.getColumnIndex(UserOpenHelper.Users.COLUMN_LOGIN);

            while (cursor.moveToNext()) {
                String LOGIN = cursor.getString(index);
                if (login.equals(LOGIN)) {
                    flag1 = false;
                    break;
                }
            }
            cursor.close();

            if (flag1 && login.length() != 0 && password.length() != 0) {
                db.insert(UserOpenHelper.Users.TABLE_NAME, null, content);
                user.close();
                startActivity(intent);
            }
        }

        else if (v.getId() == R.id.login) {
            boolean flag2 = false;

            String[] massive2 = {UserOpenHelper.Users.COLUMN_LOGIN, UserOpenHelper.Users.COLUMN_PASSWORD};
            Cursor c = db.query(UserOpenHelper.Users.TABLE_NAME, massive2, null, null, null, null, null);
            int loginIndex = c.getColumnIndex(UserOpenHelper.Users.COLUMN_LOGIN);
            int passwordIndex = c.getColumnIndex(UserOpenHelper.Users.COLUMN_PASSWORD);

            while (c.moveToNext()) {
                String LoGiN = c.getString(loginIndex);
                String PaSsWoRd = c.getString(passwordIndex);
                if (login.equals(LoGiN) && password.equals(PaSsWoRd)) {
                    flag2 = true;
                    break;
                }
            }
            c.close();

            if (flag2 && login.length() != 0 && password.length() != 0) {
                user.close();
                startActivity(intent);
            }
        }
    }

}
