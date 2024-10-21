import java.util.Arrays;
//Dizi içinde iki sayının toplamının belirli bir değere eşit olup olmadığını bulma.
public class TwoPointers {
    public static boolean Esitmi(int[] dizi, int Sonuc) {
        Arrays.sort(dizi); // Diziyi sıralıyoruz
        int sol = 0; // İlk işaretçi
        int sag = dizi.length - 1; // Son işaretçi

        while (sol < sag) {
            int toplam = dizi[sol] + dizi[sag];
            if (toplam == Sonuc) {
                return true; // Toplam bulundu
            } else if (toplam < Sonuc) {
                sol++; // Toplam küçükse, sol işaretçiyi sağa kaydır
            } else {
                sag--; // Toplam büyükse, sağ işaretçiyi sola kaydır
            }
        }
        return false; // Hiçbir çift bulunamadı
    }

    public static void main(String[] args) {
        int[] dizi = {10, 15, 3, 7};
        int sonuc = 17;
        System.out.println(Esitmi(dizi, sonuc)); // Çıktı: true
    }
}
