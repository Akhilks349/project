package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddLaw extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    String sect,law;
    LawModel lawModel;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_law);
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        b1=(Button)findViewById(R.id.bt1);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Law");
        lawModel=new LawModel();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sect=e1.getText().toString().trim();
                law=e2.getText().toString().trim();

                if(sect.isEmpty()){
                    e1.setError("Name is Required");
                    e1.requestFocus();

                }else if (law.isEmpty()){
                    e2.setError("Adress is Required");
                    e2.requestFocus();
                }
                else
                {
                    lawModel.setSection(sect);
                    lawModel.setLaw(law);

                    String sectValues=lawModel.getSection();
                    String lawValues=lawModel.getLaw();

                    databaseReference.push().setValue(lawModel);

                    Toast.makeText(getApplicationContext(),sectValues+"\n"+lawValues,Toast.LENGTH_LONG).show();


                }
            }
        });
    }
}
