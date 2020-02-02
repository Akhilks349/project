package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdvocateMenu extends AppCompatActivity {
    Button be,b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advocate_menu);

        be=(Button)findViewById(R.id.bex1);
        b1=(Button)findViewById(R.id.ed1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),AddLaw.class);
                startActivity(intent1);

            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("LoginAdv",MODE_PRIVATE);
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("LoginAdv",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();

                Intent ob=new Intent(getApplicationContext(),AdvocateLogin.class);
                startActivity(ob);
            }
        });
    }
}
