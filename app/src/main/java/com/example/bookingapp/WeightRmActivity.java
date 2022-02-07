package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class WeightRmActivity extends AppCompatActivity {

    Button btn_prev, btn_9;
    TextView tvDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights_rm);

        btn_prev = findViewById(R.id.btn_prev);
        tvDate = findViewById(R.id.tvDate);
        btn_9 = findViewById(R.id.btn_9);

        String room = "WeightRm";

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
        loadWeightRmTimeSlots();

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String time = "9";   //---------------------------------------------------for insert


            ////-----------------------------------
                //This code will need to be called in each button in order
                // to get the the bundled information

                Bundle dateExtra = getIntent().getExtras();
                if (dateExtra != null) {
                    String date = dateExtra.getString("DATE");  //-------------------for insert
                    tvDate.setText(date);
                    String email = dateExtra.getString("EMAIL");  //-----------------for insert
                    System.out.println(email);

                }
                ////-------------------------------

            }
        });


    }

    private void loadWeightRmTimeSlots() {





    }
}