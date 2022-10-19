package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    // kendisine verilen path deki excelin istenilen sheetindeki
    // istenilen kolona kadar sutunlari okuyup ArrayList formatinda geri donduren fonksiyonu yaziniz
    //  getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx", "testCitizen", 2); 0-2


    public static   ArrayList<ArrayList<String>> getListData(String path,String sheetName,int columnCount){
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();

        Workbook workbook;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheet(sheetName);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  // her satira gitcem o satir kadar colonunu alicam

            ArrayList<String> satirData = new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {  // verilen parametre kadar(colon kadar) git diyoruz
                satirData.add(sheet.getRow(i).getCell(j).toString());
            }

            tablo.add(satirData);

        }


        return tablo;
    }

    //TODO: kendisine verilen   path, scenario name, browserType, time parametreleri ile
    //yeni bir excele butun raporu yazacak. dosyanin varligini yoklugunu google dan bulunuz.

    public static void writeExcel(String path, Scenario scenario,String browserName, String time) {

        File file = new File(path);

        if (!file.exists()){ //file yoksa(!)
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Page1");

            Row newRow = sheet.createRow(0);

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);


            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close(); // hafiza bosaltildi
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{

            FileInputStream inputStream = null; //okuma modunda acildi
            Workbook workbook = null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows(); // 6 satir var 0-5 index 0 dan basliyor
            Row newRow = sheet.createRow(rowCount); // her zaman sonuncuya atacak. en son satirin altina acildi

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);


            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



/** burayi kullanicaz, aslinda burasi unit test icin */
    public static void main(String[] args) {

        ArrayList<ArrayList<String>> tablo=
        getListData("src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx", "Page1",2); //2. colonu vermis olur. 4 dersek 4. colona kadar verir

        System.out.println("tablo : " + tablo);



    }
}
