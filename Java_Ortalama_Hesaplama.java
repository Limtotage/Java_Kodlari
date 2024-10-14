import java.util.Scanner;
import java.util.ArrayList;

public class Java_Ortalama_Hesaplama {
    public static void main(String[] args) {
        Scanner Tarayici = new Scanner(System.in);
        System.out.print("Kac sayi gireceksiniz? ");
        int n = Tarayici.nextInt();
        int[] sayilar = new int[n];
        int toplam = 0;
        for (int i = 0; i < n; i++) {
            System.out.print((i+1) + ". sayiyi girin: ");
            sayilar[i] = Tarayici.nextInt();
            toplam += sayilar[i]; 
        }

        double ortalama = (double) toplam / n;
        System.out.println("Girilen sayilarin ortalamasi: " + ortalama);
        ArrayList<Integer> Kucukler = new ArrayList<>();
        ArrayList<Integer> Buyukler = new ArrayList<>();
        ArrayList<Integer> Esitler = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (sayilar[i] < ortalama) {
                Kucukler.add(sayilar[i]);
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
        switch (cvp) {
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
        
        Tarayici.close();
    }
}
