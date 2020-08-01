package com.sharmaumang.bulksms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    EditText mobileno,message;
    Button sendsms;
    Integer mIndex =1;
    TextView mIndexView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileno=(EditText)findViewById(R.id.editText1);
        message=(EditText)findViewById(R.id.editText2);
        sendsms=(Button)findViewById(R.id.button1);
        mIndexView = findViewById(R.id.textView1);




        sendsms.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String mNumber=mobileno.getText().toString();
                String mMsg=message.getText().toString();

                if (mNumber == "") {

                    mIndexView.setText("Please Enter at least one Number");

                }else {

                    String numbers[] = mNumber.split(", *");

                    SmsManager sms=SmsManager.getDefault();

                    for(String number : numbers) {

                        sms.sendTextMessage(number, null, mMsg,null, null);

                        mIndexView.setText(mIndex+" Message sent");
                        mIndex = mIndex+1;
                    }

                    mIndexView.setText(mIndex+" Message sent");
                    mobileno.setText("");
                    message.setText("");

                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}