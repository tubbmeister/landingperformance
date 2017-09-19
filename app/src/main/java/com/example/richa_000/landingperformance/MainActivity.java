package com.example.richa_000.landingperformance;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.richa_000.landingperformance.R.id.textView;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;


public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        double myNum,elevationNum,tempNum,winddctnNum,winspeedNum,rwdctnNum,spdadjustNum;
        try {
            myNum = Double.parseDouble(weight);//double because of decimal point
            elevationNum=Double.parseDouble(elevation);
            tempNum=Double.parseDouble(temp);
            winddctnNum=Double.parseDouble(winddctn);
            winspeedNum=Double.parseDouble(windspeed);
            rwdctnNum=Double.parseDouble(rwdctn);
            spdadjustNum=Double.parseDouble(spdadjust);
            //myNum=myNum+1000;
           // myNum=myNum-48000;
           // myNum=myNum/5000;

            weight=(""+myNum); //convert int to str
            Resources r = getResources();
            int[] bases = r.getIntArray(R.array.f30_dry_ab3);

            double ref_dist,ref_dist1,ref_dist2,ref_dist3,ref_dist4,ref_dist5,ref_dist6,ref_dist7;

            ref_dist =  bases[0]; // get first element of array
            ref_dist=ref_dist+(((myNum-48000)/5000)*bases[1]);
            ref_dist1=(elevationNum/1000)*bases[3];
            ref_dist2=(15-(elevationNum/1000)*2)-(tempNum);
            if (ref_dist2>0) {
                ref_dist2 = (ref_dist2 / 10) * bases[7];
            }
                else {
                ref_dist2 = (ref_dist2 / 10) * bases[6];
            }
            ref_dist7=(spdadjustNum/10)*bases[8];
            double windissue;
            windissue=(winddctnNum-(rwdctnNum*10));
            windissue=cos(windissue);
            windissue=(windissue)*(3.14159265358979/180);
            //windissue = cos(windissue);
            if (windissue<1) {
                windissue = 0;

            }
            ref_dist3=(winspeedNum*windissue);

                    if (ref_dist3>0) {

                            ref_dist3=(ref_dist3/10) * bases[4];


                    }
                        else {

                            ref_dist3=(ref_dist3/10) * bases[5];
                    }




            ref_dist=ref_dist+ref_dist1+ref_dist2+ref_dist3+ref_dist7;

            weight=(""+ref_dist);




            TextView textView1 = (TextView) findViewById(R.id.textView);
            textView1.setText(weight);
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch(NumberFormatException nfe){


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
    }}
}
