package com.ateng.zodiak;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    LinearLayout btn_tanggal;
    EditText tanggal,editText;
    Button btn_ramal;
    String var_tanggal,var_nama;
    Calendar c;
    DatePickerDialog dpd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); btn_tanggal = findViewById(R.id.btn_tanggal);
        tanggal = findViewById(R.id.tanggal);
        btn_ramal = findViewById(R.id.btn_ramal);
        editText = findViewById(R.id.editText);

        btn_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        tanggal.setText(mDay + "-" +(mMonth+1) + "-" + mYear);
                    }
                },day,month,year);
                dpd.show();
            }
        });
        btn_ramal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tanggal.getText().toString().length()==0){
                    tanggal.setError("Tangal Tidak Boleh Kosong");
                }else {
                    var_tanggal = tanggal.getText().toString();
                    var_nama = editText.getText().toString();
                    Intent abc = new Intent(MainActivity.this,Ramalan.class);
                    Bundle b = new Bundle();
                    b.putString("parse_tanggal", var_tanggal);
                    b.putString("parse_nama", var_nama);
                    abc.putExtras(b);
                    startActivity(abc);
                }

            }
        });
    }
}
