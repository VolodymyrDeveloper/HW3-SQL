package com.pasichnyk;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.pasichnyk.Main.*;

public class DatabaseOperation {

    static List<Users> getUsersOrderetByName() {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY username";
        try (Connection connection = DriverManager.getConnection(Url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String userName = resultSet.getString("username");
                    String userPassword = resultSet.getString("user_password");
                    String emailAddress = resultSet.getString("email_address");
                    int age = resultSet.getInt("age");
                    users.add(new Users(id, userName, userPassword, emailAddress, age));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    static List<Address> searchAddressByCityName(String cityName) {
        List<Address> addresses = new ArrayList<>();
        String sql = "SELECT * FROM address WHERE city =?;";
        try (Connection connection = DriverManager.getConnection(Url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cityName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String address = resultSet.getString("address");
                    String city = resultSet.getString("city");
                    int phone = resultSet.getInt("phone");
                    addresses.add(new Address(id, address, city, phone));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    static void deleteEmployeeById(int idEmployee) {
        String sql = "DELETE FROM employee WHERE employeeId = ?;";
        try (Connection connection = DriverManager.getConnection(Url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idEmployee);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("com.pasichnyk.Employee with " + idEmployee + " id successfully removed ");
    }

    static void printDataByWorkigDate(String workingDate) {
        String sql = "SELECT person_name, occupation FROM employee WHERE working_date = ?;";
        try (Connection connection = DriverManager.getConnection(Url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, workingDate);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("person_name") + " "
                            + resultSet.getString("occupation"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void printEmployeeAndUsers() {
        String sql = "SELECT employee.person_name, employee.working_date,employee.working_hours," +
                "users.email_address,users.age FROM employee INNER JOIN users ON employee.employeeId = users.id;";
        try (Connection connection = DriverManager.getConnection(Url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("person_name") + ";");
                    System.out.print(resultSet.getString("working_date") + ";");
                    System.out.print(resultSet.getInt("working_hours") + ";");
                    System.out.print(resultSet.getString("email_address") + ";");
                    System.out.print(resultSet.getInt("age") + ";");
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
