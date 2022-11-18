package com.jojos.membrillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity2 extends AppCompatActivity {
    Button atras;
    Button continuar;
    Button cualeres;
    Button vuelta;
    String[]Partes={"Phantom Blood","Battle Tendency","Stardust Crusaders","Diamond is Unbreakable","Vento Aureo","Stone Ocean","Steel Ball Run","Jojolion"};
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth = FirebaseAuth.getInstance();


        Spinner spin=(Spinner) findViewById(R.id.spinner);

        atras = (Button) findViewById(R.id.atras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(MainActivity2.this, LoginActivity.class));
            }
        });
        cualeres = (Button) findViewById(R.id.cualeres);

        cualeres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });
        vuelta = (Button) findViewById(R.id.button);
        vuelta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, MapsActivity.class));
            }
        });
        continuar = (Button) findViewById(R.id.siguiente);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity2.this, Menu.class));
            }
        });

        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,Partes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

    }
}