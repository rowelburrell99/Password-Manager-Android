package com.example.mysqldemotwo.VibrantTheme;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mysqldemotwo.AES256;
import com.example.mysqldemotwo.OriginalTheme.BackgroundWorker;
import com.example.mysqldemotwo.OriginalTheme.MainActivity;
import com.example.mysqldemotwo.R;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class VibrantGUI extends AppCompatActivity {

    EditText id, username, password, website, loginid;
    public String usersess = VibrantMain.usersess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrantgui);
        id = findViewById(R.id.et_id);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        website = findViewById(R.id.et_website);
        loginid = findViewById(R.id.loginidtext);
        loginid.setEnabled(false);
        loginid.setText(usersess);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void OnAdd(View view) {
        String str_id = id.getText().toString();
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();
        String str_website = website.getText().toString();
        String type = "Add";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_id, str_username, str_password, str_website, usersess);
    }

    public void OnDel(View view) {
        String str_id = id.getText().toString();
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();
        String str_website = website.getText().toString();
        String type = "Delete";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_id, str_username, str_password, str_website, usersess);
    }


    public void OnUpd(View view) {
        String str_id = id.getText().toString();
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();
        String str_website = website.getText().toString();
        String type = "Update";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_id, str_username, str_password, str_website, usersess);
    }

    public void OnManage(View view) {
        String str_website = website.getText().toString();
        String type = "Find";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_website, usersess);
    }

    public String randompass(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!#$%()*+-/<>=?@^_~";
        char[] randompass = (alphabet + alphabet.toUpperCase() + numbers + symbols).toCharArray();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(randompass[new Random().nextInt(randompass.length)]);
        }
        return result.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String secretKey = "pleaseencryptme!!!!";
        switch (item.getItemId()) {
            case R.id.item1:
                String originalString = password.getText().toString();
                String encryptedString = AES256.encrypt(originalString, secretKey);
                password.setText(encryptedString);
                Toast.makeText(this, "Password has been encrypted.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                String decryptedString = AES256.decrypt(password.getText().toString()
                        , secretKey);
                password.setText(decryptedString);
                Toast.makeText(this, "Password has been decrypted.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                password.setText(randompass(18));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void OnOut(View view) {
        startActivity(new Intent(this, VibrantMain.class));
    }
}
