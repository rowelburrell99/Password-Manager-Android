package com.example.mysqldemotwo.DarkTheme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mysqldemotwo.AES256;
import com.example.mysqldemotwo.OriginalTheme.BackgroundWorker;
import com.example.mysqldemotwo.R;

import androidx.appcompat.app.AppCompatActivity;

public class DarkRegister extends AppCompatActivity {

    EditText username, password, conpassword, pin, hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darkregister);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        conpassword = findViewById(R.id.et_conpassword);
        pin = findViewById(R.id.et_pin);
        hint = findViewById(R.id.et_hint);
    }


    public void OnReg(View view) {
        String secretKey = "pleaseencryptme!!!!";
        String originalString = password.getText().toString();
        String encryptedString = AES256.encrypt(originalString, secretKey);

        String str_username = username.getText().toString();
        String str_password = encryptedString;
        String str_conpassword = conpassword.getText().toString();
        String str_pin = pin.getText().toString();
        String str_hint = hint.getText().toString();
        String type = "Register";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_username, str_password, str_conpassword, str_pin, str_hint
        );
    }

    public void OnHome(View view) {
        startActivity(new Intent(this, DarkMain.class));
    }
}
