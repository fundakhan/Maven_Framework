package _JDBC;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Parent {

    /**
     *  1- Create a connection
     *  2- Create statement/Query
     *  3- Execute statement/Query
     *  4- Close connection
     */

    private static Connection connection;

    protected static Statement statement;

    @BeforeTest
    public void DBConnectionOpen() {
        //Baglanti islemleri yapilacak
        String url ="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname, port/db adi (JAVA - DB connection)
        String username="root"; // username
        String password="'\"-LhCB'.%k[4S]z"; //password


        try {
            /**  1- Create a connection */
            connection = DriverManager.getConnection(url,username,password);
            /** 2- Create statement/Query */
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void DBConnectionClose(){
        //close
        try {
            /**  4- Close connection */
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
