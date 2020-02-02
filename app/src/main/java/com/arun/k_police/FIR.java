package com.arun.k_police;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FIR extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    Button b1,b2;
    String id,nam,plc,dist,dir,dat,sect,witn,wdesc;
    FirModel firModel;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir);
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        e3=(EditText)findViewById(R.id.ed3);
        e4=(EditText)findViewById(R.id.ed4);
        e5=(EditText)findViewById(R.id.ed5);
        e6=(EditText)findViewById(R.id.ed6);
        e7=(EditText)findViewById(R.id.ed7);
        e8=(EditText)findViewById(R.id.ed8);
        e9=(EditText)findViewById(R.id.ed9);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("FIR");
        firModel=new FirModel();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id=e1.getText().toString().trim();
                nam=e2.getText().toString().trim();
                plc=e3.getText().toString().trim();
                dist=e4.getText().toString().trim();
                dir=e5.getText().toString().trim();
                dat=e6.getText().toString().trim();
                sect=e7.getText().toString().trim();
                witn=e8.getText().toString().trim();
                wdesc=e9.getText().toString().trim();

                if(id.isEmpty()){
                    e1.setError("ComplaintId is Required");
                    e1.requestFocus();

                }else if (nam.isEmpty()){
                    e2.setError("Name is Required");
                    e2.requestFocus();
                }else if (plc.isEmpty()){
                    e3.setError("Place is Required");
                    e3.requestFocus();
                }else if (dist.isEmpty()){
                    e4.setError("Distance is Required");
                    e4.requestFocus();
                }else if (dir.isEmpty()){
                    e5.setError("Direction is Required");
                    e5.requestFocus();
                }else if (dat.isEmpty()){
                    e6.setError("Date is Required");
                    e6.requestFocus();
                }else if (sect.isEmpty()){
                    e7.setError("Section is Required");
                    e7.requestFocus();
                }else if (witn.isEmpty()){
                    e8.setError("Witness is Required");
                    e8.requestFocus();
                }else if (wdesc.isEmpty()){
                    e9.setError("Witness Description is Required");
                    e9.requestFocus();
                }
                else
                {

                    firModel.setId(id);
                    firModel.setName(nam);
                    firModel.setPlace(plc);
                    firModel.setDistance(dist);
                    firModel.setDirection(dir);
                    firModel.setDate(dat);
                    firModel.setSection(sect);
                    firModel.setWitness(witn);
                    firModel.setWitDescr(wdesc);

                    String idValues=firModel.getId();
                    String namValues=firModel.getName();
                    String plcValues=firModel.getPlace();
                    String distValues=firModel.getDistance();
                    String dirValues=firModel.getDirection();
                    String datValues=firModel.getDate();
                    String sectValues=firModel.getSection();
                    String witValues=firModel.getWitness();
                    String wdesValues=firModel.getWitDescr();

                    databaseReference.push().setValue(firModel);

                    Toast.makeText(getApplicationContext(),idValues+"\n"+namValues+"\n"+plcValues+"\n"+distValues+"\n"+dirValues+"\n"+datValues+"\n"+sectValues+"\n"+witValues+"\n"+wdesValues,Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
