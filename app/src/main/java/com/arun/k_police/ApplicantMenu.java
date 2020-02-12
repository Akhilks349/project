package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ApplicantMenu extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,be6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_menu);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);
        b3=(Button)findViewById(R.id.bt3);
        b4=(Button)findViewById(R.id.bt4);
        b5=(Button)findViewById(R.id.bt5);
        be6=(Button)findViewById(R.id.bt6);

        SharedPreferences sharedPreferences=getSharedPreferences("LoginAppl",MODE_PRIVATE);
        be6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor=getSharedPreferences("LoginAppl",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();

                Intent ob=new Intent(getApplicationContext(),ApplicantLogin.class);
                startActivity(ob);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1=new Intent(getApplicationContext(),ApplicantComplaintReg.class);
                startActivity(in1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2=new Intent(getApplicationContext(),License.class);
                startActivity(in2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in3=new Intent(getApplicationContext(),AdvocateList.class);
                startActivity(in3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in4=new Intent(getApplicationContext(),Bail.class);
                startActivity(in4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in5=new Intent(getApplicationContext(),CrminalList.class);
                startActivity(in5);
            }
        });
    }
}
