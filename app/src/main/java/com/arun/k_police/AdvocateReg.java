package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdvocateReg extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    Button b1,b2;
    String nam,court,desg,conct,uname,passw;
    AdvocateRegModel advocateRegModel;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advocate_reg);

        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed4);
        e3=(EditText)findViewById(R.id.ed4);
        e4=(EditText)findViewById(R.id.ed5);
        e5=(EditText)findViewById(R.id.ed5);
        e6=(EditText)findViewById(R.id.ed5);
        b1=(Button)findViewById(R.id.ed1);
        b2=(Button)findViewById(R.id.ed2);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Advocate");

        advocateRegModel=new AdvocateRegModel();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nam=e1.getText().toString().trim();
                court=e2.getText().toString().trim();
                desg=e3.getText().toString().trim();
                conct=e4.getText().toString().trim();
                uname=e5.getText().toString().trim();
                passw=e6.getText().toString().trim();

                if(nam.isEmpty()){
                    e1.setError("Name is Required");
                    e1.requestFocus();

                }else if (court.isEmpty()){
                    e2.setError("Court is Required");
                    e2.requestFocus();
                }else if (desg.isEmpty()){
                    e2.setError(" is Required");
                    e2.setError("Desegnation is Required");
                    e2.requestFocus();
                }else if (conct.isEmpty()){
                    e2.setError("Concat no is Required");
                    e2.requestFocus();
                }else if (uname.isEmpty()){
                    e2.setError("User Name is Required");
                    e2.requestFocus();
                }else if (passw.isEmpty()){
                    e2.setError("Password is Required");
                    e2.requestFocus();
                }else{

                    advocateRegModel.setName(nam);
                    advocateRegModel.setCourt(court);
                    advocateRegModel.setDesignation(desg);
                    advocateRegModel.setConcat(conct);
                    advocateRegModel.setUserName(uname);
                    advocateRegModel.setPassword(passw);

                    String namValue=advocateRegModel.getName();
                    String cortValue=advocateRegModel.getCourt();
                    String degValue=advocateRegModel.getDesignation();
                    String conctValue=advocateRegModel.getConcat();
                    String unameValue=advocateRegModel.getUserName();
                    String passValue=advocateRegModel.getPassword();

                    databaseReference.push().setValue(advocateRegModel);

                    Toast.makeText(getApplicationContext(),namValue+"\n"+cortValue+"\n"+degValue+"\n"+conctValue+"\n"+unameValue+"\n"+passValue+"\n",Toast.LENGTH_LONG).show();


                }

            }
        });
    }
}
