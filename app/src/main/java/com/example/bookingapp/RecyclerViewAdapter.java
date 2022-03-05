package com.example.bookingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.MyViewHolder>{


    //THIS will be the list of people objects
    List<Person> list;


    public RecyclerViewAdapter(List<Person> list)
    {
        this.list = list;  //get the data from the list
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      //implement method
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person, parent, false);

        //create object of viewholder -> pass in view
        MyViewHolder myViewHolder = new MyViewHolder(view);

        //RETURN myViewHolder
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //this is where we assign the value to the person view----> or this is where we would assign value from DB

        holder.tvName.setText(list.get(position).getName());
        holder.tvEmail.setText(list.get(position).getEmail());
        holder.tvRoom.setText(list.get(position).getRoom());
        holder.tvTime.setText(list.get(position).getTime());
        holder.tvDateP.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        //this will return the size of the list
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

         TextView tvName, tvEmail, tvRoom, tvTime, tvDateP;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //set the textview to the single view
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvRoom = itemView.findViewById(R.id.tvRoom);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvDateP = itemView.findViewById(R.id.tvDateP);
        }
    }
}
