package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class WeightRmActivity extends AppCompatActivity {

    Button btn_prev, btn_9, btn_10, btn_11, btn_12, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8;
    TextView tvDate;
    Database db = new Database(WeightRmActivity.this);
    static String date = "";
    static String email = "";
    static String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights_rm);

//        btn_prev = findViewById(R.id.btn_prev);
        tvDate = findViewById(R.id.tvDate);
        btn_9 = findViewById(R.id.btn_9);
        btn_10 = findViewById(R.id.btn_10);
        btn_11 = findViewById(R.id.btn_11);
        btn_12 = findViewById(R.id.btn_12);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        String room = "WeightRm";

        //fetches the date passed in from calendar activity
        Bundle dateExtra = getIntent().getExtras();
        if (dateExtra != null) {
            date = dateExtra.getString("DATE");
            tvDate.setText(date);
            System.out.println(date);

            email = dateExtra.getString("EMAIL");
            name = dateExtra.getString("NAME");
        }

        db.Connect();
        loadWeightRmTimeSlots(email, room, date);

//        btn_prev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //passes the correct room back to calendar activity, effectively chaining them together
//                String room = "weights";
//                String email = "";
//                String name = "";
//
//                Bundle dateExtra = getIntent().getExtras();
//                if (dateExtra != null) {
//                    email = dateExtra.getString("EMAIL");
//                    name = dateExtra.getString("NAME");
//
//                }
//
//                Intent i = new Intent(WeightRmActivity.this, CalendarActivity.class);
//                Bundle extras = new Bundle();
//                extras.putString("KEY", room);
//                extras.putString("EMAIL", email);
//                name = dateExtra.getString("NAME");
//                i.putExtras(extras);
//                startActivity(i);
//
//                finish();
//            }
//        });

        //this can be used to query DB to determine if a button should be visible (not at room limit)
        //or if the buttons should be hidden (room limit has been reached)


        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "9:00:00";   //---------------------------------------------------for insert
                db.insert(email, room, date, time, name);

                Toast.makeText(WeightRmActivity.this, "Room booked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(WeightRmActivity.this, Dashboard.class);
                Bundle dateExtra = new Bundle();
                dateExtra.putString("EMAIL", email);
                i.putExtras(dateExtra);
                startActivity(i);

                finish();
            }

        });
        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = "10:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }
        });

        btn_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "11:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }

        });
        btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "12:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }

        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "13:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }

        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "14:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }

        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "15:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }

        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "16:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }

        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "17:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }

        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "18:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }

        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "19:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }

        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = "20:00:00";
                db.insert(email, room, date, time, name);
                bookingSuccess();
            }

        });

    }

    public void loadWeightRmTimeSlots(String email, String room, String date) {
        HashMap<String, Button> times = new HashMap<String, Button>();
        times.put("09:00:00", btn_9);
        times.put("10:00:00", btn_10);
        times.put("11:00:00", btn_11);
        times.put("12:00:00", btn_12);
        times.put("13:00:00", btn_1);
        times.put("14:00:00", btn_2);
        times.put("15:00:00", btn_3);
        times.put("16:00:00", btn_4);
        times.put("17:00:00", btn_5);
        times.put("18:00:00", btn_6);
        times.put("19:00:00", btn_7);
        times.put("20:00:00", btn_8);

        // fetch the map of the booked time and the number of bookings at that time
        HashMap<String, Integer> bookedCount = db.count(room, date);

        for (String slot : times.keySet()) {
            int count = 0;

            if (bookedCount.get(slot) != null) {
                count = bookedCount.get(slot);
            }

            //Determine whether the user has made an appointment at this time
            int reserved = db.reserved(email, room, date, slot);

            if (count > 2 || reserved == 1) { // hard code magic number 2 for testing

                times.get(slot).setEnabled(false);
            }
        }
    }

    public void bookingSuccess() {

        // show a toast
        Toast toast = Toast.makeText(WeightRmActivity.this, "Room booked", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        // direct back to dashboard
        Intent i = new Intent(WeightRmActivity.this, Dashboard.class);
        Bundle dateExtra = new Bundle();
        dateExtra.putString("EMAIL", email);
        name = dateExtra.getString("NAME");
        i.putExtras(dateExtra);
        startActivity(i);
        finish();
    }
}