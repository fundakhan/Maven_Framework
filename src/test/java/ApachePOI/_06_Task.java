package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Task {

    /**
        Bir onceki yapilan soruda, kullaniciya 1. sutundaki tum degerler bir liste halinde kullaniciya
        yanlarinda bir numara olarak sunalim. Kullanici hangi numarayi girerse o satirin yanindaki tum bilgiler gosterilsin.
        Username icin 1
        Password icin 2
     .....
     .....
        giriniz = 2  gibi kullanici hangisini girerse onu yazacak
      */

    public static void main(String[] args) {

        System.out.print("aranacak kelime :");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        int donenSonuc = bul(number);
        System.out.println("donenSonuc : " + donenSonuc);
    }

    public static int bul(int number){

       String donecek = "";

        String path =  "src/test/java/ApachePOI/Resource/WriteInTheExcelFile.xlsx";

        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);

        int satirSayisi = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < satirSayisi; i++) {
            Row row = sheet.getRow(i);

            Cell cell = row.getCell(0);

            if (number == cell.getColumnIndex() ){
                int hucreSayisi = row.getPhysicalNumberOfCells();

                for (int j = 0; j < hucreSayisi; j++) {
                    donecek += row.getCell(j) +" " ;

                }
            }
        }
        return Integer.parseInt(donecek);
    }
}
