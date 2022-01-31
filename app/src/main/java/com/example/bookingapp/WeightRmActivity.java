package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WeightRmActivity extends AppCompatActivity {

    Button btn_prev;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights_rm);

        btn_prev = findViewById(R.id.btn_prev);
        tvDate = findViewById(R.id.tvDate);

        //fetches the date passed in from calendar activity
        Bundle dateExtra = getIntent().getExtras();
        if (dateExtra != null) {
            String date = dateExtra.getString("DATE");
            System.out.println(date);
            tvDate.setText(date);
        }


        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //passes the correct room back to calendar activity, effectively chaining them together
                String room = "weights";

                Intent i = new Intent(WeightRmActivity.this, CalendarActivity.class);
                Bundle extras = new Bundle();
                extras.putString("KEY", room);
                i.putExtras(extras);
                startActivity(i);

                finish();
            }
        });

        loadWeightRmTimeSlots();
    }

    private void loadWeightRmTimeSlots() {

        //could set it up as a case, query the db for each slot
        //case 9: query 9am time slot, return count, if count < 10, set visible

    }
}