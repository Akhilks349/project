package com.arun.k_police;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class PoliceLogin extends AppCompatActivity {
    EditText e1,e2;
    Button login;
    String unam,pass;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_login);
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        login=(Button)findViewById(R.id.bt1);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Police");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unam=e1.getText().toString().trim();
                pass=e2.getText().toString().trim();

                Query query=databaseReference.orderByChild("userName").equalTo(unam);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot pol:dataSnapshot.getChildren()){
                            PoliceRegModel policeRegModel=pol.getValue(PoliceRegModel.class);
                            String pNam=policeRegModel.name;
                            String pConc=policeRegModel.contact;
                            String pEml=policeRegModel.email;
                            String puNam=policeRegModel.userName;
                            String pPas=policeRegModel.password;

                            Toast.makeText(getApplicationContext(),unam+" "+pass,Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();

                            if(unam.equals(puNam) && pass.equals(pPas)){

                                Intent intent1=new Intent(getApplicationContext(),PoliceMenu.class);
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
