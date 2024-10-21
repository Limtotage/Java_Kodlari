/*  Sliding Window tekniği, bir dizi veya string içinde bir pencere (window) boyutunu 
hareket ettirerek belirli bir durumu kontrol etmeyi sağlar. Genellikle 
alt dizi/alt string bulma problemlerinde kullanılır.  */

public class Sliding_Window {//Bir dizide belirli bir uzunlukta en yüksek toplamı bulma.
    public static int Maks_Top(int[] Dizi, int k) { 
        int Maks_Top = 0;
        int Pencere_Top = 0;

        // İlk pencereyi hesapla
        for (int i = 0; i < k; i++) {
            Pencere_Top += Dizi[i];
        }
        Maks_Top = Pencere_Top;

        // Pencereyi kaydır
        for (int i = k; i < Dizi.length; i++) {
            Pencere_Top += Dizi[i] - Dizi[i - k]; // Yeni elemanı ekle, eski elemanı çıkar
            Maks_Top = Math.max(Maks_Top, Pencere_Top);
        }
        return Maks_Top; // En yüksek toplamı döndür
    }

    public static void main(String[] args) {
        int[] Dizi = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(Maks_Top(Dizi, k)); // Çıktı: 9 (5 + 1 + 3)
    }
}
