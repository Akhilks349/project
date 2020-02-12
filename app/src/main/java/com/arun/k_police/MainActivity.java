package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.bt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1=new Intent(getApplicationContext(),ApplicantLogin.class);
                startActivity(in1);
            }
        });
        b2=(Button)findViewById(R.id.bt2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2=new Intent(getApplicationContext(),PoliceLogin.class);
                startActivity(in2);
            }
        });
        b3=(Button)findViewById(R.id.bt3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in3=new Intent(getApplicationContext(),AdvocateLogin.class);
                startActivity(in3);
            }
        });
        b4=(Button)findViewById(R.id.bt4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in4=new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(in4);
            }
        });

    }
}
