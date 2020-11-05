package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost/pbz2?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "123qwe";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            Scanner scanner = new Scanner(System.in);
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Controller controller = new Controller(conn);
                View view = new View();
                view.run(controller,scanner);
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}