package com.example.mysqldemotwo.DarkTheme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.mysqldemotwo.R;

import androidx.appcompat.app.AppCompatActivity;

public class DarkHint extends AppCompatActivity {

    EditText username, pin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darkhint);
        username = findViewById(R.id.husername);
        pin = findViewById(R.id.hpin);
    }



    public void onHint(View view) {
        String str_username = username.getText().toString();
        String str_pin = pin.getText().toString();
        String type = "Hint";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_username, str_pin);

    }

    public void OnHome(View view) {
        startActivity(new Intent(this, DarkMain.class));
    }

}
