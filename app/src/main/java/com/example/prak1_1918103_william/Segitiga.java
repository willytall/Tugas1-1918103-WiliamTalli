package com.example.prak1_1918103_william;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Segitiga extends AppCompatActivity {
    EditText xAlas, xTinggi;
    Button button;
    TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        xAlas = findViewById(R.id.xAlas);
        xTinggi = findViewById(R.id.xTinggi);
        Hasil = findViewById(R.id.Hasil);
        button = findViewById(R.id.btn3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Alas = xAlas.getText().toString().trim();
                String Tinggi = xTinggi.getText().toString().trim();
                boolean isEmpty = false;
                boolean isInvalid = false;
                if(TextUtils.isEmpty(Alas)){
                    isEmpty=true;
                    xAlas.setError("SALAH");
                }
                if(TextUtils.isEmpty(Tinggi)){
                    isEmpty=true;
                    xTinggi.setError("SALAH");
                }
                Double a = toDouble(Alas);
                Double t = toDouble(Tinggi);
                if (a==null){
                    isInvalid=true;
                    xAlas.setError("isi ");
                }
                if(t==null){
                    isInvalid=true;
                    xTinggi.setError("angka");
                }

                if(!isEmpty && !isInvalid){
                    double luas = 0.5 * a * t;
                    Hasil.setText(String.valueOf(luas));
                }
            }
        });
    }
    private Double toDouble(String value){
        try {
            return Double.valueOf(value);
        }catch (NumberFormatException e){
            return null;
        }

    }
}

