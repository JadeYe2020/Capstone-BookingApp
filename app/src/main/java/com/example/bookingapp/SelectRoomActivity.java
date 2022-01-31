package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SelectRoomActivity extends AppCompatActivity {

    ImageButton img_btn_weights, img_btn_cardio, img_btn_yoga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room);

        img_btn_weights= findViewById(R.id.img_btn_weights);
        img_btn_cardio = findViewById(R.id.img_btn_cardio);
        img_btn_yoga = findViewById(R.id.img_btn_yoga);


        img_btn_weights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String room = "weights";

                Intent i = new Intent(SelectRoomActivity.this, CalendarActivity.class);
                Bundle extras = new Bundle();
                extras.putString("KEY", room);
                i.putExtras(extras);
                startActivity(i);

                //startActivity(new Intent(getApplicationContext(),YogaCalendarActivity.class));
                finish();

            }
        });
//
        img_btn_cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String room = "cardio";

                Intent i = new Intent(SelectRoomActivity.this, CalendarActivity.class);
                Bundle extras = new Bundle();
                extras.putString("KEY", room);
                i.putExtras(extras);
                startActivity(i);

                //startActivity(new Intent(getApplicationContext(),YogaCalendarActivity.class));
                finish();

            }
        });

        img_btn_yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String room = "yoga";

               Intent i = new Intent(SelectRoomActivity.this, CalendarActivity.class);
               Bundle extras = new Bundle();
               extras.putString("KEY", room);
               i.putExtras(extras);
               startActivity(i);

                //startActivity(new Intent(getApplicationContext(),YogaCalendarActivity.class));
                finish();

            }
        });
    }

}