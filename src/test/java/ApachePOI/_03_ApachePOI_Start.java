package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class _03_ApachePOI_Start {

    public static void main(String[] args) throws IOException {

        // once Dosyanin yolunu yani path ini aliyoruz
        String path = "src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx";

        //Java Dosya okuma islemcisine dosyanin yolunu veriyoruz. boylece program ile dosya arasinda baglanti olustu
        FileInputStream dosyaOkumaBaglatisi = new FileInputStream(path);

        //Dosya okuma islemcisi uzerinden workbook aliyorum
        //ilk once hucreye(cell) ulasmadan once hepsini kapsayan worbook a ulasmam gerekiyor
        //hafizada workbook u alip olusturdu
        Workbook workbook = WorkbookFactory.create(dosyaOkumaBaglatisi);

        //bu asamada workbook sayfasindan sheet i aliyoruz
        Sheet calismaSayfasi = workbook.getSheet("sheet1");

        //istenen satiri aliyorum
        Row satir = calismaSayfasi.getRow(0);

        //istenen hucreyi aliyorum
        Cell hucre = satir.getCell(0);

        System.out.println("hucre : " + hucre); //yazdirip okuyalim


    }
}
