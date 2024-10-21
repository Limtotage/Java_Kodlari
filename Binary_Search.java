/* Binary Search (İkili Arama), sıralı bir dizide bir elemanı etkin bir şekilde
aramak için kullanılan bir algoritmadır. Bu algoritma, her adımda diziyi ikiye
bölerek arama yapar ve böylece elemanın konumunu bulur veya olmadığını belirtir. 
Binary Search, sıralı bir dizi üzerinde çalışır ve arama işleminin zaman karmaşıklığı
O(log n)’dir, bu da onu büyük veri kümelerinde çok hızlı bir arama algoritması yapar.*/

public class Binary_Search {
    public static int binary_Search(int[] Dizi, int Hedef) {
        int ilk = 0;
        int son = Dizi.length - 1;

        while (ilk <= son) {
            int Orta = ilk + (son - ilk) / 2;  // Ortadaki elemanı bul

            // Aranan eleman ortadaki eleman mı?
            if (Dizi[Orta] == Hedef) {
                return Orta;
            }

            // Eğer aranan eleman ortadaki elemandan küçükse sol yarıya bak
            if (Dizi[Orta] > Hedef) {
                son = Orta - 1;
            }
            // Eğer aranan eleman ortadaki elemandan büyükse sağ yarıya bak
            else {
                ilk = Orta + 1;
            }
        }

        // Eleman bulunamazsa -1 döndür
        return -1;
    }

    public static void main(String[] args) {
        int[] Dizi = {2, 3, 4, 10, 40, 50, 60, 70, 80};
        int Hedef = 10;
        Arrays.sort(Dizi);
        int Sonuc = binary_Search(Dizi, Hedef);
        if (Sonuc == -1) {
            System.out.println("Eleman dizide bulunamadı.");
        } else {
            System.out.println("Eleman bulundu: indeks " + Sonuc);
        }
    }
}
public class BinarySearch_Recursive {

    public static int binarySearch_Recursive(int[] Dizi, int ilk, int son, int Hedef) {
        if (ilk <= son) {
            int Orta = ilk + (son - ilk) / 2;  // Ortadaki elemanı bul

            // Aranan eleman ortadaki eleman mı?
            if (Dizi[Orta] == Hedef) {
                return Orta;
            }

            // Eğer aranan eleman ortadaki elemandan küçükse sol yarıya bak
            if (Dizi[Orta] > Hedef) {
                return binarySearch_Recursive(Dizi, ilk, Orta - 1, Hedef);
            }

            // Eğer aranan eleman ortadaki elemandan büyükse sağ yarıya bak
            return binarySearch_Recursive(Dizi, Orta + 1, son, Hedef);
        }

        // Eleman bulunamazsa -1 döndür
        return -1;
    }

    public static void main(String[] args) {
        int[] Dizi = {2, 3, 4, 10, 40, 50, 60, 70, 80};
        int Hedef = 40;

        int Sonuc = binarySearch_Recursive(Dizi, 0, Dizi.length - 1, Hedef);
        if (Sonuc == -1) {
            System.out.println("Eleman dizide bulunamadı.");
        } else {
            System.out.println("Eleman bulundu: indeks " + Sonuc);
        }
    }
}

