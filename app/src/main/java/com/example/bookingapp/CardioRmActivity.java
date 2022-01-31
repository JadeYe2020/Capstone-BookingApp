package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class CardioRmActivity extends AppCompatActivity {

    Button btn_prev, btn_9;
    TextView tvDate;
    FirebaseFirestore fbStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_rm);

        btn_prev = findViewById(R.id.btn_prev);
        btn_9 = findViewById(R.id.btn_9);
        tvDate = findViewById(R.id.tvDate);

        //this fetches the data we sent over with the date in it
        Bundle dateExtra = getIntent().getExtras();
        if (dateExtra != null) {
            String date = dateExtra.getString("DATE");
            System.out.println(date);
            tvDate.setText(date);
        }


        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String room = "cardio";

                Intent i = new Intent(CardioRmActivity.this, CalendarActivity.class);
                Bundle extras = new Bundle();
                extras.putString("KEY", room);
                i.putExtras(extras);
                startActivity(i);

                finish();
            }
        });



        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        loadTimes();


    }

    private void loadTimes() {


    }
}