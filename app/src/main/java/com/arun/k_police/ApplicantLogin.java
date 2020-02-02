package com.arun.k_police;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ApplicantLogin extends AppCompatActivity {
    EditText e1,p1;
    Button login,reg;
    DatabaseReference databaseReference;
    String ema,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_login);

        SharedPreferences sharedPreferences=getSharedPreferences("LoginAppl",MODE_PRIVATE);
        String value=sharedPreferences.getString("email",null);

        if(value!=null)
        {
            Intent ob3=new Intent(getApplicationContext(),ApplicantMenu.class);
            startActivity(ob3);
        }
        e1=(EditText)findViewById(R.id.ed1);
        p1=(EditText)findViewById(R.id.ed4);
        login=(Button)findViewById(R.id.ed1);
        reg=(Button)findViewById(R.id.button4);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Applicant");
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

                ema=e1.getText().toString().trim();
                pass=p1.getText().toString().trim();

                Query query=databaseReference.orderByChild("email").equalTo(ema);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot appl:dataSnapshot.getChildren()){
                            ApplicantRegModel applicantRegModel=appl.getValue(ApplicantRegModel.class);
                            String aNam=applicantRegModel.name;
                            String aadrs=applicantRegModel.address;
                            String adob=applicantRegModel.dob;
                            String amob=applicantRegModel.mob;
                            String aemail=applicantRegModel.email;
                            String apass=applicantRegModel.password;

                            Toast.makeText(getApplicationContext(),ema+" "+pass,Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();

                            if(ema.equals(aemail) && pass.equals(apass)){

                                SharedPreferences.Editor editor=getSharedPreferences("LoginAppl",MODE_PRIVATE).edit();
                                editor.putString("email",aemail);
                                editor.commit();
                                Intent intent1=new Intent(getApplicationContext(),ApplicantMenu.class);
                                startActivity(intent1);

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"INCORRECT USERNAME OR PASSWORD",Toast.LENGTH_SHORT).show();
                            }

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });




            }
        });
    }


}
