package com.example.bookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {
    CalendarView calendarView;
    TextView tv_date;
    Button btn_next, btn_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_calendar);




        calendarView = findViewById(R.id.calendarView);
        tv_date = findViewById(R.id.tv_date);
        btn_next = findViewById(R.id.btn_next);
        btn_prev = findViewById(R.id.btn_prev);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                String sDate = sdf.format(calendar.getTime());
                tv_date.setText(sDate);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // determine which picture was clicked to get here
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String roomName = extras.getString("KEY");

                    if (roomName.equals("yoga")) {

                        //this will allow us to pass the date selected from the calender to the correct
                        //activity for booking time slots
                        String date = (String) tv_date.getText();
                        System.out.println(date);

                        Intent i = new Intent(CalendarActivity.this, YogaRmActivity.class);
                        Bundle dateExtra = new Bundle();
                        dateExtra.putString("DATE",date);
                        i.putExtras(dateExtra);
                        startActivity(i);

                        finish();

                    } else if (roomName.equals("weights")) {

                        String date = (String) tv_date.getText();
                        System.out.println(date);

                        Intent i = new Intent(CalendarActivity.this, WeightRmActivity.class);
                        Bundle dateExtra = new Bundle();
                        dateExtra.putString("DATE",date);
                        i.putExtras(dateExtra);
                        startActivity(i);

                        finish();
                    }

                    else if (roomName.equals("cardio")){

                        String date = (String) tv_date.getText();
                        System.out.println(date);

                        Intent i = new Intent(CalendarActivity.this, CardioRmActivity.class);
                        Bundle dateExtra = new Bundle();
                        dateExtra.putString("DATE",date);
                        i.putExtras(dateExtra);
                        startActivity(i);

                        finish();
                    }
                }



//                startActivity(new Intent(getApplicationContext(),YogaRmActivity.class));
//                finish();
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SelectRoomActivity.class));
                finish();
            }
        });
    }
}