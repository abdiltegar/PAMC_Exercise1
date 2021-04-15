package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatData_Activity extends AppCompatActivity {
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");
        switch (nama){
            case "Naruto":
                tvnama.setText("Uzumaki Naruto");
                tvnomor.setText("081222333444");
                break;
            case "Ereh":
                tvnama.setText("Ereh Iyegah");
                tvnomor.setText("081234567890");
                break;
            case "Goku":
                tvnama.setText("Son Goku");
                tvnomor.setText("081928374650");
                break;
            case "Luffy":
                tvnama.setText("Luffy");
                tvnomor.setText("089123456789");
                break;
            case "Hamtaro":
                tvnama.setText("Tukutuk Hamtaro Berlari");
                tvnomor.setText("089812345678");
                break;
            case "Nobita":
                tvnama.setText("Nobita");
                tvnomor.setText("089871234567");
                break;
            case "Tsubasa":
                tvnama.setText("Captain Tsubasa");
                tvnomor.setText("089876123456");
                break;
            case "Hattori":
                tvnama.setText("Ninja Hattori");
                tvnomor.setText("089876512345");
                break;
            case "Doraemon":
                tvnama.setText("Doraemon");
                tvnomor.setText("089876541234");
                break;
            case "Inuyasha":
                tvnama.setText("Inuyasha");
                tvnomor.setText("089876543123");
                break;
        }
    }
}