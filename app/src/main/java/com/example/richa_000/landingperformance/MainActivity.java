package com.example.richa_000.landingperformance;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.richa_000.landingperformance.R.id.textView;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.floor;
import static java.lang.Math.sin;


public class MainActivity extends AppCompatActivity {


    private String item;
    int[] bases;
    int ii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.flaps30brakes, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner

        final EditText weightText = (EditText) findViewById(R.id.editText);
        weightText.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    weightText.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText elevationText = (EditText) findViewById(R.id.editText2);
        elevationText.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    elevationText.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet = (EditText) findViewById(R.id.editText3);
        wet.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet1 = (EditText) findViewById(R.id.editText4);
        wet1.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet1.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet2 = (EditText) findViewById(R.id.editText5);
        wet2.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet2.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet3 = (EditText) findViewById(R.id.editText6);
        wet3.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet3.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet4 = (EditText) findViewById(R.id.editText7);
        wet4.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet4.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
    }

    public void sendMessage(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String weight = editText.getText().toString();
        EditText elevnText = (EditText) findViewById(R.id.editText2);
        String elevation = elevnText.getText().toString();
        EditText tempText = (EditText) findViewById(R.id.editText3);
        String temp = tempText.getText().toString();
        EditText winddctnText = (EditText) findViewById(R.id.editText4);
        String winddctn = winddctnText.getText().toString();
        EditText windspeedtext = (EditText) findViewById(R.id.editText5);
        String windspeed = windspeedtext.getText().toString();
        EditText rwText = (EditText) findViewById(R.id.editText6);
        String rwdctn = rwText.getText().toString();
        EditText spdadjustText = (EditText) findViewById(R.id.editText7);
        String spdadjust = spdadjustText.getText().toString();

        double myNum, elevationNum, tempNum, winddctnNum, winspeedNum, rwdctnNum, spdadjustNum;

        myNum = Double.parseDouble(weight);//double because of decimal point
        elevationNum = Double.parseDouble(elevation);
        tempNum = Double.parseDouble(temp);
        winddctnNum = Double.parseDouble(winddctn);
        winspeedNum = Double.parseDouble(windspeed);
        rwdctnNum = Double.parseDouble(rwdctn);
        spdadjustNum = Double.parseDouble(spdadjust);
        //myNum=myNum+1000;
        // myNum=myNum-48000;
        // myNum=myNum/5000;

        weight = ("" + myNum); //convert int to str
        Resources r = getResources();

            for ( ii = 0; ii <= 8; ii++) {

                if (ii == 0) {
                    bases = r.getIntArray(R.array.f30_dry_ab3);
                }

                else if (ii == 1) {
                    bases = r.getIntArray(R.array.f30_dry_ab2);

                }

                else if (ii == 2) {
                     bases = r.getIntArray(R.array.f30_dry_ab1);

                }
                else if (ii == 3) {
                    bases = r.getIntArray(R.array.f30_dry_abmax);

                }
                else if (ii == 4) {
                    bases = r.getIntArray(R.array.f30_good_abmax);

                }
                else if (ii == 5) {
                    bases = r.getIntArray(R.array.f30_good_ab3);

                }
                else if (ii == 6) {
                    bases = r.getIntArray(R.array.f30_good_ab2);

                }
                else if (ii == 7) {
                    bases = r.getIntArray(R.array.f30_good_ab1);

                }
                double ref_dist, ref_dist1, ref_dist2, ref_dist3, ref_dist4, ref_dist5, ref_dist6, ref_dist7;

                ref_dist = bases[0]; // get first element of array
                ref_dist = ref_dist + (((myNum - 48000) / 5000) * bases[1]);
                ref_dist1 = (elevationNum / 1000) * bases[3];
                ref_dist2 = (15 - (elevationNum / 1000) * 2) - (tempNum);
                if (ref_dist2 > 0) {
                    ref_dist2 = (ref_dist2 / 10) * bases[7];
                } else {
                    ref_dist2 = (ref_dist2 / 10) * bases[6];
                }
                ref_dist7 = (spdadjustNum / 10) * bases[8];
                double windissue;
                windissue = (winddctnNum - (rwdctnNum * 10));
                windissue = (windissue) * (3.14159265358979 / 180);
                windissue = cos(windissue);

                //windissue = cos(windissue);
                //if (windissue<1) {
                //       windissue = 0;

                //   }
                ref_dist3 = (winspeedNum * windissue);

                if (ref_dist3 > 0) {

                    ref_dist3 = (ref_dist3 / 10) * bases[4];


                } else {

                    ref_dist3 = (ref_dist3 / 10) * bases[5];
                }


                ref_dist = ref_dist + ref_dist1 + ref_dist2 + ref_dist3 + ref_dist7;
                // ref_dist=floor(ref_dist);
                int i = (int) ref_dist;
                weight = ("" + i);

            if (ii==0) {
                TextView textView1 = (TextView) findViewById(R.id.textView);
                textView1.setText(weight);
            }
            else if (ii==1){
                TextView textView1 = (TextView) findViewById(R.id.textView3);
                textView1.setText(weight);
            }

            else if (ii==2){
                TextView textView1 = (TextView) findViewById(R.id.textView4);
                textView1.setText(weight);
            }
            else if (ii==3){
                TextView textView1 = (TextView) findViewById(R.id.textView9);
                textView1.setText(weight);
            }
            else if (ii==4){
                TextView textView1 = (TextView) findViewById(R.id.textView13);
                textView1.setText(weight);
            }
            else if (ii==5){
                TextView textView1 = (TextView) findViewById(R.id.textView12);
                textView1.setText(weight);
            }
            else if (ii==6){
                TextView textView1 = (TextView) findViewById(R.id.textView11);
                textView1.setText(weight);
            }
            else if (ii==7){
                TextView textView1 = (TextView) findViewById(R.id.textView10);
                textView1.setText(weight);
            }
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);



       /* Resources r = getResources();
        int[] bases = r.getIntArray(R.array.f30_dry_ab3);
        TextView textView1 = (TextView) findViewById(R.id.textView);
        int runway;

        runway =  bases[0]; // get first element of array
        runway=runway+myNum;
        message=(""+runway);
        textView1.setText(message);*/
            //================ Hide Virtual Key Board When  Clicking==================//


//======== Hide Virtual Keyboard =====================//


    }
}}