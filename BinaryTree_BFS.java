/* Breadth-First Search (BFS) algoritması, bir ağacın veya grafiğin genişliğine göre keşfedilmesini sağlar. 
BFS, bir seviyedeki düğümleri ziyaret ettikten sonra bir sonraki seviyeye geçer. Bu işlem genellikle 
bir kuyruk (Kuyruk) kullanılarak gerçekleştirilir, çünkü BFS her bir seviyeyi sırayla dolaşır.*/
import java.util.LinkedList;
import java.util.Queue;

class Tree_Dugumu {
    int Deger;
    Tree_Dugumu Sol;
    Tree_Dugumu Sag;

    Tree_Dugumu(int Deger) {
        this.Deger = Deger;
        this.Sol = null;
        this.Sag = null;
    }
}

public class BinaryTree_BFS {

    private Tree_Dugumu Kok;

    public BinaryTree_BFS() {
        Kok = null;
    }

    // Eleman ekleme metodu
    public void Ekle(int Deger) {
        Kok = Ekle_Recursive(Kok, Deger);
    }

    private Tree_Dugumu Ekle_Recursive(Tree_Dugumu Dugum, int Deger) {
        // Eğer duğum bossa, yeni bir duğum olustur
        if (Dugum == null) {
            return new Tree_Dugumu(Deger);
        }

        // Değer, mevcut duğum değerinden daha kucukse sol alt duğume ekle
        if (Deger < Dugum.Deger) {
            Dugum.Sol = Ekle_Recursive(Dugum.Sol, Deger);
        } // Değer, mevcut duğum değerinden daha buyukse sağ alt duğume ekle
        else if (Deger > Dugum.Deger) {
            Dugum.Sag = Ekle_Recursive(Dugum.Sag, Deger);
        }

        // Değeri zaten mevcutsa hicbir sey yapma
        return Dugum;
    }

    public void BFS_Gezi() {
        if (Kok == null) {
            return;
        }

        Queue<Tree_Dugumu> Kuyruk = new LinkedList<>();
        Kuyruk.add(Kok);

        while (!Kuyruk.isEmpty()) {
            Tree_Dugumu Simdiki_Dugum = Kuyruk.poll(); // Kuyruğun başından eleman al
            System.out.print(Simdiki_Dugum.Deger + " "); // Düğümü yazdır

            // Sol alt düğüm varsa kuyruğa ekle
            if (Simdiki_Dugum.Sol != null) {
                Kuyruk.add(Simdiki_Dugum.Sol);
            }

            // Sağ alt düğüm varsa kuyruğa ekle
            if (Simdiki_Dugum.Sag != null) {
                Kuyruk.add(Simdiki_Dugum.Sag);
            }
        }
    }
    public static void main(String[] args) {
        BinaryTree_BFS Agac = new BinaryTree_BFS();
        Agac.Ekle(50);
        Agac.Ekle(30);
        Agac.Ekle(20);
        Agac.Ekle(40);
        Agac.Ekle(70);
        Agac.Ekle(60);
        Agac.Ekle(80);

        System.out.print("Binary Tree BFS Yontemiyle Gezildi: ");
        Agac.BFS_Gezi();
    }
}
