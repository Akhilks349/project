package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PoliceLogin extends AppCompatActivity {
    EditText name,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_login);
        name=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }
    private void validate(String username,String ppassword)
    {
        if((username.equals("Police"))&&(ppassword.equals("12345")))
        {
            Intent in=new Intent(getApplicationContext(),PoliceMenu.class);
            startActivity(in);
        }
    }
}
