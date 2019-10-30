package com.example.cocheraadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.TextUtilsCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.StringResourceValueReader;
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


        txtgeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent g = new Intent(OperAdmActivity.this,UbicacionActivity.class);
                startActivity(g);
            }
        });

        btnguar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String local = txtlocal.getText().toString();
                int ruc   =Integer.parseInt( txtruc.getText().toString());
                String dire  = txtdire.getText().toString();
                int siti  =Integer.parseInt(txtsiti.getText().toString());
                double hora  =Double.parseDouble(txthora.getText().toString());
                int geo = Integer.parseInt(txtgeo.getText().toString());
                cargardatos(local, dire,ruc, siti, hora, geo);
                Intent o = new Intent(OperAdmActivity.this,MenAdminActivity.class);
                startActivity(o);



            }
        });
    }

    private void cargardatos(String local, String dire,int ruc, int siti, double hora, int geo) {
        Map<String, Object> datoCochera = new HashMap<>();
        datoCochera.put("local", local);
        datoCochera.put("ruc",ruc);
        datoCochera.put("direccion",dire);
        datoCochera.put("sitio", siti);
        datoCochera.put("tarifa", hora);
        datoCochera.put("localizacion", geo);

        mDatabase.child("Cochera").push().setValue(datoCochera);
    }

}
