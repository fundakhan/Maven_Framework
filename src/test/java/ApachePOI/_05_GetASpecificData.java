package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Verilen Exceldeki password bilgisini bir method araciligi ile bularak yazdiriniz
 *  yani method a "password" kelimesi gonderilecek, donen deger password un kendisi olacak
 *  src/test/java/ApachePOI/resources/LoginData.xlsx
 */

public class _05_GetASpecificData {

    /** bu kodlari yazicaz cunku printde neyei aramak icin kullanici yazarsa karsiliginda onu verecek. sadece password degil hepsini aratabilecek */
    public static void main(String[] args)  {

        System.out.print("aranacak kelime :");
        Scanner scan = new Scanner(System.in);
        String arananKelime = scan.next();

        String donenSonuc = bul(arananKelime);
        System.out.println("donenSonuc : " + donenSonuc); // burasi method u cagirip yazdiracak

    }

    public static String bul(String arananKelime) {

        String donecek = "";

        String path = "src/test/java/ApachePOI/Resource/LoginData.xlsx";

        /** try catch e eklemek daha mantikli interview sorusu bu. hatayi method a alman gerekirse try catch mi koyarsin yoksa method a imzayi mi koyarsin? */
        Workbook workbook = null;
        try {
          FileInputStream  inputStream = new FileInputStream(path);
          workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
                throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);  // getSheetAt bize deger girdirir. login ilk sayfa oldugu icin 0 verdik. Login yazmak yerine

        int satirSayisi = sheet.getPhysicalNumberOfRows(); // satir sayisini bulmak icin

        for (int i = 0; i < satirSayisi; i++) {
            Row row = sheet.getRow(i); //yukardan asagi tarayip

            Cell cell = row.getCell(0); // onun yanindakini gelip bulucak

            if (arananKelime.equalsIgnoreCase(cell.toString())) {

                int hucreSayisi = row.getPhysicalNumberOfCells();

                for (int j = 1; j < hucreSayisi; j++) {  // cell i birden baslattik cunku bi yukarda 1. kelimeyi eslestirmek icin 0 i kullanmistik tekrar gerek yok 0 dan baslatmaya

                    donecek += row.getCell(j) + " ";
                }

            }
        }

        return donecek;
    }







//        int rowCount = sheet.getPhysicalNumberOfRows();
//
//        for (int i = 0; i < rowCount; i++) {
//            Row row = sheet.getRow(i);
//
//            int cellCount = row.getPhysicalNumberOfCells();
//
//            for (int j = 0; j < cellCount; j++) {
//                Cell cell = row.getCell(j);
//
//                System.out.print(cell + " ");
//
//            }
//            System.out.println();
//        }

}
