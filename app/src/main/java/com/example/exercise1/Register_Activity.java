package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity {
    EditText etNama, etAlamat, etEmail, etPassword, etRePassword;
    RadioGroup rgJk;
    RadioButton rbLk, rbPr, rbAgamaIslam, rbAgamaKatolik, rbAgamaProtestan, rbAgamaHindu, rbAgamaBudha, rbAgamaKonghucu, rbAgamaPK;
    Button btnBatal, btnDaftar;
    String nama, alamat, email, password, repassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        etNama = findViewById(R.id.etNamaRegister);
        etAlamat = findViewById(R.id.etAlamatRegister);
        etEmail = findViewById(R.id.etEmailRegister);
        etPassword = findViewById(R.id.etPasswordRegister);
        etRePassword = findViewById(R.id.etRePasswordRegister);

        rgJk = findViewById(R.id.radioGroup);
        rbLk = findViewById(R.id.rbJKLk);
        rbPr = findViewById(R.id.rbJKPr);

        rbAgamaIslam = findViewById(R.id.rbAgmIslam);
        rbAgamaBudha = findViewById(R.id.rbAgmBudha);
        rbAgamaHindu = findViewById(R.id.rbAgmHindu);
        rbAgamaKatolik = findViewById(R.id.rbAgmKatolik);
        rbAgamaKonghucu = findViewById(R.id.rbAgmKongHuCu);
        rbAgamaProtestan = findViewById(R.id.rbAgmProtestan);
        rbAgamaPK = findViewById(R.id.rbAgmPK);

        btnBatal = findViewById(R.id.btnBatalRegister);
        btnDaftar = findViewById(R.id.btnSubmitRegister);

        btnDaftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean flagSubmit = true;
                nama = etNama.getText().toString();
                alamat = etAlamat.getText().toString();
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();
                repassword = etRePassword.getText().toString();

                if (nama.isEmpty()){
                    etNama.setError("Nama tidak boleh kosong !");
                    flagSubmit = false;
                }
                if (alamat.isEmpty()){
                    etAlamat.setError("Alamat tidak boleh kosong !");
                    flagSubmit = false;
                }
                if (email.isEmpty()){
                    etEmail.setError("E-mail tidak boleh kosong !");
                    flagSubmit = false;
                }
                if (password.isEmpty()){
                    etPassword.setError("Password tidak boleh kosong !");
                    flagSubmit = false;
                }else if(password.length() < 6){
                    etPassword.setError("Password tidak boleh kurang dari 6 karakter !");
                    flagSubmit = false;
                }else if(password.trim().equals(repassword.trim())){
                    etPassword.setError("Password dan Konfirmasi Password tidak sama !");
                    etRePassword.setError("Password dan Konfirmasi Password tidak sama !");
                    flagSubmit = false;
                }

                if(!(rbLk.isChecked() || rbPr.isChecked()) && !(rbAgamaIslam.isChecked() || rbAgamaBudha.isChecked() || rbAgamaHindu.isChecked() || rbAgamaKatolik.isChecked() || rbAgamaKonghucu.isChecked() || rbAgamaPK.isChecked() || rbAgamaProtestan.isChecked())){ //jika radio button jenis kelamin belum dipilih
                    Toast.makeText(getApplicationContext(), "Data harus diisi", Toast.LENGTH_LONG).show();
                    flagSubmit = false;
                }

                if (flagSubmit){
                    Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();
                    b.putString("a",etEmail.getText().toString().trim());
                    b.putString("b",etPassword.getText().toString().trim());

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtras(b);

                    startActivity(i);
                }
            }
        });

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rbAgamaIslam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbAgamaBudha.setChecked(false);
                    rbAgamaHindu.setChecked(false);
                    rbAgamaKatolik.setChecked(false);
                    rbAgamaKonghucu.setChecked(false);
                    rbAgamaProtestan.setChecked(false);
                    rbAgamaPK.setChecked(false);
                }
            }
        });

        rbAgamaBudha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbAgamaIslam.setChecked(false);
                    rbAgamaHindu.setChecked(false);
                    rbAgamaKatolik.setChecked(false);
                    rbAgamaKonghucu.setChecked(false);
                    rbAgamaProtestan.setChecked(false);
                    rbAgamaPK.setChecked(false);
                }
            }
        });

        rbAgamaHindu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbAgamaIslam.setChecked(false);
                    rbAgamaBudha.setChecked(false);
                    rbAgamaKatolik.setChecked(false);
                    rbAgamaKonghucu.setChecked(false);
                    rbAgamaProtestan.setChecked(false);
                    rbAgamaPK.setChecked(false);
                }
            }
        });

        rbAgamaKatolik.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbAgamaIslam.setChecked(false);
                    rbAgamaBudha.setChecked(false);
                    rbAgamaHindu.setChecked(false);
                    rbAgamaKonghucu.setChecked(false);
                    rbAgamaProtestan.setChecked(false);
                    rbAgamaPK.setChecked(false);
                }
            }
        });

        rbAgamaKonghucu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbAgamaIslam.setChecked(false);
                    rbAgamaBudha.setChecked(false);
                    rbAgamaHindu.setChecked(false);
                    rbAgamaKatolik.setChecked(false);
                    rbAgamaProtestan.setChecked(false);
                    rbAgamaPK.setChecked(false);
                }
            }
        });

        rbAgamaProtestan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbAgamaIslam.setChecked(false);
                    rbAgamaBudha.setChecked(false);
                    rbAgamaHindu.setChecked(false);
                    rbAgamaKatolik.setChecked(false);
                    rbAgamaKonghucu.setChecked(false);
                    rbAgamaPK.setChecked(false);
                }
            }
        });

        rbAgamaPK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbAgamaIslam.setChecked(false);
                    rbAgamaBudha.setChecked(false);
                    rbAgamaHindu.setChecked(false);
                    rbAgamaKatolik.setChecked(false);
                    rbAgamaKonghucu.setChecked(false);
                    rbAgamaProtestan.setChecked(false);
                }
            }
        });
    }
}