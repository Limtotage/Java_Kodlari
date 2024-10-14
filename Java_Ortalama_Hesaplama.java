
import java.util.ArrayList;                                                        //Kullanıcıdan Aldığı Sayıların Ortalaması alan Kod
import java.util.Scanner;

public class Java_Ortalama_Hesaplama {

    public static void main(String[] args) {
        Scanner Tarayici = new Scanner(System.in);
        System.out.print("Kac sayi gireceksiniz? ");                            //Kullanıcıdan Sayı Adetini Alıyor.
        try {
            int n = Tarayici.nextInt();
            int[] sayilar = new int[n];
            int toplam = 0;
            for (int i = 0; i < n; i++) {
                System.out.print((i + 1) + ". sayiyi girin: ");
                sayilar[i] = Tarayici.nextInt();
                toplam += sayilar[i];                                             //Sayılar Toplanır.
            }

            double ortalama = (double) toplam / n;                                //Ortalaması Alınır.
            System.out.println("Girilen sayilarin ortalamasi: " + ortalama);
            ArrayList<Integer> Kucukler = new ArrayList<>();
            ArrayList<Integer> Buyukler = new ArrayList<>();
            ArrayList<Integer> Esitler = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (sayilar[i] < ortalama) {
                    Kucukler.add(sayilar[i]);                                    //Ortalamaya göre başka dizilere atanır.
                } else if (sayilar[i] > ortalama) {
                    Buyukler.add(sayilar[i]);
                } else {
                    Esitler.add(sayilar[i]);
                }
            }
            System.out.println("Tum Elemanlar Listeye Eklendi ve Ortalamasi Hesaplandi.");
            System.out.println("Ortalamanin ustundekileri, altindakileri mi yoksa ortalamaya esit olanlari mi gormek istersiniz?.");
            System.out.println("Ust icin:0, Alt icin:1, Esit icin= 2 Tuslayiniz.");
            int cvp = Tarayici.nextInt();
            switch (cvp) {                                                      //Hangi Listenin istendiği sorulur.
                case 0:
                    System.out.println(Buyukler);
                    break;
                case 1:
                    System.out.println(Kucukler);
                    break;
                case 2:
                    System.out.println(Esitler);
                    break;
                default:
                    System.out.println("Gecersiz rakam. Lutfen 0, 1 veya 2 girin.");
                    break;
            }

        } catch (Exception e) {
            System.out.println(e + "\nLutfen Sayi Giriniz.");                 //try Catch ile girdiler güvenli hale gelir.
        }
        Tarayici.close();
    }
}
