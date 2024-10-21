/*  Depth-First Search (DFS)
DFS, bir ağacın veya grafiğin derinliğine inerek keşfedilmesini sağlayan bir algoritmadır. Bu algoritma, üç temel gezinti yöntemi ile uygulanabilir:

Pre-order: Düğümün kendisini ziyaret et, sol alt ağacı ziyaret et, sağ alt ağacı ziyaret et.
In-order: Sol alt ağacı ziyaret et, düğümü ziyaret et, sağ alt ağacı ziyaret et.
Post-order: Sol alt ağacı ziyaret et, sağ alt ağacı ziyaret et, düğümü ziyaret et.
DFS algoritması, genellikle rekürsif (özyinelemeli) bir yapıda gerçekleştirilir.  */
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

public class BinaryTree_DFS {
    private Tree_Dugumu Kok;

    public BinaryTree_DFS() {
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
        }
          // Değer, mevcut duğum değerinden daha buyukse sağ alt duğume ekle
        else if (Deger > Dugum.Deger) {
            Dugum.Sag = Ekle_Recursive(Dugum.Sag, Deger);
        }
      // Değeri zaten mevcutsa hicbir sey yapma
        return Dugum;
    }

    // Pre-order Gez
    public void preOrder(Tree_Dugumu Dugum) {
        if (Dugum != null) {
            System.out.print(Dugum.Deger + " ");  // Düğümü ziyaret et
            preOrder(Dugum.Sol);                  // Sol alt ağacı ziyaret et
            preOrder(Dugum.Sag);                 // Sağ alt ağacı ziyaret et
        }
    }

    // In-order Gez
    public void inOrder(Tree_Dugumu Dugum) {
        if (Dugum != null) {
            inOrder(Dugum.Sol);                   // Sol alt ağacı ziyaret et
            System.out.print(Dugum.Deger + " ");   // Düğümü ziyaret et
            inOrder(Dugum.Sag);                  // Sağ alt ağacı ziyaret et
        }
    }

    // Post-order Gez
    public void postOrder(Tree_Dugumu Dugum) {
        if (Dugum != null) {
            postOrder(Dugum.Sol);                 // Sol alt ağacı ziyaret et
            postOrder(Dugum.Sag);                // Sağ alt ağacı ziyaret et
            System.out.print(Dugum.Deger + " ");   // Düğümü ziyaret et
        }
    }

    public static void main(String[] args) {
        BinaryTree_DFS Agac = new BinaryTree_DFS();
        Agac.Ekle(50);
        Agac.Ekle(30);
        Agac.Ekle(20);
        Agac.Ekle(40);
        Agac.Ekle(70);
        Agac.Ekle(60);
        Agac.Ekle(80);

        System.out.print("Binary Tree Pre-order Gezildi:");
        Agac.preOrder(Agac.Kok);
        System.out.println();

        System.out.print("Binary Tree In-order Gezildi:");
        Agac.inOrder(Agac.Kok);
        System.out.println();

        System.out.print("Binary Tree Post-order Gezildi: ");
        Agac.postOrder(Agac.Kok);
    }
}
