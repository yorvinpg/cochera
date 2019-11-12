package com.example.cocheraadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.text.TextUtilsCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.gms.location.FusedLocationProviderClient;
import android.widget.Toast;

import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class OperAdmActivity extends AppCompatActivity {

    private int My_PERMISSIONS_REQUEST_READ_CONTACTS;
    private FusedLocationProviderClient mFuse;
    EditText txtlocal,txtruc,txtdni,txtcell,txtdire,txtsiti,txthora;
    Button btnguar,btnatras,btnubi;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_oper_adm);

        mFuse = LocationServices.getFusedLocationProviderClient(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        txtlocal = findViewById(R.id.txtloca);
        txtruc   = findViewById(R.id.txtruc);
        txtdni   = findViewById(R.id.txtdni);
        txtcell  = findViewById(R.id.txtcell);
        txtdire = findViewById(R.id.txtdire);
        txtsiti = findViewById(R.id.txtsit);
        txthora = findViewById(R.id.txthora);

        btnubi = findViewById(R.id.btnubi);
        btnguar = findViewById(R.id.btnguar);
        btnatras = findViewById(R.id.btnatras);

        btnubi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subirLanLong();
            }
        });



        btnguar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String local = txtlocal.getText().toString();
                int    ruc   = Integer.parseInt( txtruc.getText().toString());
                int    dni   = Integer.parseInt(txtdni.getText().toString());
                int    cell  = Integer.parseInt(txtcell.getText().toString());
                String dire  = txtdire.getText().toString();
                int    siti  = Integer.parseInt(txtsiti.getText().toString());
                double hora  = Double.parseDouble(txthora.getText().toString());
                cargardatos(local, dire,ruc,dni,cell, siti, hora);
                Intent o = new Intent(OperAdmActivity.this,MenAdminActivity.class);
                startActivity(o);



            }
        });
    }
     private void subirLanLong()
     { if (ActivityCompat.checkSelfPermission(this,
             Manifest.permission.ACCESS_FINE_LOCATION)
             != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
             != PackageManager.PERMISSION_GRANTED){

         ActivityCompat.requestPermissions(OperAdmActivity.this,
                 new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                 My_PERMISSIONS_REQUEST_READ_CONTACTS);

         return;
     }
     mFuse.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
         @Override
         public void onSuccess(Location location) {
             if (location !=null){
                 Log.e("Latitud:",+ location.getLatitude()+"Longitud:"+location.getLongitude());
                 Map<String, Object> latlang = new HashMap<>();
                 latlang.put("latitud",location.getLatitude());
                 latlang.put("longitud",location.getLongitude());
                 mDatabase.child("Cochera").push().setValue(latlang);
                 Toast.makeText(OperAdmActivity.this, "Ubicacion Guardada", Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(OperAdmActivity.this, "No Guardado", Toast.LENGTH_SHORT).show();
             }

         }
     });

     }

    private void cargardatos(String local, String dire,int ruc,int dni, int cell, int siti, double hora) {
        Map<String, Object> datoCochera = new HashMap<>();
        datoCochera.put("local", local);
        datoCochera.put("ruc",ruc);
        datoCochera.put("dni", dni);
        datoCochera.put("cell",cell);
        datoCochera.put("direccion",dire);
        datoCochera.put("sitio", siti);
        datoCochera.put("tarifa", hora);
        mDatabase.child("Cochera").push().setValue(datoCochera);
        Toast.makeText(OperAdmActivity.this,"Guardado",Toast.LENGTH_SHORT).show();
    }

}
