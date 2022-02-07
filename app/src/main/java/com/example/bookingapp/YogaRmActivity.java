package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YogaRmActivity extends AppCompatActivity {

    Button btn_prev;
    TextView tvDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_rm);

        btn_prev = findViewById(R.id.btn_prev);
        tvDate = findViewById(R.id.tvDate);   //this holds the date passed in from calendar

        //fetches the date passed in from calendar activity
        Bundle dateExtra = getIntent().getExtras();
        if (dateExtra != null) {

            String date = dateExtra.getString("DATE");
            tvDate.setText(date);
            System.out.println(date);

            String email = dateExtra.getString("EMAIL");
            System.out.println(email);

        }

            btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String room = "yoga";
                String email="";

                Bundle dateExtra = getIntent().getExtras();
                if (dateExtra != null) {
                    email = dateExtra.getString("EMAIL");
                    System.out.println(email);
                }

                Intent i = new Intent(YogaRmActivity.this, CalendarActivity.class);
                Bundle extras = new Bundle();
                extras.putString("KEY", room);
                extras.putString("EMAIL", email);
                i.putExtras(extras);
                startActivity(i);

                finish();
            }
        });
    }
}