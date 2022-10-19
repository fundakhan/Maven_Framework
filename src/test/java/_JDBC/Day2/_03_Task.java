package _JDBC.Day2;

import _JDBC.JDBC_Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/** SORU : getTable icin yaptigin ornegin aynisini
 *         bir XML file dan sorguyu parametre olarak gondererek bir Test icin yapiniz
 */

public class _03_Task extends JDBC_Parent {

  @Test
  public void test1() throws SQLException {

      getTable("select * from film_actor");
  }

  public void getTable(String query) throws SQLException {

      ResultSet resultSet = statement.executeQuery(query);

      ResultSetMetaData rsmd = resultSet.getMetaData();

      for (int i = 1; i <= rsmd.getColumnCount() ; i++)
          System.out.printf("%-15s", rsmd.getColumnName(i));

      System.out.println();

      while (resultSet.next()){
          for (int i = 1; i <= rsmd.getColumnCount() ; i++)
              System.out.printf("%-15s", resultSet.getString(i));

          System.out.println();
      }

  }
}
