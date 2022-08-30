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

import java.text.DecimalFormat;

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
                   Toast.makeText(MainActivity.this,"Chưa nhập chiều cao, cân nặng",Toast.LENGTH_SHORT).show();
                   editTextCC.requestFocus();

               }
               else if (editTextCC.getText().toString().isEmpty())
               {
                   Toast.makeText(MainActivity.this ,"Thiếu dữ liệu chiều cao",Toast.LENGTH_SHORT).show();
                   editTextCC.requestFocus();
               }
               else if (editTextCN.getText().toString().isEmpty())
               {
                   Toast.makeText(MainActivity.this,"Thiếu dữ liệu cân nặng",Toast.LENGTH_SHORT).show();
                   editTextCN.requestFocus();
               }
               else if (radioButtonNam.isChecked()==false && radioButtonNu.isChecked()==false)
               {
                   Toast.makeText(MainActivity.this,"Vui lòng chọn giới tính",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   double CC = Double.parseDouble(editTextCC.getText()+"");
                   double CN = Double.parseDouble(editTextCN.getText()+"");
                   DecimalFormat dcF =new DecimalFormat("0.00");// định dạng lấy đến 2 con số
                   double BMI=CN/Math.pow(CC,2)*10000;
                   if ((CC==0)||(CN==0))
                   {
                       Toast.makeText(MainActivity.this,"Chiều cao, căn nặng phải khác 0",Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       textViewBMI.setText("Chỉ số BMI của bạn:"+dcF.format(BMI));
                       if (BMI <18.5)
                           textViewDG.setText("Bạn quá gầy, cần bổ sung thêm nhiều chất dinh dưỡng");
                       else if(18.5<=BMI && BMI <25)
                           textViewDG.setText("Body của bạn quá chuẩn luôn ^^");
                       else if (25<=BMI && BMI<30)
                           textViewDG.setText("Bạn đang béo phì cấp độ I,cần chế độ ăn hợp lý");
                       else if (30<=BMI && BMI<35)
                           textViewDG.setText("Bạn đang béo phì cấp độ II,cần chế độ ăn hợp lý");
                       else
                           textViewDG.setText("Bạn đang béo phì cấp độ III,Ăn ít it thôi :)))");
                   }
               }
           }
       });







    }
}