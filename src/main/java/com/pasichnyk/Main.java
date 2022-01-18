package com.pasichnyk;

import java.util.List;

import static com.pasichnyk.DatabaseOperation.*;

public class Main {

    public final static String Url = "jdbc:mysql://localhost:3306/sqltest";
    public final static String username = "root";
    public final static String password = "xalimonenko001";

    public static void main(String[] args) {

        List<Users> users = getUsersOrderByName();
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







