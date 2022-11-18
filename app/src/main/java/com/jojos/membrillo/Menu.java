package com.jojos.membrillo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    Button temp1;
    Button temp2;
    Button temp3;
    Button temp4;
    Button temp5;
    Button temp6;
    Button temp7;
    Button temp8;
    Button retroceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        temp1 = (Button) findViewById(R.id.button2);
        temp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Menu.this, Quiz2.class));
            }
        });
        temp2 = (Button) findViewById(R.id.button3);
        temp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Menu.this, Quiz2.class));
            }
        });
        temp3 = (Button) findViewById(R.id.button4);
        temp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Menu.this, Quiz2.class));
            }
        });
        temp4 = (Button) findViewById(R.id.button5);
        temp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Menu.this, Quiz2.class));
            }
        });
        temp5 = (Button) findViewById(R.id.button6);
        temp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Menu.this, Quiz2.class));
            }
        });
        temp6 = (Button) findViewById(R.id.button7);
        temp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Menu.this, Quiz2.class));
            }
        });
        temp7 = (Button) findViewById(R.id.button8);
        temp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Menu.this, Quiz2.class));
            }
        });
        temp8 = (Button) findViewById(R.id.button9);
        temp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Menu.this, Quiz2.class));
            }
        });
        retroceder = (Button) findViewById(R.id.button10);
        retroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Menu.this, MainActivity2.class));
            }
        });


    }

}
