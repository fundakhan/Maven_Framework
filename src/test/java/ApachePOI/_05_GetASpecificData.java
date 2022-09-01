package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

/** Verilen Exceldeki password bilgisini bir method araciligi ile bularak yazdiriniz
 *  yani method a "password" kelimesi gonderilecek, donen deger password un kendisi olacak
 *  src/test/java/ApachePOI/resources/LoginData.xlsx
 */

public class _05_GetASpecificData {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/Resource/LoginData.xlsx";

        FileInputStream inputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheet("Login");

        Row row = sheet.getRow(1);

        Cell cell = row.getCell(1);

        System.out.println("password : " + cell );
    }
}
