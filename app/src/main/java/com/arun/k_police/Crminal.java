package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Crminal extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1,b2;
    String nam,desc,crim,dat;
    CrminalModel crminalModel;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crminal);

        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        e3=(EditText)findViewById(R.id.ed3);
        e4=(EditText)findViewById(R.id.ed4);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("CrminalDetails");
        crminalModel=new CrminalModel();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nam=e1.getText().toString().trim();
                desc=e2.getText().toString().trim();
                crim=e3.getText().toString().trim();
                dat=e4.getText().toString().trim();

                if(nam.isEmpty()){
                    e1.setError("Name is Required");
                    e1.requestFocus();

                }else if (desc.isEmpty()){
                    e2.setError("Description is Required");
                    e2.requestFocus();
                }else if (crim.isEmpty()){
                    e3.setError("crime is Required");
                    e3.requestFocus();
                }else if (dat.isEmpty()){
                    e4.setError("Date is Required");
                    e4.requestFocus();
                }
                else
                {
                    crminalModel.setName(nam);
                    crminalModel.setDescription(desc);
                    crminalModel.setCrime(crim);
                    crminalModel.setDate(dat);

                    String namValue=crminalModel.getName();
                    String desValue=crminalModel.getDescription();
                    String criValue=crminalModel.getCrime();
                    String datValue=crminalModel.getDate();

                    databaseReference.push().setValue(crminalModel);

                    Toast.makeText(getApplicationContext(),namValue+"\n"+desValue+"\n"+criValue+"\n"+datValue,Toast.LENGTH_LONG).show();

                }


            }
        });
    }
}
