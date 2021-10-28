package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Boolean handasit_heshbonit;
    EditText first;
    EditText multi_div;
    String str1;
    String str2;
    Intent gi;
    Switch sw;
    double first_double;
    double multi_div_double;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (EditText) findViewById(R.id.first);
        multi_div = (EditText) findViewById(R.id.multi_div);
        sw = (Switch) findViewById(R.id.sw);


    }


    public void move_activity(View view) {

        str1 = first.getText().toString(); //first
        str2 = multi_div.getText().toString(); //multi_div

        if (str1.isEmpty() || str2.isEmpty()){
            Toast.makeText(this, "please fill all lines", Toast.LENGTH_SHORT).show();

        }

        else{
            gi = new Intent(this, MainActivity2.class);

            if(sw.isChecked()){
                // handasit
                handasit_heshbonit = true;
                gi.putExtra("handasit_heshbonit", handasit_heshbonit);

            }
            else{
                //heshbonit
                handasit_heshbonit = false;
                gi.putExtra("handasit_heshbonit", handasit_heshbonit);

            }
            first_double = Double.parseDouble(str1);
            multi_div_double = Double.parseDouble(str2);

            gi.putExtra("first(double)", first_double);
            gi.putExtra("multi_div(double)", multi_div_double);

            startActivity(gi);

        }

    }
}