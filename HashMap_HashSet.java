/*HashMap ve HashSet, Java'da veri saklama ve arama işlemlerini hızlı bir şekilde gerçekleştirmek için kullanılan koleksiyonlardır.

HashMap: Anahtar-değer çiftleri şeklinde veri saklar. O(1) ortalama karmaşıklık ile veriye erişim sağlar.
HashSet: Benzersiz elemanları saklamak için kullanılır ve içerik kontrolü için O(1) karmaşıklık sunar.*/

import java.util.HashMap;

public class HashMap {//Bir dizideki tekrar eden elemanları bulma
    public static void Tekrari_Bul(int[] Dizi) {
        HashMap<Integer, Integer> Tekrar_Haritasi = new HashMap<>();

        for (int Sayi : Dizi) {
            Tekrar_Haritasi.put(Sayi, Tekrar_Haritasi.getOrDefault(Sayi, 0) + 1);
        }

        System.out.println("Tekrar eden elemanlar:");
        for (int Anahtar : Tekrar_Haritasi.keySet()) {
            if (Tekrar_Haritasi.get(Anahtar) > 1) {
                System.out.println(Anahtar + " : " + Tekrar_Haritasi.get(Anahtar) + " kez tekrar ediyor.");
            }
        }
    }

    public static void main(String[] args) {
        int[] Dizi = {1, 2, 3, 1, 2, 4, 5};
        Tekrari_Bul(Dizi); 
        // Çıktı: 1 : 2 kez tekrar ediyor.
        //          2 : 2 kez tekrar ediyor.
    }
}

import java.util.HashSet;

public class HashSet {
    // Tekrar eden elemanları bulmak için bir metot
    public static void Tekrari_Bul(int[] Dizi) {
        HashSet<Integer> Tekrarsiz_Dizi = new HashSet<>(); // Benzersiz elemanları saklamak için HashSet
        boolean Tekrar_Varmi = false; // Tekrar olup olmadığını kontrol etmek için

        System.out.println("Tekrar eden elemanlar:");
        for (int Sayi : Dizi) {
            // Eğer Tekrarsiz_Dizi'sine eklenemiyorsa, bu eleman daha önce eklenmiş demektir
            if (!Tekrarsiz_Dizi.add(Sayi)) { // add metodu, eğer eleman zaten varsa false döner
                System.out.println(Sayi + " tekrar ediyor.");
                Tekrar_Varmi = true; // Tekrar eden bir eleman bulundu
            }
        }

        if (!Tekrar_Varmi) {
            System.out.println("Dizi içerisinde tekrar eden eleman yok.");
        }
    }

    public static void main(String[] args) {
        int[] Dizi = {1, 2, 3, 1, 2, 4, 5}; // Test dizisi
        Tekrari_Bul(Dizi); 
        // Çıktı: 1 tekrar ediyor.
        //          2 tekrar ediyor.
    }
}
