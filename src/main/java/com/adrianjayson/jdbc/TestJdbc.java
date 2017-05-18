package com.adrianjayson.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by adrianjayson on 5/17/17.
 */
public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";


        try {
            System.out.println("Connecting to database " + jdbcUrl + "...");
            Connection c = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!");

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
