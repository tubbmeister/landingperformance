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
        double myNum;
        try {
            myNum = Double.parseDouble(weight);
            //myNum=myNum+1000;
            myNum=myNum-48000;
            myNum=myNum/5000;

            weight=(""+myNum); //convert int to str
            Resources r = getResources();
            int[] bases = r.getIntArray(R.array.f30_dry_ab3);

            double ref_dist;

            ref_dist =  bases[0]; // get first element of array
            ref_dist=ref_dist+(myNum*bases[1]);
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
