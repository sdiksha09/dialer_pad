package com.example.shipra.dialer_pad;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Toast;


public class Call_activity extends AppCompatActivity {


    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    ImageView btnDelete;
    ImageView btnCall;


    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_activity);


        btn1 =(Button) findViewById(R.id.btnNum1);
        btn2 = (Button)findViewById(R.id.btnNum2);
        btn3 = (Button)findViewById(R.id.btnNum3);
        btn4 = (Button)findViewById(R.id.btnNum4);
        btn5 = (Button)findViewById(R.id.btnNum5);
        btn6 = (Button)findViewById(R.id.btnNum6);
        btn7 = (Button)findViewById(R.id.btnNum7);
        btn8 = (Button)findViewById(R.id.btnNum8);
        btn9 = (Button)findViewById(R.id.btnNum9);
        btn0 = (Button)findViewById(R.id.btnNum0);

        btnCall = (ImageView) findViewById(R.id.btnCall);
        btnDelete = (ImageView) findViewById(R.id.btnDelete);


        input= findViewById(R.id.input);



    }

    public void one(View v) {
        onButtonClick( btn1,input,"1");
    }

    public void two(View v) {
        onButtonClick(btn2, input, "2");
    }

    public void three(View v) {
        onButtonClick(btn3, input, "3");
    }

    public void four(View v) {
        onButtonClick(btn4, input, "4");
    }

    public void five(View v) {
        onButtonClick(btn5, input, "5");
    }

    public void six(View v) {
        onButtonClick(btn6, input, "6");
    }

    public void seven(View v) {
        onButtonClick(btn7, input, "7");
    }

    public void eight(View v) {
        onButtonClick(btn8, input, "8");
    }

    public void nine(View v) {
        onButtonClick(btn9, input, "9");
    }

    public void zero(View v) {
        onButtonClick(btn0, input, "0");
    }


    public void onDelete(View v) {
        input.setText("");
    }

    public void onDial(View V) {
        if (input.getText().length() <= 3) {
            Toast.makeText(this, "Please Enter valid the Number", Toast.LENGTH_SHORT).show();

        }
        else{
            Intent intent=new Intent(Intent.ACTION_CALL);

            String hash= input.getText().toString();
            if(hash.contains("#")){
                hash.replace("#","%23");
            }

                    intent.setData(Uri.parse("tel:"+ hash));
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_DENIED)

                return;
            else {


                startActivity(intent);

            }
        }
    }








   public  void onButtonClick(Button button,EditText inputNumber,String number) {

       String cache = input.getText().toString();
       inputNumber.setText(cache + number);


    }






}
