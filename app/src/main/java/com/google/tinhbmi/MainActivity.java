package com.google.tinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextCC,editTextCN;
    RadioGroup radioGroupGT;
    RadioButton radioButtonNam,radioButtonNu;
    Button buttonGD;
    TextView textViewBMI,textViewDG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGD = findViewById(R.id.buttonDG);
        radioButtonNam =findViewById(R.id.radioButtonNAM);
        radioButtonNu=findViewById(R.id.radioButtonNu);
        editTextCC=findViewById(R.id.editTextCC);
        editTextCN=findViewById(R.id.editTextCN);
        textViewBMI=findViewById(R.id.textViewBMI);
        textViewDG=findViewById(R.id.textViewDG);

        buttonGD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewBMI.setText("");
                textViewDG.setText("");
                if (editTextCC.getText().toString().isEmpty() && editTextCN.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Thiếu dữ liệu chiều cao",Toast.LENGTH_SHORT).show();
                    editTextCC.requestFocus();

                }


        })
            ;







    });
