package _JDBC.Day1;


//MySQL -> baslangicta ne yapmistik
//        1- Connection -> Baglanti ayarlarini yaptik  -> username, password, url( port, db, baglanti yolu)  ayarlarini yaptik (Connection)
//
//        2- Sorgu calistirma yolu -> Sonra sorgulari calismak icin page(yol) actik -> select * from ders; gibi
//
//        3- Sonuclarin alinmasi -> Sorgularin calismasi sonucu veri tabanindan gelen bilgiler

/** Connection bilgileri
 *  Hostname: db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com
 *  username : root
 *  Password: '"-LhCB'.%k[4S]z
 *  port : 3306
 *  db : sakila
 */


import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

   @Test
    public void test1() throws SQLException {
       String url ="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname, port/db adi (JAVA - DB connection)
       String username="root"; // username
       String password="'\"-LhCB'.%k[4S]z"; //password

/** 1. madde */
      Connection connection = DriverManager.getConnection(url,username,password); // Connection

/** 2. madde */
      Statement statement = connection.createStatement(); // sorgulari calistirmak icin page acildi


      ResultSet resultSet = statement.executeQuery("select * from actor"); // sorgu sonucu dolustu ama henuz db de bekliyor

/** 3. adim */
       resultSet.next(); //1. satira geldi

      String firstName = resultSet.getString("first_name");
      String lastName = resultSet.getString("last_name");

       System.out.println("firstname : " + firstName);
       System.out.println("lastname : " + lastName);

       resultSet.next(); // 2. satira geldi

        firstName = resultSet.getString("first_name");
        lastName = resultSet.getString("last_name");

       System.out.println("firstname : " + firstName);
       System.out.println("lastname : " + lastName);

       connection.close();
   }
}
