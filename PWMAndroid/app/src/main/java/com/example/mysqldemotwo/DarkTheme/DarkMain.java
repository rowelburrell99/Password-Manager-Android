package com.example.mysqldemotwo.DarkTheme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mysqldemotwo.AES256;
import com.example.mysqldemotwo.OriginalTheme.Hint;
import com.example.mysqldemotwo.OriginalTheme.MainActivity;
import com.example.mysqldemotwo.R;
import com.example.mysqldemotwo.VibrantTheme.VibrantMain;

import androidx.appcompat.app.AppCompatActivity;

public class DarkMain extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText UsernameEt, PasswordEt, PinEt;

    public static String usersess;
    int totalattempts = 0;
    int timeout = 60;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darkmain);
        UsernameEt = findViewById(R.id.etUserName);
        PasswordEt = findViewById(R.id.etPassword);
        PinEt = findViewById(R.id.etPin);

        Spinner spinner = findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Themes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void OnLogin(View view) {

        String secretKey = "pleaseencryptme!!!!";
        String originalString = PasswordEt.getText().toString();
        String encryptedString = AES256.encrypt(originalString, secretKey);

        String username = UsernameEt.getText().toString();
        String password = encryptedString;
        String pin = PinEt.getText().toString();
        usersess = UsernameEt.getText().toString();
        String type = "Login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password, pin);

    }


    public void OpenReg(View view) {
        startActivity(new Intent(this, DarkRegister.class));
    }

    public void OpenReset(View view) {
        startActivity(new Intent(this, DarkReset.class));
    }

    public void OpenHint(View view) {
        startActivity(new Intent(this, DarkHint.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String theme = parent.getItemAtPosition(position).toString();

        if (theme.equals("Vibrant Theme")) {
            startActivity(new Intent(this, VibrantMain.class));
            Toast.makeText(parent.getContext(), theme, Toast.LENGTH_SHORT).show();
        }
        else if (theme.equals("Dark Theme")) {
            Toast.makeText(parent.getContext(), theme, Toast.LENGTH_SHORT).show();
        }
        else if (theme.equals("Original Theme")) {
            startActivity(new Intent(this, MainActivity.class));
            Toast.makeText(parent.getContext(), theme, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
