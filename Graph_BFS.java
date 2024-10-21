/*  Bir graf, düğümler (veya köşeler) ve bu düğümleri bağlayan kenarlardan oluşur. 
 Genelde En kısa yol problemlerinde kullanılır (Dijkstra, Bellman-Ford).

 Yönsüz Graf (Undirected Graph): İki düğüm arasındaki kenarlar yönsüzdür,
 yani A düğümünden B düğümüne geçiş varsa, B düğümünden de A düğümüne geçiş vardır.

 Yönlü Graf (Directed Graph): İki düğüm arasındaki kenarlar yönlüdür, yani A düğümünden
 B düğümüne geçiş varsa, bu geçiş B'den A'ya geçişi garanti etmez.

 Komşuluk Matrisi (Adjacency Matrix): Grafın düğümleri arasında bir bağlantı varsa,
 bu matriste 1 olarak gösterilir, yoksa 0 olarak gösterilir. NxN boyutunda bir matristir (N düğüm sayısı).

 Komşuluk Listesi (Adjacency List): Her düğüm için, onunla komşu olan düğümlerin listesi tutulur. 
 Bu yöntem, hafıza açısından daha verimlidir ve grafı daha etkili işler.

 BFS, bir seviyedeki düğümleri ziyaret ettikten sonra bir sonraki seviyeye geçer. */


import java.util.LinkedList;
import java.util.Queue;

class Graph_BFS {
    private int Dugum_Sayisi;
    private LinkedList<Integer>[] Komsuluk_Listesi; 

    public Graph_BFS(int Dugum_Sayisi) {
        this.Dugum_Sayisi = Dugum_Sayisi;
        Komsuluk_Listesi = new LinkedList[Dugum_Sayisi];
        for (int i = 0; i < Dugum_Sayisi; i++) {
            Komsuluk_Listesi[i] = new LinkedList<>();
        }
    }

    // Kenar ekleme
    public void Kenar_Ekle(int Kaynak, int Hedef) {
        Komsuluk_Listesi[Kaynak].add(Hedef);   // Yönlü graf için
        Komsuluk_Listesi[Hedef].add(Kaynak);   // Yönsüz graf için
    }

    // BFS algoritması
    public void bfs(int Bas_Konum) {
        boolean[] Geldimi = new boolean[Dugum_Sayisi];
        Queue<Integer> Kuyruk = new LinkedList<>();

        Geldimi[Bas_Konum] = true;   // Başlangıç düğümü işaretlendi
        Kuyruk.add(Bas_Konum);        // Kuyruğa eklendi

        while (!Kuyruk.isEmpty()) {
            int Mevcut_Konum = Kuyruk.poll();  // Kuyruğun başındaki düğümü çıkar
            System.out.print(Mevcut_Konum + " ");  // Ziyaret edilen düğümü yazdır

            // Komşu düğümleri sıraya ekle
            for (int Konumlar : Komsuluk_Listesi[Mevcut_Konum]) {
                if (!Geldimi[Konumlar]) {
                    Geldimi[Konumlar] = true;  // Komşu düğüm ziyaret edildi
                    Kuyruk.add(Konumlar);       // Kuyruğa eklendi
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph_BFS graph = new Graph_BFS(6);  // 6 düğümlü bir graf oluşturuyoruz

        // Kenarları ekleyelim
        graph.Kenar_Ekle(0, 1);
        graph.Kenar_Ekle(0, 2);
        graph.Kenar_Ekle(1, 3);
        graph.Kenar_Ekle(2, 4);
        graph.Kenar_Ekle(3, 5);
        graph.Kenar_Ekle(4, 5);

        // BFS ile grafı gezelim
        System.out.print("BFS Yontemi ile Graf Gezildi: ");
        graph.bfs(0);  // 0 düğümünden başlayarak BFS yapar
    }
}
