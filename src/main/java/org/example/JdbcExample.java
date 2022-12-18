package org.example;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {

        /// stringul din connection tebuie sa arate astfel: jdbc:mysql://localhost:3306/flower_shop
        try {
            System.out.println("Trying to connect to database.");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flower_shop",
                    "root", "root");
            System.out.println("Conection to database successful.");
            // trimitem statementuri ca sa trimitem queriuri catre baza de date
            //primim results inapoi
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("Select * from product");
            if (resultSet.next()){
                String name=resultSet.getString(2);
                Integer quantity = resultSet.getInt(5);
                Double price = resultSet.getDouble(4);
                System.out.println("Produsul " + name + " cu pretul " + price + " maxim " + quantity + " bucati");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }
