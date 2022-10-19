package _JDBC.Day2;

import _JDBC.JDBC_Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBC_Parent {

    @Test
    public void test1() throws SQLException {

        /** column da yazan isimleri almak icin */
        ResultSet resultSet = statement.executeQuery("select * from language");
        // ResultSet : data + meta (data disindaki diger bilgiler kolon sayisi, kolondaki name ler gibi...)

    /** meta data column da basliklar var data bilgilerini alirken onlari vermez. onlari gormek istedigimizde meta data kullaniriz */
    /** html de meta tag lar var onlarin amaci gorunen sayfanin haricindeki bilgileri saklar. datanin otesindeki bilgiler demek */
        ResultSetMetaData rsmd = resultSet.getMetaData();

        int columnCount = rsmd.getColumnCount(); // column sayisi
        System.out.println("columnCount : "+ columnCount); // kac kolon oldugunu verir. language de 3 column var

        for (int i = 1; i <= columnCount; i++) { // hem row hem column 1 den basliyor
            String columnName = rsmd.getColumnName(i);
            String columnType = rsmd.getColumnTypeName(i);

            System.out.println(columnName + " - " + columnType); // language_id, name, last_update

        }
    }

    @Test
    public void test2() throws SQLException {
 /** SORU */
        //language tablosundaki tum satirlari ve tum sutunlari yazdiriniz
        // ayni mysql sonuc ekraninda oldugu gibi. araliklari duzenli yazdiriniz

        ResultSet resultSet = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = resultSet.getMetaData();


        for (int i = 1; i <= rsmd.getColumnCount() ; i++)
            System.out.printf("%-15s" , rsmd.getColumnName(i)); // ayni sql de gordugumuz gibi yazmasini istedigimiz icin ("%-15s") format koyduk (-) koymamizin nedeni sola dayali yazsin diye
                                                                // (s) de string seklinde yazsin diye birde print(f) kullandik
        /** % : degiskenin degerini isaret eder
         *  - : sola dayali yazdirir, default saga dayali
         *  15 : kac hane kullanilacak her zaman onun bilgisi
         *  s  : string degerler icin,
         *  d  : sayisal degerler icin  kullanilir
         *  "%5.2d" : sayi icin 5 hane kullan, ondalikli kisim icin  2 hane kullan
         */
        System.out.println();

        while (resultSet.next()){ // hep bir sonraki satira gidecek // her biri satiri kolon sayisi kadar yan yana yaziyor
            for (int i = 1; i <= rsmd.getColumnCount() ; i++)
                System.out.printf("%-15s" , resultSet.getString(i));

            System.out.println();
        }
    }

    @Test
    public void test3() throws SQLException {
        /** actor tablosundaki tum satirlari ve tum sutunlari yazdiriniz, ayni mysql sonuc ekraninda oldugu gibi
         *  fakat method kullaniniz, method a sorguyu gonderiniz ve orada yazdiriniz
         */

        getTable("select * from actor");

    }

    public void getTable(String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);

        ResultSetMetaData rsmd = resultSet.getMetaData();
       /** bu interface */                 /** bu abstract */

        for (int i = 1; i <= rsmd.getColumnCount() ; i++)
            System.out.printf("%-15s" , rsmd.getColumnName(i));

        System.out.println();

        while (resultSet.next()){
            for (int i = 1; i <= rsmd.getColumnCount() ; i++)
                System.out.printf("%-15s" , resultSet.getString(i));

            System.out.println();
        }

    }

}
