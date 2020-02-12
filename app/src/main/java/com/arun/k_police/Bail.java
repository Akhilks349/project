package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Bail extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button b1,b2;
    String nam,addr,mob,caseno,warrdno;
    BailModel bailModel;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bail);
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        e3=(EditText)findViewById(R.id.ed3);
        e4=(EditText)findViewById(R.id.ed4);
        e5=(EditText)findViewById(R.id.ed5);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Bail");

        bailModel=new BailModel();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nam=e1.getText().toString().trim();
                addr=e2.getText().toString().trim();
                mob=e3.getText().toString().trim();
                caseno=e4.getText().toString().trim();
                warrdno=e5.getText().toString().trim();

                if(nam.isEmpty()){
                    e1.setError("Name is Required");
                    e1.requestFocus();

                }else if (addr.isEmpty()){
                    e2.setError("Adress is Required");
                    e2.requestFocus();
                }else if (mob.isEmpty()){
                    e3.setError("Mobile no. is Required");
                    e3.requestFocus();
                }else if (caseno.isEmpty()){
                    e4.setError("Case no. is Required");
                    e4.requestFocus();
                }else if (warrdno.isEmpty()){
                    e5.setError("Warrent no. is Required");
                    e5.requestFocus();
                }
                else
                {
                    bailModel.setName(nam);
                    bailModel.setAddress(addr);
                    bailModel.setMobno(mob);
                    bailModel.setCaseno(caseno);
                    bailModel.setWarrentno(warrdno);

                    String namValue=bailModel.getName();
                    String addrValue=bailModel.getAddress();
                    String mobValue=bailModel.getMobno();
                    String caseValue=bailModel.getCaseno();
                    String warnValue=bailModel.getWarrentno();

                    databaseReference.push().setValue(bailModel);

                    Toast.makeText(getApplicationContext(),namValue+"\n"+addrValue+"\n"+mobValue+"\n"+caseValue+"\n"+warnValue,Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
