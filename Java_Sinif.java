import java.util.Random;
import java.util.Scanner;

class Araba {//Nesnenin Olusturulmasi

    private String marka;
    private String model;
    private int yil;

    public Araba(String marka, String model, int yil) {//Kurucu method
        this.marka = marka;
        this.model = model;
        this.yil = yil;
    }

    public void bilgiYazdir() {//Bilgi Yazdıracak
        System.out.println("Marka: " + marka + ", Model: " + model + ", Yil: " + yil);
    }

    public void hizi(int artisim) {// Arabalara Hız Değeri atayacak
        System.out.println(marka + " " + model + " " + artisim + " km/h ile ilerliyor.");
    }
}

public class Java_Sinif {

    public static void main(String[] args) {
        Random rastgele = new Random();
        Scanner Tarayici = new Scanner(System.in);
        System.out.println("Kac Araba Girilecektir? Sayisini Giriniz.");  //Araba sayısı alınır.
        try {                                                               //eğer sayı girilmezse hata verecektir.
            int Araba_Say = Tarayici.nextInt();
            Tarayici.nextLine();
            String marka = "", model = "";
            int yili = 0;
            Araba[] arabalar = new Araba[Araba_Say];                        //Nesne dizisi oluşturulur.
            for (int i = 0; i < Araba_Say; i++) {
                System.out.println((i + 1) + ". Arabanin markasini giriniz.");
                marka = Tarayici.nextLine();
                System.out.println((i + 1) + ". Arabanin modelini giriniz.");
                model = Tarayici.nextLine();
                System.out.println((i + 1) + ". Arabanin yilini giriniz.");
                yili = Tarayici.nextInt();
                Tarayici.nextLine();                                        //Marka Model ve Yıl alınır.
                arabalar[i] = new Araba(marka, model, yili);                //Girilen verilerle Araba Oluşturulur.
            }
            int randomInt = 0;
            for (Araba nesnem : arabalar) {                                 //Arabalara Rastgele Hız değerleri Atanır.
                randomInt = rastgele.nextInt(101);
                nesnem.bilgiYazdir();
                nesnem.hizi(randomInt);
            }
        } catch (Exception e) {
            System.err.println(e+"\nSayi girmedin neden");                  //Hata bloğu
        }
    }
}
