package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etEmailLogin, etPasswordLogin;
    TextView tvRegister;
    String email, password, realEmail = "admin@mail.com", realPassword = "123456";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        etEmailLogin = findViewById(R.id.etEmailLogin);
        etPasswordLogin = findViewById(R.id.etPasswordLogin);
        tvRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                email = etEmailLogin.getText().toString();
                password = etPasswordLogin.getText().toString();
                boolean flagLogin = true;

                if(email.isEmpty()){//jika email saja yang salah
                    etEmailLogin.setError("E-mail tidak boleh kosong !");
                    flagLogin = false;
                }
                if(password.isEmpty()) {//jika password saja yang salah
                    etPasswordLogin.setError("Password tidak boleh kosong !");
                    flagLogin = false;
                }else if(password.length() < 6){
                    etPasswordLogin.setError("Password tidak boleh kurang dari 6 karakter !");
                    flagLogin = false;
                }

                if(!email.equals(realEmail) && !password.equals(realPassword)){//jika email dan password salah
                    Toast.makeText(getApplicationContext(), "Email atau Password salah", Toast.LENGTH_LONG).show();
                }else if(flagLogin){
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();
                    b.putString("a",email.trim());
                    b.putString("b",password.trim());

                    Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                    i.putExtras(b);

                    startActivity(i);
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Register_Activity.class);
                startActivity(i);
            }
        });
    }
}