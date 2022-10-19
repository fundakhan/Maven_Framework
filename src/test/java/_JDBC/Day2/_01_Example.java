package _JDBC.Day2;

import _JDBC.JDBC_Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_Example extends JDBC_Parent {

    // last, first, getRow, getInt, getDouble

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select city_id, city, country_id from city");

        resultSet.last(); // sonuncu row a gider

        String id = resultSet.getString(1); //city_id
        System.out.println("id :" + id);

        int idInt = resultSet.getInt(1);
        System.out.println("idInt :"+idInt);

        String name = resultSet.getString(2);
        System.out.println("name :"+name);

        /** bunu String den int e donusturmez. ama herseyi String e donusturebilir */
       // int nameInt = resultSet.getInt(2);
       //  System.out.println("nameInt :" + nameInt);

    /** bir sorgunun sonucunda kac satir geldigini resultSet.last() dedikten sonra getRow() ile alabilirim */
        int kacinciSatir = resultSet.getRow();
        System.out.println("kacinciSatir :"+ kacinciSatir);

        resultSet.first(); // ilk satira gider



    }
}
