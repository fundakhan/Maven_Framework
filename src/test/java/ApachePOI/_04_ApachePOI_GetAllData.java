package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOI_GetAllData {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx";

        FileInputStream inputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheet("sheet1");

        //sheet deki toplam satir sayisini verir
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount ; i++) {
            Row row = sheet.getRow(i);

            int cellCount = row.getPhysicalNumberOfCells();

            for (int j = 0; j < cellCount; j++) { // i. satirdaki hucre sayisi kadar donecek
                Cell cell = row.getCell(j); // bu satirdaki siradaki hucreyi aldim

                System.out.print(cell+ " ");

            }

            System.out.println();

        }
    }
}
