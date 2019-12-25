package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdvocateLogin extends AppCompatActivity {
    EditText name,password;
    Button login,reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advocate_login);
        name=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);
        reg=(Button)findViewById(R.id.button4);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2=new Intent(getApplicationContext(),AdvocateReg.class);
                startActivity(in2);
            }
        });
        login=(Button)findViewById(R.id.button1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }
    private void validate(String username,String apassword)
    {
        if((username.equals("Advocate"))&&(apassword.equals("12345")))
        {
            Intent in1=new Intent(getApplicationContext(),AdvocateMenu.class);
            startActivity(in1);
        }
    }
}
