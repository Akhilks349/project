package com.arun.k_police;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

public class AdvocateLogin extends AppCompatActivity {
    EditText e1,e2;
    Button login,reg;
    String nam,pass;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advocate_login);

        SharedPreferences sharedPreferences=getSharedPreferences("LoginAdv",MODE_PRIVATE);
        String value=sharedPreferences.getString("userName",null);

        if(value!=null)
        {
            Intent ob3=new Intent(getApplicationContext(),AdvocateMenu.class);
            startActivity(ob3);
        }
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        login=(Button)findViewById(R.id.bt1);
        reg=(Button)findViewById(R.id.bt2);


        databaseReference= FirebaseDatabase.getInstance().getReference().child("Advocate");
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2=new Intent(getApplicationContext(),AdvocateReg.class);
                startActivity(in2);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nam=e1.getText().toString().trim();
                pass=e2.getText().toString().trim();

                Query query=databaseReference.orderByChild("userName").equalTo(nam);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot adv:dataSnapshot.getChildren()){
                            AdvocateRegModel advocateRegModel=adv.getValue(AdvocateRegModel.class);

                            String aname=advocateRegModel.name;
                            String acort=advocateRegModel.court;
                            String adesi=advocateRegModel.designation;
                            String aconct=advocateRegModel.concat;
                            String auname=advocateRegModel.userName;
                            String apass=advocateRegModel.password;

                            Toast.makeText(getApplicationContext(),nam+" "+pass,Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();

                            if(nam.equals(auname) && pass.equals(apass)){

                                SharedPreferences.Editor editor=getSharedPreferences("LoginAdv",MODE_PRIVATE).edit();
                                editor.putString("userName",auname);
                                editor.commit();
                                Intent intent1=new Intent(getApplicationContext(),AdvocateMenu.class);
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
