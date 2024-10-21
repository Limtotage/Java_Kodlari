/*Heap, bir binary tree (ikili ağaç) veri yapısının bir çeşididir. 
Heap sort, öncelikle verilen diziyi bir heap yapısına dönüştürür 
ve ardından heap'ten teker teker elemanları çıkararak sıralı bir liste elde eder.
Min Heap: Her düğüm, tüm alt düğümlerinden küçük veya onlara eşit olan bir değere sahiptir.
Max Heap: Her düğüm, tüm alt düğümlerinden büyük veya onlara eşit olan bir değere sahiptir.*/
import java.util.Arrays;

public class Heap_Sort {
    public void heapify(int Dizi[], int n, int Kok) {
        int En_byk = Kok;   // Kök elemanı en büyük kabul et
        int Sol = 2 * Kok + 1;  // Sol çocuk
        int Sag = 2 * Kok + 2;  // Sağ çocuk

        // Eğer sol çocuk kökten büyükse
        if (Sol < n && Dizi[Sol] > Dizi[En_byk]) {
            En_byk = Sol;
        }

        // Eğer sağ çocuk en büyükse
        if (Sag < n && Dizi[Sag] > Dizi[En_byk]) {
            En_byk = Sag;
        }

        // Eğer en büyük eleman kök değilse
        if (En_byk != Kok) {
            int temp = Dizi[Kok];
            Dizi[Kok] = Dizi[En_byk];
            Dizi[En_byk] = temp;

            // Alt ağaçta heapify işlemi tekrar yapılır
            heapify(Dizi, n, En_byk);
        }
    }

    public void Diz(int Dizi[]) {
        int n = Dizi.length;

        // Max Heap oluşturuluyor (bottom-up approach)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(Dizi, n, i);
        }

        // Heap'ten elemanları çıkararak sıralıyoruz
        for (int i = n - 1; i >= 0; i--) {
            // Kök ile son elemanı takas et
            int temp = Dizi[0];
            Dizi[0] = Dizi[i];
            Dizi[i] = temp;

            // Geri kalan heap'i düzelt
            heapify(Dizi, i, 0);
        }
    }

    public static void main(String args[]) {
        int Dizi[] = {12, 11, 13, 5, 6, 7};
        Heap_Sort hs = new Heap_Sort();
        hs.Diz(Dizi);
        System.out.println("Siralanmis Dizi: " + Arrays.toString(Dizi));
    }
}
