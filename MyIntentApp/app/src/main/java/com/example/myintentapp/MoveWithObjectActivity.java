package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        TextView tvObject = (TextView) findViewById(R.id.tv_objek_diterima);
        person mperson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Nama : "+mperson.getName()+", Email :"+mperson.getEmail()+", umur :"+mperson.getAge()+"lokasi :"+mperson.getCity();
        tvObject.setText(text);
    }
}