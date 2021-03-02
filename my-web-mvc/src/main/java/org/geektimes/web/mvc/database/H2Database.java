package org.geektimes.web.mvc.database;

import java.sql.*;
import java.util.Properties;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2021/03/01
 */
public class H2Database {

    public static H2Database getInstance() {
        return new H2Database();
    }

    private Connection connection;

    private H2Database() {
        try {
            init();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static final String CREATE_USERS_TABLE_DDL_SQL = "create table mvc_user ( " +
            "id integer auto_increment," +
            "name varchar(20)," +
            "password varchar(20)," +
            "email varchar(20)," +
            "phoneNumber varchar(20)," +
            "primary key (`id`));";


    private void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Driver driver = DriverManager.getDriver("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1");
        connection = driver.connect("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1", new Properties());
        Statement statement = connection.createStatement();
        // 创建 users 表
        System.out.println(statement.execute(CREATE_USERS_TABLE_DDL_SQL));
        statement.close();
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Driver driver = DriverManager.getDriver("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1");
        Connection connection = driver.connect("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1", new Properties());
        Statement statement = connection.createStatement();
        // 创建 users 表
        System.out.println(statement.execute(CREATE_USERS_TABLE_DDL_SQL));
    }

}
