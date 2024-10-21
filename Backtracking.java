/*  Backtracking (Geri İzleme), çözüm uzayını bir arama ağacı olarak düşünen
ve çözüm bulmaya çalışırken bazı olasılıkları deneyip, bir adım geriye giderek 
başka bir olasılığı denemeye dayalı bir arama algoritmasıdır. Problemin her 
adımında bir seçim yapılır, eğer bu seçim problemin çözümüne uygun değilse geri 
dönülerek başka seçenekler denenir. Yani "ileri git, olmadıysa geri dön ve başka 
bir yol dene" prensibiyle çalışır.*/

public class NVezir {//N x N boyutundaki bir satranç tahtasına N adet veziri öyle yerleştirmek istiyoruz ki, hiçbir vezir diğerini tehdit edemesin. Yani, aynı satırda, sütunda ya da çaprazda bulunmamalılar.
    private int N;

    public NVezir(int N) {
        this.N = N;
    }

    // Çözümü başlatır
    public void NVezir_Coz() {
        int[] Tahta = new int[N]; // Tahta[i] = j, i. satırda j. sütunda vezir var
        Veziri_Koy(Tahta, 0);
    }

    // Rekürsif olarak vezirleri yerleştirir
    private void Veziri_Koy(int[] Tahta, int Satir) {
        if (Satir == N) {
            Cozumu_Yazdir(Tahta);
            return;
        }

        for (int Sutun = 0; Sutun < N; Sutun++) {
            if (Guvenlimi(Tahta, Satir, Sutun)) {
                Tahta[Satir] = Sutun; // Veziri yerleştir
                Veziri_Koy(Tahta, Satir + 1); // Bir sonraki satıra geç
                // Backtrack: Gerektiğinde bu adımı atlar ve başka bir sütuna vezir yerleştirir
            }
        }
    }

    // Vezirin güvenli olup olmadığını kontrol eder
    private boolean Guvenlimi(int[] Tahta, int Satir, int Sutun) {
        for (int i = 0; i < Satir; i++) {
            // Aynı sütunda vezir var mı kontrolü
            if (Tahta[i] == Sutun) {
                return false;
            }

            // Çaprazda vezir var mı kontrolü
            if (Math.abs(Tahta[i] - Sutun) == Math.abs(i - Satir)) {
                return false;
            }
        }
        return true;
    }

    // Çözümü ekrana yazdırır
    private void Cozumu_Yazdir(int[] Tahta) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Tahta[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 4;
        NVezir Vezirler = new NVezir(N);
        Vezirler.NVezir_Coz();
    }
}
