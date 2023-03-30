package org.example;

import org.example.models.ModelClass;
import org.example.models.ModelUser;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Connection connection = DbHandler.connect();

        String username;
        String password;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name");
        username = scanner.nextLine();
        System.out.println("Enter password");
        password = scanner.nextLine();




    }
}
