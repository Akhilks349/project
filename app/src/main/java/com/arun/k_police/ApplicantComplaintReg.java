package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ApplicantComplaintReg extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button b1,b2;
    String nam,emai,phon,compln,desc;
    AppComplaintRegModel appComplaintRegModel;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_complaint_reg);
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        e3=(EditText)findViewById(R.id.ed3);
        e4=(EditText)findViewById(R.id.ed4);
        e5=(EditText)findViewById(R.id.ed5);
        b1=(Button)findViewById(R.id.ed1);
        b2=(Button)findViewById(R.id.ed2);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("ApplicantComplaint");
        appComplaintRegModel=new AppComplaintRegModel();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                nam=e1.getText().toString().trim();
                emai=e2.getText().toString().trim();
                phon=e3.getText().toString().trim();
                compln=e4.getText().toString().trim();
                desc=e5.getText().toString().trim();

                if(nam.isEmpty()){
                    e1.setError("Name is Required");
                    e1.requestFocus();

                }else if (emai.isEmpty()){
                    e2.setError("Email is Required");
                    e2.requestFocus();
                }else if (phon.isEmpty()){
                    e3.setError("Phone no. is Required");
                    e3.requestFocus();
                }else if (compln.isEmpty()){
                    e4.setError("Complaint is Required");
                    e4.requestFocus();
                }else if (desc.isEmpty()){
                    e5.setError("Description is Required");
                    e5.requestFocus();
                }else {

                    appComplaintRegModel.setName(nam);
                    appComplaintRegModel.setEmail(emai);
                    appComplaintRegModel.setPhone(phon);
                    appComplaintRegModel.setComplaint(compln);
                    appComplaintRegModel.setDescription(desc);

                    String namVAlue=appComplaintRegModel.getName();
                    String emailVAlue=appComplaintRegModel.getEmail();
                    String phoneVAlue=appComplaintRegModel.getPhone();
                    String comVAlue=appComplaintRegModel.getComplaint();
                    String descVAlue=appComplaintRegModel.getDescription();

                    databaseReference.push().setValue(appComplaintRegModel);




                    Toast.makeText(getApplicationContext(),namVAlue+"\n"+emailVAlue+"\n"+phoneVAlue+"\n"+comVAlue+"\n"+descVAlue,Toast.LENGTH_LONG).show();




                }
            }
        });



    }
}
