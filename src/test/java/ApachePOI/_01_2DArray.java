package ApachePOI;

public class _01_2DArray {
    public static void main(String[] args) {

        String[][] zoo = {{"Lion", "1"}, {"Dog", "2"}, {"Zebra", "3", "1"}, {"Cat", "4"}};

        System.out.println("*****************************");
        System.out.println(zoo[2][0]); //Zebra yi yazdirdik burada
        System.out.println(zoo[2][1]); // Zebradaki 3 yazdirdik
        System.out.println("*****************************");

        for (int i = 0; i < zoo.length; i++) {   //length satir sayisini verir

//            for (int j = 0; j < zoo[i].length; j++) { // i. satirin uzunlugunu verecek
//                System.out.print(zoo[i][j]+"\t"); // elemenlar arasina bir tab kadar bosluk kouyor
//
//            }
            /** 2. for olmasaydi her bir ikinci satir icin yani j yerine bu sekilde yapmis olacaktik */
//            System.out.print(zoo[i][0]+"\t");
//            System.out.print(zoo[i][1]+"\t");
//            System.out.print(zoo[i][2]+"\t");
//            System.out.print(zoo[i][4]+"\t");


            for (int j = 0; j < zoo[i].length; j++) { // i. satirin uzunlugunu verecek
                System.out.print(zoo[i][j] + "\t");


                System.out.println(); //aralarina bosluk vermek icin

            }

            // LIST: ne kadar eleman olacagi belli degilken
            // aslinda ne kadar eklenecegi belli degilken kullaniyoruz. mesela hoca not girecek ve ogrenci sayisi surekli degisiyor o zaman kullanilir gibi
        }
    }

}
