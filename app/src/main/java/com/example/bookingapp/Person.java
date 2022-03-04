package com.example.bookingapp;

public class Person {

    private String name;
    private String email;
    private String room;
    private String time;

    public Person(){};//empty constructor

    public Person(String name, String email, String room, String time) {
        this.name=name;
        this.email=email;
        this.room=room;
        this.time=time;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getRoom(){
        return room;
    }
    public void setRoom(String room){
        this.room = room;
    }

    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }
}
