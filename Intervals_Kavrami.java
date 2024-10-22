/*  "Intervals" (aralıklar) genellikle birbirine bağlı zaman dilimlerini 
veya sayısal aralıkları ifade eder. Aralıklar, başlangıç ve bitiş 
değerleriyle tanımlanan sıralı çiftlerdir. Örneğin, [1, 3] aralığı 
1'den başlayıp 3'e kadar olan sayıları temsil eder. */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Aralik {
    int Basi;
    int Son;

    public Aralik(int Basi, int Son) {
        this.Basi = Basi;
        this.Son = Son;
    }

    @Override
    public String toString() {
        return "[" + Basi + ", " + Son + "]";
    }
}

public class Intervals_Kavrami {
    public List<Aralik> Ekle(List<Aralik> Araliklar, Aralik Yeni_Aralik) {//Aralık Eklemek (Insert Aralik) 
        List<Aralik> Sonuc = new ArrayList<>();
        
        for (Aralik arasi : Araliklar) {
            if (arasi.Son < Yeni_Aralik.Basi) {
                Sonuc.add(arasi);
            } else if (arasi.Basi > Yeni_Aralik.Son) {
                Sonuc.add(Yeni_Aralik);
                Yeni_Aralik = arasi;
            } else {
                Yeni_Aralik.Basi = Math.min(Yeni_Aralik.Basi, arasi.Basi);
                Yeni_Aralik.Son = Math.max(Yeni_Aralik.Son, arasi.Son);
            }
        }
        
        Sonuc.add(Yeni_Aralik);
        return Sonuc;
    }
    public List<Aralik> Kesisim_Kontrol(List<Aralik> A, List<Aralik> B) {//Aralıkların Kesişimi (Intersection)
        List<Aralik> Sonuc = new ArrayList<>();
        int i = 0, j = 0;
    
        while (i < A.size() && j < B.size()) {
            int Basi = Math.max(A.get(i).Basi, B.get(j).Basi);
            int Son = Math.min(A.get(i).Son, B.get(j).Son);
    
            if (Basi <= Son) {
                Sonuc.add(new Aralik(Basi, Son));
            }
    
            if (A.get(i).Son < B.get(j).Son) {
                i++;
            } else {
                j++;
            }
        }
    
        return Sonuc;
    }
    
    
    public List<Aralik> Birlestir(List<Aralik> Araliklar) {//
        // Aralıkları başlangıç değerine göre sırala
        Araliklar.sort(Comparator.comparingInt(a -> a.Basi));

        List<Aralik> Birlesmis = new ArrayList<>();

        for (Aralik arasi : Araliklar) {
            // Eğer Birlesmis listesi boşsa veya mevcut aralık öncekiyle kesişmiyorsa
            if (Birlesmis.isEmpty() || Birlesmis.get(Birlesmis.size() - 1).Son < arasi.Basi) {
                Birlesmis.add(arasi);
            } else {
                // Kesişen aralıkları birleştir
                Birlesmis.get(Birlesmis.size() - 1).Son = Math.max(Birlesmis.get(Birlesmis.size() - 1).Son, arasi.Son);
            }
        }

        return Birlesmis;
    }

    public static void main(String[] args) {
        Intervals_Kavrami Cozum = new Intervals_Kavrami();

        List<Aralik> Araliklar = Arrays.asList(
                new Aralik(1, 3),
                new Aralik(2, 6),
                new Aralik(8, 10),
                new Aralik(15, 18)
        );
        List<Aralik> Aralik2 = new ArrayList<>();
        List<Aralik> Aralik3 = new ArrayList<>();
        Aralik2.add(new Aralik(9,13));
        Aralik3.add(new Aralik(0, 19));
        List<Aralik> Sonuc = Cozum.Birlestir(Araliklar);
        List<Aralik> Sonuc2 = Cozum.Kesisim_Kontrol(Aralik2,Aralik3);
        System.out.println("arasi Intersection: " +Sonuc2);
        System.out.println("Merged Araliklar: " + Sonuc);
        System.out.println("Aralik Eklendi."+Cozum.Ekle(Aralik3, new Aralik(13, 25)));
    }
}
