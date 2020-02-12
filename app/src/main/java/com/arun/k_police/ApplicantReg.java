package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ApplicantReg extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    Button b1,b2;
    ApplicantRegModel applicantRegModel;
    String nam,adrs,dob,mob,email,paswd;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_reg);
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        e3=(EditText)findViewById(R.id.ed3);
        e4=(EditText)findViewById(R.id.ed4);
        e5=(EditText)findViewById(R.id.ed5);
        e6=(EditText)findViewById(R.id.ed6);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Applicant");
        applicantRegModel=new ApplicantRegModel();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                nam=e1.getText().toString().trim();
                adrs=e2.getText().toString().trim();
                dob=e3.getText().toString().trim();
                mob=e4.getText().toString().trim();
                email=e5.getText().toString().trim();
                paswd=e6.getText().toString().trim();

                if(nam.isEmpty()){
                    e1.setError("Name is Required");
                    e1.requestFocus();

                }else if (adrs.isEmpty()){
                    e2.setError("Adress is Required");
                    e2.requestFocus();
                }else if (dob.isEmpty()) {
                    e3.setError("DOB is Required");
                    e3.requestFocus();
                }else if (mob.isEmpty()){
                    e4.setError("Mob no. is Required");
                    e4.requestFocus();
                }else if (email.isEmpty()){
                    e5.setError("Email is Required");
                    e5.requestFocus();
                }else if (paswd.isEmpty()){
                    e6.setError("Password is Required");
                    e6.requestFocus();
                }else {

                    applicantRegModel.setName(nam);
                    applicantRegModel.setAddress(adrs);
                    applicantRegModel.setDob(dob);
                    applicantRegModel.setMob(mob);
                    applicantRegModel.setEmail(email);
                    applicantRegModel.setPassword(paswd);

                    String namValue = applicantRegModel.getName();
                    String adrsValue = applicantRegModel.getAddress();
                    String dobValue = applicantRegModel.getDob();
                    String mobValue = applicantRegModel.getMob();
                    String emailValue = applicantRegModel.getEmail();
                    String paswdValue = applicantRegModel.getPassword();

                    databaseReference.push().setValue(applicantRegModel);

                    Toast.makeText(getApplicationContext(), namValue + "\n" + adrsValue + "\n" + dobValue +  "\n" + "\n" + mobValue + "\n" + emailValue + "\n" + paswdValue + "\n", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
