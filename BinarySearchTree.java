/* Binary Search Tree (BST), belirli kurallara göre düzenlenmiş bir Binary Tree türüdür. 
Bu kurallar, her düğüm için:
Sol alt ağaçtaki tüm düğümlerin değerleri, kök düğümün değerinden küçük olmalıdır.
Sağ alt ağaçtaki tüm düğümlerin değerleri, kök düğümün değerinden büyük olmalıdır.
Bu kurallar her düğüm için geçerlidir; yani, tüm alt ağaçlar da birer BST olmalıdır.
BST'ler, özellikle arama, ekleme ve silme işlemlerinde verimlilik sağlarlar. 
Ortalama durumda, bu işlemler O(log n) zaman karmaşıklığına sahiptir. */
class Agac_Dugum {
    int Deger;
    Agac_Dugum Sol, Sag;

    public Agac_Dugum(int Deger) {
        this.Deger = Deger;
        Sol = Sag = null;
    }
}

public class BinarySearchTree {
    Agac_Dugum Kok;

    // Constructor
    public BinarySearchTree() {
        Kok = null;
    }

    // Eleman ekleme metodu
    public void Ekle(int Deger) {
        Kok = Dugum_Recursive(Kok, Deger);
    }

    private Agac_Dugum Dugum_Recursive(Agac_Dugum Dugum, int Deger) {
        // Eğer düğüm boşsa, yeni düğüm oluştur
        if (Dugum == null) {
            Dugum = new Agac_Dugum(Deger);
            return Dugum;
        }

        // Değere göre düğümü uygun konuma ekle
        if (Deger < Dugum.Deger) {
            Dugum.Sol = Dugum_Recursive(Dugum.Sol, Deger);
        } else if (Deger > Dugum.Deger) {
            Dugum.Sag = Dugum_Recursive(Dugum.Sag, Deger);
        }

        return Dugum;
    }

    // Arama metodu
    public boolean Ara(int Deger) {
        return Ara_Recursive(Kok, Deger);
    }

    private boolean Ara_Recursive(Agac_Dugum Dugum, int Deger) {
        if (Dugum == null) {
            return false;  // Değer bulunamadı
        }

        if (Dugum.Deger == Deger) {
            return true;  // Değer bulundu
        }

        // Değer, düğümün değerinden küçükse sol alt ağaçta ara
        if (Deger < Dugum.Deger) {
            return Ara_Recursive(Dugum.Sol, Deger);
        }

        // Değer, düğümün değerinden büyükse sağ alt ağaçta ara
        return Ara_Recursive(Dugum.Sag, Deger);
    }

    // In-order traversal (BST'de sıralı yazdırma)
    public void inOrder_Siralama() {
        inOrder_Recursive(Kok);
    }

    private void inOrder_Recursive(Agac_Dugum Dugum) {
        if (Dugum != null) {
            inOrder_Recursive(Dugum.Sol);
            System.out.print(Dugum.Deger + " ");
            inOrder_Recursive(Dugum.Sag);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree Agac = new BinarySearchTree();

        // Elemanları ekleyelim
        Agac.Ekle(50);
        Agac.Ekle(30);
        Agac.Ekle(20);
        Agac.Ekle(40);
        Agac.Ekle(70);
        Agac.Ekle(60);
        Agac.Ekle(80);

        // BST'nin sıralı bir şekilde yazdırılması
        System.out.print("Binary Search Tree In-order Gezildi: ");
        Agac.inOrder_Siralama();  // Çıktı: 20 30 40 50 60 70 80

        // Arama işlemi
        System.out.println("\nArama Sonucu (60): " + Agac.Ara(60));  // true
        System.out.println("Arama Sonucu (25): " + Agac.Ara(25));  // false
    }
}
