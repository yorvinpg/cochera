package com.example.cocheraadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OperaSitActivity extends AppCompatActivity {

    Button btnlibre, btnasignado;
    TextView libre, asignados;

    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opera_sit);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        libre = findViewById(R.id.txtlibres);
        asignados = findViewById(R.id.txtasignados);
        btnlibre = findViewById(R.id.btnliberar);
        btnasignado = findViewById(R.id.btnasignar);

        mDatabase.child("Cochera").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    int sitio = Integer.parseInt(dataSnapshot.child("sitio").getValue().toString());

                    libre.setText(+ sitio);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}
