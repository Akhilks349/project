package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PoliceReg extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button  b1,b2;
    String nam,conct,eml,unam,pass;
    PoliceRegModel policeRegModel;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_reg);
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        e3=(EditText)findViewById(R.id.ed3);
        e4=(EditText)findViewById(R.id.ed4);
        e5=(EditText)findViewById(R.id.ed5);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);
        policeRegModel=new PoliceRegModel();

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Police");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nam=e1.getText().toString().trim();
                conct=e2.getText().toString().trim();
                eml=e3.getText().toString().trim();
                unam=e4.getText().toString().trim();
                pass=e5.getText().toString().trim();

                if(nam.isEmpty()){
                    e1.setError("Name is Required");
                    e1.requestFocus();

                }else if (conct.isEmpty()){
                    e2.setError("Contact is Required");
                    e2.requestFocus();
                }else if (eml.isEmpty()){
                    e2.setError("Email is Required");
                    e2.requestFocus();
                }else if (unam.isEmpty()){
                    e2.setError("Username is Required");
                    e2.requestFocus();
                }else if (pass.isEmpty()){
                    e2.setError("Password is Required");
                    e2.requestFocus();
                }else {
                    policeRegModel.setName(nam);
                    policeRegModel.setContact(conct);
                    policeRegModel.setEmail(eml);
                    policeRegModel.setUserName(unam);
                    policeRegModel.setPassword(pass);

                    String namValue=policeRegModel.getName();
                    String conctValue=policeRegModel.getContact();
                    String emlValue=policeRegModel.getEmail();
                    String unamValue=policeRegModel.getUserName();
                    String passValue=policeRegModel.getPassword();

                    databaseReference.push().setValue(policeRegModel);

                    Toast.makeText(getApplicationContext(),namValue+"\n"+conctValue+"\n"+emlValue+"\n"+unamValue+"\n"+passValue,Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
