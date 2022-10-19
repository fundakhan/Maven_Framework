package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _10_WriteMultiplicationTableInExcel {

    /** Soru 1:
     *  Carpim tablosunu excele yazdiriniz
     *  1 x 1 = 1 seklinde isaretleri ile birlikte yazdir
     *  sifirdan excel olusturulacak
     *  her bir onluktan sonra 1 satir bosluk birakarak alt alta yazilacak
      */

    /** Soru 2 :
     *  Carpim tablosunu excele yazdiriniz
     *   1 x 1 = 1 seklinde isaretleri ile birlikte yazdir
     *   sifirdan excel olusturulacak
     *   her bir onluktan sonra 1 kolon bosluk birakarak alt alta yazilacak
     */

    public static void main(String[] args) throws IOException {

        // hic olmayan bir excel i olusturmak icin
        // hafizada yeni workbook olustur, sonra sheet olustur, sonra row olustur, sonra cell olustur
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("MultiplicationTable");

        Row newRow = sheet.createRow(0); //satir olusturuldu 0. yerde
        Cell newCell = newRow.createCell(0); //yeni satirda ilk hucre olusturuldu. henuz daha karsiya yazilmadi hafizada bekliyor. kaydedene kadar bir etkisi yok suan
       // newCell.setCellValue(" x "+ " = ");

        int result = 1;
        for (int i = 1; i < 10; i++) {
            newCell.setCellValue(i);
            for (int j = 1; j < 10; j++) {
                result = i*j;
                newRow.createCell(i).setCellValue(j);
                newCell.setCellValue(i+ " " + "x" + " " +  j + " " + "=" + " " +  result );
            }
        }


        // yazma islemini YAZMA modunda acip oyle yapacagiz.
        String nexExcelPath = "src/test/java/ApachePOI/Resource/MultiplicationTable.xlsx";
        FileOutputStream outputStream = new FileOutputStream(nexExcelPath); // yukardaki path ismini verdik
        workbook.write(outputStream);
        workbook.close(); // hafiza bosaltildi
        outputStream.close();
        System.out.println("islem tamamlandi");
    }
}
