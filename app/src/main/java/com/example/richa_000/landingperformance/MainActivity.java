package com.example.richa_000.landingperformance;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.richa_000.landingperformance.R.id.textView;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.floor;
import static java.lang.Math.sin;


public class MainActivity extends AppCompatActivity {


    private String flaps;
    int[] bases;
    int ii,stop;
    int metric;
    private CheckBox checkBox;
    double units = 1;
    public RadioGroup radioGroup, radioGroup1;
    private RadioButton flaps30, flaps40, tr2,tr1,tr0,other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //radioGroup = (RadioGroup) findViewById(radioGroup);
        addListenerOnChkIos();
               ;





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
                    weightText.setText("", TextView.BufferType.EDITABLE); //clears text on press
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
        final EditText wet5 = (EditText) findViewById(R.id.editText11);
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
        if (weight.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method
        }
        EditText elevnText = (EditText) findViewById(R.id.editText2);

        String elevation = elevnText.getText().toString();
        if (elevation.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method
        }
        EditText tempText = (EditText) findViewById(R.id.editText3);
        String temp = tempText.getText().toString();
        if (temp.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method
        }
        EditText winddctnText = (EditText) findViewById(R.id.editText4);
        String winddctn = winddctnText.getText().toString();
        if (winddctn.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method
        }
        EditText windspeedtext = (EditText) findViewById(R.id.editText5);
        String windspeed = windspeedtext.getText().toString();
        if (windspeed.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method
        }
        EditText rwText = (EditText) findViewById(R.id.editText6);
        String rwdctn = rwText.getText().toString();
        if (rwdctn.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method
        }
        EditText spdadjustText = (EditText) findViewById(R.id.editText7);
        String spdadjust = spdadjustText.getText().toString();
        if (spdadjust.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method
        }
        EditText slopeText = (EditText) findViewById(R.id.editText11);
        String slopeAdjust = slopeText.getText().toString();
        if (slopeAdjust.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method
        }
        double myNum, elevationNum, tempNum, winddctnNum, winspeedNum, rwdctnNum, spdadjustNum,slopeAdjustNum,trNum;






        myNum = Double.parseDouble(weight);//double because of decimal point
        elevationNum = Double.parseDouble(elevation);
        tempNum = Double.parseDouble(temp);
        winddctnNum = Double.parseDouble(winddctn);
        winspeedNum = Double.parseDouble(windspeed);
        rwdctnNum = Double.parseDouble(rwdctn);
        spdadjustNum = Double.parseDouble(spdadjust);
        slopeAdjustNum = Double.parseDouble(slopeAdjust);

     //  int selectedId = radioGroup.getCheckedRadioButtonId();
        flaps30 = (RadioButton) findViewById(R.id.radioButton);
        flaps40 = (RadioButton) findViewById(R.id.radioButton2);
        if(flaps30.isChecked()) {
            flaps = "thirty";
            // textView.setText("You chose 'Sound' option");
        }

         else if (flaps40.isChecked())   {
            flaps = "forty";
        }

        if (flaps.equals("thirty")) {
            ii = 0;
            stop=0;
        }
        else {
            ii = 8;


    }

        tr2 = (RadioButton) findViewById(R.id.radioButton4);
        tr1 = (RadioButton) findViewById(R.id.radioButton5);
        tr0 = (RadioButton) findViewById(R.id.radioButton3);
        trNum=1;
            if (tr2.isChecked()){   //obtain tr state
                trNum=1;
            }
            else if (tr1.isChecked())   {
                trNum=2;
            }
            else if (tr0.isChecked())   {
                trNum=3;
            }


        //trNum = Double.parseDouble(spdadjust);
               weight = ("" + myNum); //convert int to str
        Resources r = getResources();

