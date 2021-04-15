package com.example.exercise1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Hasil_Activity extends AppCompatActivity {
    TextView tEmail, tPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tEmail = findViewById(R.id.textVEmail);
        tPassword = findViewById(R.id.textVPassword);

        Bundle bundle = getIntent().getExtras();

        String email = bundle.getString("a");
        String password = bundle.getString("b");

        tEmail.setText(email);
        tPassword.setText(password);
    }
}