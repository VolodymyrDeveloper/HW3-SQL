package com.pasichnyk;

import java.util.List;

import static com.pasichnyk.DatabaseOperation.*;

public class Main {

    static String Url = "jdbc:mysql://localhost:3306/sqltest";
    static String username = "root";
    static String password = "xalimonenko001";

    public static void main(String[] args) {

        List<Users> users = getUsersOrderetByName();
        for (Users all : users) {
            System.out.println(all);
        }

        List<Address> addresses = searchAddressByCityName("New York");
        for (Address all : addresses) {
            System.out.println(all);
        }

        deleteEmployeeById(11);

        printDataByWorkigDate("2020-04-10");

        printEmployeeAndUsers();
    }

}







