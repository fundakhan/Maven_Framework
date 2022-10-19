package _JDBC.Day1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_Before_After {

    private static Connection connection;

    private static Statement statement;

    @BeforeTest
    public void DBConnectionOpen() {
        //Baglanti islemleri yapilacak
        String url ="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname, port/db adi (JAVA - DB connection)
        String username="root"; // username
        String password="'\"-LhCB'.%k[4S]z"; //password


        try {
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     }

    @AfterTest
    public void DBConnectionClose(){
        //close
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() throws SQLException {
        // sorgu calisacak

        ResultSet resultSet = statement.executeQuery("select * from language");

        resultSet.next();
        String languageName1 = resultSet.getString("name");
        System.out.println("languageName : " + languageName1);

        resultSet.next();
        String languageName2 = resultSet.getString("name");
        System.out.println("languageName : " + languageName2);

        resultSet.next();
        String languageName3 = resultSet.getString("name");
        System.out.println("languageName : " + languageName3);

    }

    @Test
    public void test2() throws SQLException {
        // sorgu calisacak
        ResultSet resultSet = statement.executeQuery("select * from language");

        resultSet.next();
        String languageName1 = resultSet.getString(2); // 2. kolon u cagirdik
        System.out.println("languageName : " + languageName1);

        resultSet.next();
        String languageName2 = resultSet.getString(2);
        System.out.println("languageName : " + languageName2);

        resultSet.next();
        String languageName3 = resultSet.getString(2);
        System.out.println("languageName : " + languageName3);
    }


    @Test
    public void test3() throws SQLException {
        // sorgu calisacak
        ResultSet resultSet = statement.executeQuery("select * from language");

        resultSet.next(); // English
        String languageName1 = resultSet.getString(2); // 2. kolon u cagirdik
        System.out.println("languageName : " + languageName1);

        resultSet.next(); // Italian
        String languageName2 = resultSet.getString(2);
        System.out.println("languageName : " + languageName2);

        resultSet.previous(); // bir oncekine gitti English
        String languageName3 = resultSet.getString(2);
        System.out.println("languageName : " + languageName3);
    }
}
