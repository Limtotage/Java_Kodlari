/*Binary Tree, her düğümün en fazla iki alt düğüme sahip olduğu bir ağaç yapısıdır. 
  Düğümlerin sol ve sağ alt düğümleri olmak üzere iki türü vardır.*/
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

public class BinaryTree {
    private Tree_Dugumu Kok;

    public BinaryTree() {
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

    // In-order Gez
    public void Agac_Gez(Tree_Dugumu Dugum) {
        if (Dugum != null) {
            Agac_Gez(Dugum.Sol);
            System.out.print(Dugum.Deger + " ");
            Agac_Gez(Dugum.Sag);
        }
    }

    public static void main(String[] args) {
        BinaryTree Agac = new BinaryTree();
        Agac.Ekle(50);
        Agac.Ekle(30);
        Agac.Ekle(20);
        Agac.Ekle(40);
        Agac.Ekle(70);
        Agac.Ekle(60);
        Agac.Ekle(80);

        System.out.print("Binary Tree In-order Gezildi: ");
        Agac.Agac_Gez(Agac.Kok);
    }
}
