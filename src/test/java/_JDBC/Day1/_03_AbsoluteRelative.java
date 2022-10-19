package _JDBC.Day1;

import _JDBC.JDBC_Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBC_Parent {

    @Test
    private void test1() throws SQLException {
        // next(); bir sonraki row a gider
        // previous() bir onceki row a gider
        // absolute(4) bastan itibaren 4. row a gider, direkt verilen row a gider
        // relative(4) bulundugu noktadan 4 row sonraki row a gider

        ResultSet resultSet = statement.executeQuery("select * from film");

        resultSet.absolute(10); // 10. satira git
        String title = resultSet.getString("title");
        System.out.println("title : " + title);

        resultSet.absolute(15); // 15. satira git
        title = resultSet.getString("title");
        System.out.println("title : " + title);

        resultSet.absolute(-15); // sondan 15. satira git
        title = resultSet.getString("title");
        System.out.println("title : " + title);

        resultSet.relative(5); // en son bulundugu yerden 5 satir ileri git
        title = resultSet.getString("title");
        System.out.println("title : " + title);

        resultSet.relative(-5); // en son bulundugu yerden 5 satir geri git
        title = resultSet.getString("title");
        System.out.println("title : " + title);
    }
}
