package _JDBC.Day1;

import _JDBC.JDBC_Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Task extends JDBC_Parent {

    /** City tablosundaki tum kayitlari next ile yazdiriniz
        City tablosundaki tum kayitlari absolute ile yazdiriniz
        City tablosundaki tum kayitlari relative ile yazdiriniz */

    @Test
    private void test1() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from city");

        int count =0;
        while (resultSet.next()){
            System.out.println(resultSet.getString(1)); // sira numaralarini belirtmek icin bu sekilde yazabiliriz
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            count++;
        }
        System.out.println("count :" + count); // toplam kac tane city name var gostericek

    }

    @Test
    private void test2() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from city");

        int count =1; // row 1 den basladigi icin 1 verdik
        while (resultSet.absolute(count)){
            String cityName = resultSet.getString(2);
            System.out.println("cityName : " + cityName);
            count++;
        }
        System.out.println("count :" + (count-1)); // 1 den basladigi icin count-1 almamiz lazim

    }

    @Test
    private void test3() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from city");

        int count =0;
        while (resultSet.relative(1)){ // relative hep 1 adim ileri gidecegi icin 1  verdik
            String cityName = resultSet.getString(2);
            System.out.println("cityName : " + cityName);
            count++;
        }
        System.out.println("count :" + count);

    }
}
