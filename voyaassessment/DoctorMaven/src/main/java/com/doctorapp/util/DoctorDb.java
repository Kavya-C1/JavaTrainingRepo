package com.doctorapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DoctorDb {

    static Connection connection;

    public DoctorDb() {
    }

    public static Connection openConnection() {
        String url = "jdbc:mysql://localhost:3306/doctorMavewwenProject";
        String username = "root";
        String password = "root";

        try {
            DriverManager.getConnection(url, username, password);
            System.out.println("Connected to db");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return DoctorDb.connection;
}}
