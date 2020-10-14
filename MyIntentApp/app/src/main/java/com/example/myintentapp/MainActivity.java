package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvHasil;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPindahActivity = (Button) findViewById(R.id.btn_pindah_activity);
        btnPindahActivity.setOnClickListener(this);

        Button btnPindahActivityDenganData = (Button) findViewById(R.id.btn_pindah_activity_data);
        btnPindahActivityDenganData.setOnClickListener(this);

        Button btnDialPhone = (Button) findViewById(R.id.btn_dial);
        btnDialPhone.setOnClickListener(this);

        Button btnPindahDenganObjek = (Button) findViewById(R.id.btn_pindah_activity_objek);
        btnPindahDenganObjek.setOnClickListener(this);

        Button btnPindahUntukHasil = (Button) findViewById(R.id.btn_pindah_untuk_hasil);
        btnPindahUntukHasil.setOnClickListener(this);

        tvHasil = (TextView)findViewById(R.id.tv_hasil);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_pindah_activity:
                Intent pindahIntent  = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(pindahIntent);
                break;
            case R.id.btn_pindah_activity_data:
                Intent pindahDenganDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                pindahDenganDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Dila");
                pindahDenganDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,5);
                startActivity(pindahDenganDataIntent);
                break;
            case R.id.btn_dial:
                String phoneNumber = "085769666438";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL);
                dialPhoneIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_pindah_activity_objek:
                person mperson = new person();
                mperson.setName("Rahmadila Nurjannah");
                mperson.setAge(19);
                mperson.setEmail("rahmadilan11@gmail.com");
                mperson.setCity("Lampung");
                Intent pindahDgnObjekIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                pindahDgnObjekIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mperson);
                startActivity(pindahDgnObjekIntent);
                break;
            case R.id.btn_pindah_untuk_hasil :
                Intent pindahUntukHasilIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(pindahUntukHasilIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if(resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvHasil.setText("Hasil :"+selectedValue);
            }
        }
    }
}