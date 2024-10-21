// DFS, önce bir yolu sonuna kadar takip eder, ardından geri dönerek diğer yolları keşfeder.
import java.util.LinkedList;
class Graph_DFS {
    private int Dugum_Sayisi;          
    private LinkedList<Integer>[] Komsuluk_Listesi;

    public Graph_DFS(int Dugum_Sayisi) {
        this.Dugum_Sayisi = Dugum_Sayisi;
        Komsuluk_Listesi = new LinkedList[Dugum_Sayisi];
        for (int i = 0; i < Dugum_Sayisi; i++) {
            Komsuluk_Listesi[i] = new LinkedList<>();
        }
    }

    public void Kenar_Ekle(int Kaynak, int Hedef) {
        Komsuluk_Listesi[Kaynak].add(Hedef);   
        Komsuluk_Listesi[Hedef].add(Kaynak);   
    }

    // DFS algoritması
    public void DFS(int Konum_Bas) {
        boolean[] Geldimi = new boolean[Dugum_Sayisi];
        DFS_Recursive(Konum_Bas, Geldimi);
    }

    // DFS için rekürsif fonksiyon
    private void DFS_Recursive(int Konum_Mevcut, boolean[] Geldimi) {
        Geldimi[Konum_Mevcut] = true;  // Düğüm ziyaret edildi
        System.out.print(Konum_Mevcut + " ");  // Ziyaret edilen düğümü yazdır

        for (int Konumlar : Komsuluk_Listesi[Konum_Mevcut]) {
            if (!Geldimi[Konumlar]) {
                DFS_Recursive(Konumlar, Geldimi);  // Komşu düğümler için rekürsif olarak devam et
            }
        }
    }

    public static void main(String[] args) {
        Graph_DFS graph = new Graph_DFS(6);

        graph.Kenar_Ekle(0, 1);
        graph.Kenar_Ekle(0, 2);
        graph.Kenar_Ekle(1, 3);
        graph.Kenar_Ekle(2, 4);
        graph.Kenar_Ekle(3, 5);
        graph.Kenar_Ekle(5, 2);

        

        System.out.print("DFS yontemiyle graph Gezildi: ");
        graph.DFS(0);  // 0 düğümünden başlayarak DFS yapar
    }
}
