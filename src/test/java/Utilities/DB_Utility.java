package Utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;

public class DB_Utility {

    private static Connection connection;

    protected static Statement statement;


    private static void DBConnectionOpen() { // static koymamizin nedeni canli calisabilir hale getirdik. ve pravite yapabiliriz kendi class inin icide kullanilacagi icin
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


    private static void DBConnectionClose(){
        //close
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) { // veriler geliyor mu diye kontrol icin yaptik burayi

        // test etmek icin alttaki fonksiyonu main e cagirdik
        ArrayList<ArrayList<String>> tablo = getListData("select * from actor");

        for (ArrayList<String> row : tablo)
            System.out.println("row : " + row);
    }

    public static ArrayList<ArrayList<String>> getListData(String query){

        ArrayList<ArrayList<String>> tablo = new ArrayList<>();
        //db den butun satirlari ve sutunlari okuyup bu liste aticam.

        // db baglantiyi ac
        DBConnectionOpen();


        try {
            // 1- sorguyu calistir
            ResultSet resultSet = statement.executeQuery(query);

            // 2- butun satirlari ve satirlardaki sutunlari oku tabloya akle
            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                ArrayList<String> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }

                tablo.add(row);
            }
        } catch (Exception ex){
            System.out.println("ex.getMessage() =" + ex.getMessage());
        }


        DBConnectionClose();
        return tablo;
    }


}
