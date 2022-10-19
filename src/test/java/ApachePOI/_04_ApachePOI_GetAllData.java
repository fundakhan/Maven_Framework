package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _04_ApachePOI_GetAllData {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx";

        FileInputStream inputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheet("Page1");

        //sheet deki toplam satir sayisini verir
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);

            int cellCount = row.getPhysicalNumberOfCells();

            for (int j = 0; j < cellCount; j++) { // i. satirdaki hucre sayisi kadar donecek
                Cell cell = row.getCell(j); // bu satirdaki siradaki hucreyi aldim

                System.out.print(cell + " ");

            }

            System.out.println();

        }

    }

    public static List<String> loginCredentials(String sheetName, int rowNumber) {

        List<String> list = new ArrayList<>();
        String path = "src/test/java/ApachePOI/Resource/New.xlsx";

        FileInputStream inputStream;

        Workbook workbook;
        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        int cellCount = row.getPhysicalNumberOfCells();

        for (int j = 0; j < cellCount; j++) {
            Cell cell = row.getCell(j);
            list.add(cell.getStringCellValue());

        }
        return list;
    }
}
