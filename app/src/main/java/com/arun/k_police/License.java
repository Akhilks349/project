package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class License extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1,b2;
    String nam,purp,emai,descr;
    LisenseModel lisenseModel;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        e3=(EditText)findViewById(R.id.ed3);
        e4=(EditText)findViewById(R.id.ed4);
        b1=(Button)findViewById(R.id.ed1);
        b2=(Button)findViewById(R.id.ed2);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("License");

        lisenseModel=new LisenseModel();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nam=e1.getText().toString().trim();
                purp=e2.getText().toString().trim();
                emai=e3.getText().toString().trim();
                descr=e4.getText().toString().trim();

                if(nam.isEmpty()){
                    e1.setError("Name is Required");
                    e1.requestFocus();

                }else if (purp.isEmpty()){
                    e2.setError("Purpose is Required");
                    e2.requestFocus();
                }else if (emai.isEmpty()){
                    e2.setError("Email is Required");
                    e2.requestFocus();
                }else if (descr.isEmpty()){
                    e2.setError("Description is Required");
                    e2.requestFocus();
                }
                else
                {

                    lisenseModel.setName(nam);
                    lisenseModel.setPurpose(purp);
                    lisenseModel.setEmail(emai);
                    lisenseModel.setDescription(descr);

                    String namValue=lisenseModel.getName();
                    String purValue=lisenseModel.getPurpose();
                    String emaiValue=lisenseModel.getEmail();
                    String descValue=lisenseModel.getDescription();

                    databaseReference.push().setValue(lisenseModel);

                    Toast.makeText(getApplicationContext(),namValue+"\n"+purValue+"\n"+emaiValue+"\n"+descValue,Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
