package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLebar, edtTinggi, edtPanjang;
    private Button btnHitung;
    private TextView tvHasil;

    private  static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(STATE_HASIL, tvHasil.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtLebar = (EditText) findViewById(R.id.edt_lebar);
        edtPanjang = (EditText) findViewById(R.id.edt_panjang);
        edtTinggi = (EditText) findViewById(R.id.edt_tinggi);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        tvHasil = (TextView) findViewById(R.id.tv_hasil);
        btnHitung.setOnClickListener(this);
        if (savedInstanceState !=null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvHasil.setText(hasil);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung) {
            String panjang = edtPanjang.getText().toString().trim();
            String lebar = edtLebar.getText().toString().trim();
            String tinggi = edtTinggi.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(panjang)) {
                isEmptyFields = true;
                edtPanjang.setError("Tidak boleh kosong");
            }
            if (TextUtils.isEmpty(lebar)) {
                isEmptyFields = true;
                edtLebar.setError("Tidak boleh kosong");
            }
            if (TextUtils.isEmpty(tinggi)) {
                isEmptyFields = true;
                edtTinggi.setError("Tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);
                double t = Double.parseDouble(tinggi);
                double volume = p * l * t;
                tvHasil.setText(String.valueOf(volume));
            }
        }
    }

}