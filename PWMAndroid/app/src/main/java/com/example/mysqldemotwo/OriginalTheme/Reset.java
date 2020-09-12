package com.example.mysqldemotwo.OriginalTheme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mysqldemotwo.AES256;
import com.example.mysqldemotwo.R;

import androidx.appcompat.app.AppCompatActivity;

public class Reset extends AppCompatActivity {

    EditText username, password, pin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        username = findViewById(R.id.res_username);
        password = findViewById(R.id.res_password);
        pin = findViewById(R.id.res_pin);

    }


    public void OnReset(View view) {
        String secretKey = "pleaseencryptme!!!!";
        String originalString = password.getText().toString();
        String encryptedString = AES256.encrypt(originalString, secretKey);

        String str_username = username.getText().toString();
        String str_password = encryptedString;
        String str_pin = pin.getText().toString();
        String type = "Reset";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_username, str_password, str_pin);

    }

    public void OnHomeres(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }


}
