package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminLogin extends AppCompatActivity {
    EditText name,password;
    TextView info;
    Button login;
    private int counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        name=(EditText)findViewById(R.id.t1);
        password=(EditText)findViewById(R.id.t2);
        info=(TextView)findViewById(R.id.tvinfo);
        login=(Button)findViewById(R.id.b1);
        info.setText("No. of attempts possible: 5");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }
    private void validate(String adminame,String adminpassword){
        if((adminame.equals("Admin"))&&(adminpassword.equals("12345"))){
            Intent in=new Intent(getApplicationContext(),AdminPage.class);
            startActivity(in);
        }else{
            counter--;
            info.setText("No of attempts remaining: "+String.valueOf(counter));
            if(counter == 0)
            {
                login.setEnabled(false);
            }
        }
    }
}
