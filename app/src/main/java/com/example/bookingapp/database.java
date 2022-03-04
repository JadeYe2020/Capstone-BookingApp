package com.example.bookingapp;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class database {
    private static String driver = "com.mysql.jdbc.Driver";
    public static Connection connection = null;
    Context context;

    database(Context context) {
        this.context=context;
    }

    public void Connect() {

        new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    Class.forName(driver);

                    connection = DriverManager.getConnection("jdbc:mysql://redteam.cohm64yxxjxy.us-east-1.rds.amazonaws.com/RedTeam?useUnicode=" +

                                    "true&characterEncoding=utf8",

                            "gymCustomer", "inft3000!");


                    Looper.prepare();

                    Toast.makeText(context, "connect successfully", Toast.LENGTH_SHORT).show();

                    Looper.loop();


                } catch (SQLException | ClassNotFoundException e) {

                    Log.d(String.valueOf(this), "connect error:" + e.toString());

                    Toast.makeText(context, "connect failed", Toast.LENGTH_SHORT).show();

                }

            }

        }).start();

    }


    public void insert(String email,String room, String date,String time){

        new Thread(new Runnable() {
            @Override

            public void run() {

                String SQL ="insert into booking values( '"+email+"','"+room+"','"+date+"','"+time+"');";

                try {

                    Statement statement =connection.createStatement();

                    statement.execute(SQL);

                }catch (SQLException e) {

                    Log.d("insert","insert failed"+e.toString());

                }

            }

        }).start();

    }

    public HashMap<String, Integer> count(String room, String date) {
        HashMap<String, Integer> bookedCount = new HashMap();
        String[] time = new String[1];
        Integer[] count = new Integer[1];
        MyRunnable myRunnable = new MyRunnable() {

            @Override

            public void run() {

                String SQL = "SELECT time, COUNT(*) as idCount FROM booking WHERE room = '"+room+"' and date ='"+date+"' GROUP BY time;";



                try {
                    if (connection==null){
                        Class.forName(driver);

                        connection = DriverManager.getConnection("jdbc:mysql://redteam.cohm64yxxjxy.us-east-1.rds.amazonaws.com/RedTeam?useUnicode=" +

                                        "true&characterEncoding=utf8",

                                "gymCustomer", "inft3000!");}


                    Statement statement =connection.createStatement();

                    ResultSet resultSet = statement.executeQuery(SQL);

                    while (resultSet.next()) {
                        time[0] = resultSet.getString(1);
                        System.out.println("time[0]"+time[0]);
                        count[0] = resultSet.getInt(2);
                        System.out.println("count[0]"+count[0]);

                        bookedCount.put(time[0], count[0]);

                        Log.d("count", (count[0]+""));
                    }

                }catch (Exception e) {

                    Log.d("bookedcount"," failed"+e.toString());

                }

            }

            @Override
            public HashMap<String, Integer> getMap() {
                return bookedCount;
            }
        };

        Thread myThread = new Thread(myRunnable);
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return myRunnable.getMap();
    }



    public int reserved(String email,String room,String date,String time){
        int[] count = new int[1];
        MyRunnable myRunnable = new MyRunnable() {

            @Override

            public void run() {


                String SQL ="select count(*) as idCount from booking where email='"+email+"' and date ='"+date+"' and time ='"+time+"'";
//                String SQL ="select count(*) as idCount from booking where email='"+email+"' and  room = '"+room+"' and date ='"+date+"' and time ='"+time+"'";

                try {
                    if (connection==null){
                        Class.forName(driver);

                        connection = DriverManager.getConnection("jdbc:mysql://redteam.cohm64yxxjxy.us-east-1.rds.amazonaws.com/RedTeam?useUnicode=" +

                                        "true&characterEncoding=utf8",

                                "gymCustomer", "inft3000!");}


                    Statement statement =connection.createStatement();

                    ResultSet resultSet = statement.executeQuery(SQL);

                    while (resultSet.next()) {
                        count[0] =resultSet.getInt("idCount");
                        String count1=""+ count[0];
                        Log.d("count",count1);
                    }

                }catch (Exception e) {

                    Log.d("count"," failed"+e.toString());

                }

            }


            public int getValue() {
                String count1="counted in getValue: "+ count[0];
                Log.d(String.valueOf(this),count1);

                return count[0];
            }
        };

        Thread myThread = new Thread(myRunnable);
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return myRunnable.getValue();
    }

    public List<Person> select( String email) {
        final String[] personData = new String[5];
        List<Person> people = new ArrayList<>();

         SelectRunnable myRunnable=new SelectRunnable(){

            @Override

            public void run() {

                String SQL = "SELECT  * FROM booking WHERE email ='"+email+"';";



                try {
                    if (connection==null){
                        Class.forName(driver);

                        connection = DriverManager.getConnection("jdbc:mysql://redteam.cohm64yxxjxy.us-east-1.rds.amazonaws.com/RedTeam?useUnicode=" +

                                        "true&characterEncoding=utf8",

                                "gymCustomer", "inft3000!");}


                    Statement statement =connection.createStatement();

                    ResultSet resultSet = statement.executeQuery(SQL);

                    while (resultSet.next()) {
                        personData[0] = resultSet.getString(1);
                        personData[1] = resultSet.getString(2);
                        personData[2] = resultSet.getString(3);
                        personData[3] = resultSet.getString(4);

                        Person person=new Person();
                        person.setEmail(personData[0]);
                        person.setRoom(personData[1]);
                        person.setName("TestUser");
                        person.setTime(personData[3]);
                        people.add(person);    


                    }

                }catch (Exception e) {

                    Log.d("bookedcount"," failed"+e.toString());

                }

            }

            @Override
            public List<Person> getValue() {
                return people;
            }
        };

        Thread myThread = new Thread(myRunnable);
        myThread.start();
        try {
            myThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return myRunnable.getValue();
    }

    public List<Person> adminSelect(String date,String room) {
        final String[] personData = new String[5];
        List<Person> people = new ArrayList<>();

        SelectRunnable myRunnable=new SelectRunnable(){

            @Override

            public void run() {

                String SQL = "SELECT  * FROM booking WHERE date='"+date+"' and room='"+room+"';";



                try {
                    if (connection==null){
                        Class.forName(driver);

                        connection = DriverManager.getConnection("jdbc:mysql://redteam.cohm64yxxjxy.us-east-1.rds.amazonaws.com/RedTeam?useUnicode=" +

                                        "true&characterEncoding=utf8",

                                "gymCustomer", "inft3000!");}


                    Statement statement =connection.createStatement();

                    ResultSet resultSet = statement.executeQuery(SQL);

                    while (resultSet.next()) {
                        personData[0] = resultSet.getString(1);
                        personData[1] = resultSet.getString(2);
                        personData[2] = resultSet.getString(3);
                        personData[3] = resultSet.getString(4);

                        Person person=new Person();
                        person.setEmail(personData[0]);
                        person.setRoom(personData[1]);
                        person.setName("TestUser");
                        person.setTime(personData[3]);
                        people.add(person);
                        System.out.println("date and room"+personData[0]);

                    }

                }catch (Exception e) {

                    Log.d("bookedcount"," failed");

                }

            }

            @Override
            public List<Person> getValue() {
                return people;
            }
        };

        Thread myThread = new Thread(myRunnable);
        myThread.start();
        try {
            myThread.join();
            System.out.println("date and room"+personData[0]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return myRunnable.getValue();
    }



}


