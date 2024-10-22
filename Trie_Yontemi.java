/*Trie, özellikle kelime ve dize arama işlemlerinde kullanılan, 
verimli bir veri yapısıdır. Kelimeleri depolamak ve aramak için 
optimize edilmiştir ve genellikle kelime tamamlama, otomatik düzeltme 
ve arama önerileri gibi uygulamalarda kullanılır. Trie, kelimelerin
 ortak ön eklerini paylaşarak belleği verimli kullanır.
 Örn: Hell eklenecek 26 uzunlukta harf dizisinden H bulunur ve eklenir.
 Sonra H harfinin bulunduğu indexe 26 uzunlukta çocuk eklenir.
 çocuklara E indexinin bulunduğu yere 26 harflik çocuk eklenir... */

class Trie_Dugum {
    Trie_Dugum[] Cocuk; // Alt düğümleri temsil eden dizi
    boolean Kelimenin_Sonumu; // Kelimenin sonunu belirtir

    public Trie_Dugum() {
        Cocuk = new Trie_Dugum[26]; // İngilizce alfabesi için 26 harf
        Kelimenin_Sonumu = false;
    }
}

class Trie {
    private Trie_Dugum Kok;

    public Trie() {
        Kok = new Trie_Dugum(); // Kök düğümü oluştur
    }

    // Kelime ekleme
    public void Ekle(String Kelime) {
        Trie_Dugum Simdiki = Kok;
        for (char c : Kelime.toCharArray()) {
            int index = c - 'a'; // Harfin dizinini hesapla
            if (Simdiki.Cocuk[index] == null) {
                Simdiki.Cocuk[index] = new Trie_Dugum(); // Yeni düğüm oluştur
            }
            Simdiki = Simdiki.Cocuk[index]; // Mevcut düğümü güncelle
        }
        Simdiki.Kelimenin_Sonumu = true; // Kelimenin sonunu işaretle
    }

    // Kelime arama
    public boolean Ara(String Kelime) {
        Trie_Dugum Simdiki = Kok;
        for (char c : Kelime.toCharArray()) {
            int index = c - 'a'; // Harfin dizinini hesapla
            if (Simdiki.Cocuk[index] == null) {
                return false; // Kelime bulunamadı
            }
            Simdiki = Simdiki.Cocuk[index]; // Mevcut düğümü güncelle
        }
        return Simdiki.Kelimenin_Sonumu; // Kelimenin sonu mu?
    }

    // Ön ek arama
    public boolean Basinda_Varmi(String On_Ek) {
        Trie_Dugum Simdiki = Kok;
        for (char c : On_Ek.toCharArray()) {
            int index = c - 'a'; // Harfin dizinini hesapla
            if (Simdiki.Cocuk[index] == null) {
                return false; // Ön ek bulunamadı
            }
            Simdiki = Simdiki.Cocuk[index]; // Mevcut düğümü güncelle
        }
        return true; // Ön ek var
    }
}
public class Trie_Yontemi {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Kelimeleri ekleme
        trie.Ekle("hello");
        trie.Ekle("hell");
        trie.Ekle("heaven");
        trie.Ekle("goodbye");

        // Kelime arama
        System.out.println(trie.Ara("hello")); // true
        System.out.println(trie.Ara("hell")); // true
        System.out.println(trie.Ara("heavens")); // false
        System.out.println(trie.Ara("good")); // false

        // Ön ek arama
        System.out.println(trie.Basinda_Varmi("he")); // true
        System.out.println(trie.Basinda_Varmi("good")); // true
        System.out.println(trie.Basinda_Varmi("hi")); // false
    }
}

