package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WeightRmActivity extends AppCompatActivity {

    Button btn_prev, btn_9;
    TextView tvDate;
    database db=new database(WeightRmActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights_rm);
        db.Connect();

        btn_prev = findViewById(R.id.btn_prev);
        tvDate = findViewById(R.id.tvDate);
        btn_9 = findViewById(R.id.btn_9);

        String room = "WeightRm";  //-----------------------------------------------------insert



        //fetches the date passed in from calendar activity
        Bundle dateExtra = getIntent().getExtras();
        if (dateExtra != null) {
            String date = dateExtra.getString("DATE");
            tvDate.setText(date);   //-----------------------------------------------------there is a small bug here, when no date click by user
                                    //--------------------------------------------------sets a textView label
            System.out.println(date);

            String email = dateExtra.getString("EMAIL");
            System.out.println(email);
        }

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //passes the correct room back to calendar activity, effectively chaining them together
                String room = "weights";
                String email="";

                Bundle dateExtra = getIntent().getExtras();
                if (dateExtra != null) {
                    email = dateExtra.getString("EMAIL");
                    System.out.println(email);

                }

                Intent i = new Intent(WeightRmActivity.this, CalendarActivity.class);
                Bundle extras = new Bundle();
                extras.putString("KEY", room);
                extras.putString("EMAIL", email);
                i.putExtras(extras);
                startActivity(i);

                finish();
            }
        });

        //this can be used to query DB to determine if a button should be visible (not at room limit)
        //or if the buttons should be hidden (room limit has been reached)
       // loadWeightRmTimeSlots(room);

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String time = "09:00:00";   //---------------------------------------------------for insert
            ////-----------------------------------
                //This code will need to be called in each button in order
                // to get the the bundled information

                Bundle dateExtra = getIntent().getExtras();
                if (dateExtra != null) {
                    String date = dateExtra.getString("DATE");  //-------------------for insert
                    tvDate.setText(date);
                    String email = dateExtra.getString("EMAIL");  //-----------------for insert
                    System.out.println(email);
                    String dateFormat=date.replaceAll("/","-");

                    Log.e("tag",date);
                    Log.e("tag",email);
                    db.addTable(email,room,dateFormat,time);


//                    String count1=""+count;
//                    Log.e("tag",count1);
//                    System.out.println(count);
                }
                ////-------------------------------

            }
        });


    }

    private void loadWeightRmTimeSlots(String room) {
        int count=db.count(room);
            System.out.println(count);
            if(count>1){
                btn_9.setEnabled(false);


        }


    }


}