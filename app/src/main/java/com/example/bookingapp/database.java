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

                    Class.forName(driver);// 动态加载类

                    connection = DriverManager.getConnection("jdbc:mysql://192.168.0.6:3306/redteam?useUnicode=" +

                                    "true&characterEncoding=utf8",

                            "gymCustomer", "LY009cOrPtiPCe6u");


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

    public void mQuery() {

        final String SQL = "select date from booking";

        final String[] date = new String[10];

        new Thread(new Runnable() {

            @Override

            public void run() {
                int i = 0;
                try {

                    Statement statement = (Statement) connection.createStatement();

                    ResultSet resultSet = statement.executeQuery(SQL);

                    while (resultSet.next()) {

                        date[i] = resultSet.getString("date");
                        Log.d(String.valueOf(this), "name：" + date[i]);
                        i++;
                    }

                } catch (SQLException e) {

                    e.printStackTrace();

                }

            }

        }).start();

    }

    public void addTable(String email,String room, String date,String time){

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

    public int count(String room){
        int[] count = new int[1];
        new Thread(new Runnable() {

            @Override

            public void run() {

                String SQL ="select count(*) as idCount from booking where room = '"+room+"'";

                try {

                    Statement statement =connection.createStatement();

                    ResultSet resultSet = statement.executeQuery(SQL);

                    while (resultSet.next()) {
                        count[0] =resultSet.getInt("idCount");
                        String count1=""+ count[0];
                        Log.d(String.valueOf(this),count1);
                    }


                }catch (SQLException e) {

                    Log.d("insert","insert failed"+e.toString());

                }

            }

        }).start();
        return count[0];
    }


}