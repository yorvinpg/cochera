package com.example.cocheraadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class OperAdmActivity extends AppCompatActivity {

    EditText txtlocal,txtruc,txtdire,txtsiti,txthora,txtgeo;
    Button btnguar,btnatras;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_oper_adm);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        txtlocal = findViewById(R.id.txtloca);
        txtruc = findViewById(R.id.txtruc);
        txtdire = findViewById(R.id.txtdire);
        txtsiti = findViewById(R.id.txtsit);
        txthora = findViewById(R.id.txthora);
        txtgeo = findViewById(R.id.txtgeo);
        btnguar = findViewById(R.id.btnguar);
        btnatras = findViewById(R.id.btnatras);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Cochera");

        btnguar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String local = txtlocal.getText().toString();
                String ruc   = txtruc.getText().toString();
                String dire  = txtdire.getText().toString();
                String siti  = txtsiti.getText().toString();
                String hora  = txthora.getText().toString();
                String geo   = txtgeo.getText().toString();

                cochera coch =new cochera(local,Integer.valueOf(ruc),dire,Integer.valueOf(siti),Integer.valueOf(hora),Integer.valueOf(geo));

                mDatabase.child("Cochera").child(local).setValue(coch);
                Toast.makeText(getApplicationContext(),
                        "Cochera Registrado",
                        Toast.LENGTH_SHORT).show();


            }
        });
    }

}
