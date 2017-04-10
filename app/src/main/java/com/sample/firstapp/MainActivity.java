package com.sample.firstapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import static android.R.attr.phoneNumber;

public class MainActivity extends AppCompatActivity {
    String phNumber="";

    RadioButton btnRadio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        //EditText txtDis = (EditText)findViewById(R.id.editText);
        //txtDis.setFocusable(false);
        Button buttonSubmit;

        RadioGroup grpRadio=(RadioGroup) findViewById(R.id.radioGroup);

       // phNumber = "tel:+91-904-965-3059";

        //final int selectedId = grpRadio.getCheckedRadioButtonId();
        grpRadio.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
                                                 @Override
                                                 public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                                                     btnRadio = (RadioButton) findViewById( checkedId );

                                                     if (btnRadio.getText().equals( "Call Smriti" )) {
                                                         phNumber = "tel:+91-904-965-3059";

                                                     } else if (btnRadio.getText().equals( "Call Parth" )) {
                                                         phNumber = "tel:+91-996-721-0890";

                                                     }


                                                 }
                                             });
            //selectId = grpRadio.getCheckedRadioButtonId();
                //Toast.makeText( getApplicationContext(),String.valueOf( selectedId ), Toast.LENGTH_LONG).show();

                // find the radiobutton by returned id


        buttonSubmit=(Button) findViewById(R.id.btnSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), phNumber, Toast.LENGTH_LONG).show();

                if (phNumber.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please select one of the options", Toast.LENGTH_LONG).show();
                }

                else {
                    //Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_LONG).show();
                    Intent phoneIntent = new Intent( Intent.ACTION_CALL );
                    phoneIntent.setData( Uri.parse( phNumber ) );

                    if (ActivityCompat.checkSelfPermission( MainActivity.this,
                            Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }


                    startActivity( phoneIntent );
                }



            }


        });

    }



}