            for ( ii = 0; ii <= 16; ii++) {

                stop++;
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
                else if (ii == 8) {
                    bases = r.getIntArray(R.array.f40_dry_ab3);

               }
                else if (ii == 9) {
                    bases = r.getIntArray(R.array.f40_dry_ab2);

                }
                else if (ii == 10) {
                    bases = r.getIntArray(R.array.f40_dry_ab1);

                }
                else if (ii == 11) {
                    bases = r.getIntArray(R.array.f40_dry_abmax);

                }
                else if (ii == 12) {
                    bases = r.getIntArray(R.array.f40_good_abmax);

                }
                else if (ii == 13) {
                    bases = r.getIntArray(R.array.f40_good_ab3);

                }
                else if (ii == 14) {
                    bases = r.getIntArray(R.array.f40_good_ab2);

                }
                else if (ii == 15) {
                    bases = r.getIntArray(R.array.f40_good_ab1);

                }
                double ref_dist, ref_dist1, ref_dist2, ref_dist3, ref_dist4, ref_dist5, ref_dist6, ref_dist7,ref_dist8,ref_dist9,cross;

                ref_dist = bases[0]; // get first element of array
                ref_dist = ref_dist + (((myNum - 48000) / 5000) * bases[1]);
                ref_dist1 = (elevationNum / 1000) * bases[3];
                ref_dist2 = (15 - (elevationNum / 1000) * 2) - (tempNum);



                ref_dist8=slopeAdjustNum;
                if (ref_dist8 > 0) {
                    ref_dist8 = (ref_dist8  * bases[9]);
                } else {
                    ref_dist8 = (ref_dist8  * bases[10]);
                }



                ref_dist9=0;

                if (trNum==1) {
                    ref_dist9=0;   //ref_dist9 = tr correction
                }
                    else if (trNum==2){
                    ref_dist9=(bases[11]);
                }

                    else if (trNum==3){
                    ref_dist9=(bases[12]);
                }
                if (ref_dist2 > 0) {
                    ref_dist2 = (ref_dist2 / 10) * bases[7];
                } else {
                    ref_dist2 = (ref_dist2 / 10) * bases[6];
                }
                ref_dist7 = (spdadjustNum / 10) * bases[8];
                double windissue,windissue1;
                windissue = (winddctnNum - (rwdctnNum * 10));
                windissue = (windissue) * (3.14159265358979 / 180);
                windissue1=windissue;
                windissue = cos(windissue);


                ref_dist3 = (winspeedNum * windissue);
                windissue1 = sin(windissue1);
                cross=windissue1*winspeedNum;
                TextView textView19 = (TextView) findViewById(R.id.textView19);
                TextView textView18 = (TextView) findViewById(R.id.textView18);
                TextView textView16 = (TextView) findViewById(R.id.textView16);
                TextView textView17 = (TextView) findViewById(R.id.textView17);
                int b =(int)Math.round(ref_dist3); //get rid of decimal

                int c =(int)Math.round(cross); //get rid of decimal
                c=abs(c);
                textView19.setText(""+c); //show crosswind component
                textView18.setVisibility(View.VISIBLE);
                textView16.setText(""+b); //show headwind component
                textView17.setVisibility(View.VISIBLE);

                if (ref_dist3 > 0) {

                    ref_dist3 = (ref_dist3 / 10) * bases[4];


                } else {

                    ref_dist3 = (ref_dist3 / 10) * bases[5];
                }


                ref_dist = ref_dist + ref_dist1 + ref_dist2 + ref_dist3 + ref_dist7+ref_dist8+ref_dist9;
                // ref_dist=floor(ref_dist);
                int i = (int) ref_dist;
                double aa = (i/units);//convert feet to meters
                int a =(int)Math.round(aa); //get rid of decimal
                weight = ("" + a);


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
             else   if (ii==8) {
                    TextView textView1 = (TextView) findViewById(R.id.textView);
                    textView1.setText(weight);
                }
                else if (ii==9){
                    TextView textView1 = (TextView) findViewById(R.id.textView3);
                    textView1.setText(weight);
                }

                else if (ii==10){
                    TextView textView1 = (TextView) findViewById(R.id.textView4);
                    textView1.setText(weight);
                }
                else if (ii==11){
                    TextView textView1 = (TextView) findViewById(R.id.textView9);
                    textView1.setText(weight);
                }
                else if (ii==12){
                    TextView textView1 = (TextView) findViewById(R.id.textView13);
                    textView1.setText(weight);
                }
                else if (ii==13){
                    TextView textView1 = (TextView) findViewById(R.id.textView12);
                    textView1.setText(weight);
                }
                else if (ii==14){
                    TextView textView1 = (TextView) findViewById(R.id.textView11);
                    textView1.setText(weight);
                }
                else if (ii==15){
                    TextView textView1 = (TextView) findViewById(R.id.textView10);
                    textView1.setText(weight);
                }
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);




            //================ Hide Virtual Key Board When  Clicking==================//


//======== Hide Virtual Keyboard =====================//
        if (stop==8) {
            ii=16;
        }

    }
        Toast.makeText(getApplicationContext(), "Press \""+"Calculate!" + "\" again if Flaps or T/R settings changed",

                Toast.LENGTH_LONG).show();
}


    public void showWind(View v) {  //allows view of winds only

        EditText winddctnText = (EditText) findViewById(R.id.editText4);
        String winddctn = winddctnText.getText().toString();
        if (winddctn.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method

        }
        EditText windspeedtext = (EditText) findViewById(R.id.editText5);
        String windspeed = windspeedtext.getText().toString();
        if (windspeed.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method
        }
        EditText rwText = (EditText) findViewById(R.id.editText6);
        String rwdctn = rwText.getText().toString();
        if (rwdctn.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            Toast.makeText(getApplicationContext(), "Ensure all data boxes filled!!",

                    Toast.LENGTH_SHORT).show();
            return; //quits method
        }
        double winddctnNum,winspeedNum,rwdctnNum;

        winddctnNum = Double.parseDouble(winddctn);
        winspeedNum = Double.parseDouble(windspeed);
        rwdctnNum = Double.parseDouble(rwdctn);

        double windissue,windissue1,ref_dist3,cross;
        windissue = (winddctnNum - (rwdctnNum * 10));
        windissue = (windissue) * (3.14159265358979 / 180);
        windissue1=windissue;
        windissue = cos(windissue);


        ref_dist3 = (winspeedNum * windissue);
        windissue1 = sin(windissue1);
        cross=windissue1*winspeedNum;
        TextView textView19 = (TextView) findViewById(R.id.textView19);
        TextView textView18 = (TextView) findViewById(R.id.textView18);
        TextView textView16 = (TextView) findViewById(R.id.textView16);
        TextView textView17 = (TextView) findViewById(R.id.textView17);
        int b =(int)Math.round(ref_dist3); //get rid of decimal

        int c =(int)Math.round(cross); //get rid of decimal
        c=abs(c);
        textView19.setText(""+c); //show crosswind component
        textView18.setVisibility(View.VISIBLE);
        textView16.setText(""+b); //show headwind component
        textView17.setVisibility(View.VISIBLE);

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            //================ Hide Virtual Key Board When  Clicking==================//

    }
    public void addListenerOnChkIos() {

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    units=3.28;
                }
                else  {
                    units=1;
                }
                sendMessage(v);// run calc again
            }
        });

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Rich's Landing Calculator..")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_option_menu, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent intent1 = new Intent(this,About.class);
                this.startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}