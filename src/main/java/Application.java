package org.rojae.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "rojae";
        String password = "rojae8918";

        // try with resource로 인해서 자원 회수에 용이
        // conntection 비용이 너무 비쌈
        // jdbc만을 사용하기에는 별로이다.
        // connection 객체를 미리 만들어 놓은 hikari 사용
        // ORM에 대해서 알아보자
        try(Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Conntection created: " + connection);
            //String sql = "CREATE TABLE ACCOUNT (id int, username varchar(255), password varchar(255));";
            String sql = "INSERT INTO ACCOUNT VALUES (2, 'rojae', '123');";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

