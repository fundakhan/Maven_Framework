package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {

    public static void main(String[] args) throws IOException {

        //Var olan bir EXCEL yazma islemi. yani ici bos bir excel. ici bos olsada ortada var olan bir excel icin yapiyoruz
        String path = "src/test/java/ApachePOI/Resource/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream = new FileInputStream(path);  //once okuma modunda acildi

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheet("Sheet1");

        // hafizada olusturma ve yazma islemleri yapiliyor
        Row newRow = sheet.createRow(0); //satir olusturuldu 0. yerde
        Cell newCell = newRow.createCell(0); //yeni satirda ilk hucre olusturuldu. henuz daha karsiya yazilmadi hafizada bekliyor. kaydedene kadar bir etkisi yok suan
        newCell.setCellValue("Hello World");  // bilgi yazildi

        for (int i = 1; i < 10; i++) { // 0 i yukarda baslattigimiz izin for da 1 den baslattik
            newRow.createCell(i).setCellValue(i);
        }

        // sira kaydetmeye geldi, butun bilgiler hafizada buraya kadar
        inputStream.close(); // okuma modunu kapattim, cunku yazma modunda acmam gerekiyor.

        // yazma islemini YAZMA modunda acip oyle yapacagiz.
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close(); // hafiza bosaltildi
        outputStream.close();
        System.out.println("islem tamamlandi");
    }
}
