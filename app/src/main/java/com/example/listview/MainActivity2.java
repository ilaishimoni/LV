package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Boolean ari_geo;
    double x1;
    double mul_div;
    double [] for_ari_geo_double = new double[20];
    String[] for_ari_geo_show = new String[20];
    ListView lv;
    TextView tv;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    Intent gi;
    Double sum =0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gi = getIntent();

        ari_geo = gi.getBooleanExtra("handasit_heshbonit", true);
        x1 = gi.getDoubleExtra("first(double)", -10);
        mul_div = gi.getDoubleExtra("multi_div(double)", -10);
        lv = (ListView) findViewById(R.id.lv);
        tv = (TextView) findViewById(R.id.tv);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);





        if(ari_geo == true){


            for(int i=0; i<20; i++){
                for_ari_geo_double[i] = x1 * Math.pow(mul_div, i-1);
                for_ari_geo_show[i] = String.valueOf(for_ari_geo_double[i]);
                sum = sum + for_ari_geo_double[i];
            }
        }
        else {

            for (int i = 0; i<20; i++) {
                for_ari_geo_double[i] = x1 + (i - 1) * mul_div;
                for_ari_geo_show[i] = String.valueOf(for_ari_geo_double[i] );
                sum = sum + for_ari_geo_double[i];


            }
        }

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, for_ari_geo_show);
        lv.setAdapter(adp);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        tv.setText(String.valueOf(position));
        tv2.setText(String.valueOf(for_ari_geo_double[3] - for_ari_geo_double[2]));
        tv3.setText(String.valueOf(position+1));
        tv4.setText(String.valueOf(sum));

    }


    public void goback(View view) {
        finish();
    }
}