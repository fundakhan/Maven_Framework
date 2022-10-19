package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _09_WriteNewExcel {

    public static void main(String[] args) throws IOException {

        // hic olmayan bir excel i olusturmak icin
        // hafizada yeni workbook olustur, sonra sheet olustur, sonra row olustur, sonra cell olustur
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Page1");


        // hafizada olusturma ve yazma islemleri yapiliyor
        Row newRow = sheet.createRow(0); //satir olusturuldu 0. yerde
        Cell newCell = newRow.createCell(0); //yeni satirda ilk hucre olusturuldu. henuz daha karsiya yazilmadi hafizada bekliyor. kaydedene kadar bir etkisi yok suan
        newCell.setCellValue("Hello World");  // bilgi yazildi

        for (int i = 1; i < 10; i++) { // 0 i yukarda baslattigimiz izin for da 1 den baslattik
            newRow.createCell(i).setCellValue(i);
        }


        // yazma islemini YAZMA modunda acip oyle yapacagiz.
        String nexExcelPath = "src/test/java/ApachePOI/Resource/NewExcel.xlsx";
        FileOutputStream outputStream = new FileOutputStream(nexExcelPath); // yukardaki path ismini verdik
        workbook.write(outputStream);
        workbook.close(); // hafiza bosaltildi
        outputStream.close();
        System.out.println("islem tamamlandi");

    }
}
