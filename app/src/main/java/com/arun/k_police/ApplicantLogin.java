package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ApplicantLogin extends AppCompatActivity {
    EditText name,password;
    Button login,reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_login);
        name=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button1);
        reg=(Button)findViewById(R.id.button4);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2=new Intent(getApplicationContext(),ApplicantReg.class);
                startActivity(in2);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),password.getText().toString());

            }
        });
    }
    private void validate(String username,String userpassword)
    {
        if((username.equals("Applicant"))&&(userpassword.equals("12345")))
        {
            Intent in1=new Intent(getApplicationContext(),ApplicantMenu.class);
            startActivity(in1);
        }

    }

}
