/*  Prefix Sum, bir dizideki belirli bir aralıktaki elemanların toplamını hızlıca hesaplamak için 
kullanılan bir tekniktir. Bu teknik, her bir elemanın, dizinin başlangıcından o elemana kadar olan 
toplamını saklayarak, aralık toplamlarını O(1) zamanda elde etmenizi sağlar. 
Genellikle bu yapı, bir dizi üzerinde sürekli toplam almak için kullanılır.*/

public class PrefixSum {//Bir dizide belirli aralıkların toplamını hesaplama.
    public static int[] PrefixSumHesaplama(int[] Dizi) {
        int[] prefixSum = new int[Dizi.length + 1];
        for (int i = 0; i < Dizi.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + Dizi[i]; // Önceki toplam ile mevcut elemanı topluyoruz
          /*   prefix[1] = prefix[0]+Dizi[0]
              prefix[2] = prefix[1]+Dizi[1]
            ...
            örn : p[1]=0+7
            p[2]=p[1]+f[1] = 7+12 19
            p[3] = 19+5
            ...*/
        }
        return prefixSum;
    }

    public static int Ara_toplami(int[] prefixSum, int Sol, int Sag) {
        return prefixSum[Sag + 1] - prefixSum[Sol]; // Belirli aralığın toplamını hesapla
    }

    public static void main(String[] args) {
        int[] Dizi = {1, 2, 3, 4, 5};
        int[] prefixSum = PrefixSumHesaplama(Dizi);

        // 2. indeksten 4. indise (3 + 4 + 5) toplamı
        System.out.println(Ara_toplami(prefixSum, 2, 4)); // Çıktı: 12
    }
}
