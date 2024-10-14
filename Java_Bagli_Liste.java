class Dugum {                                        //Bağlı Liste için Düğüm Nesnesi Oluşturulur.
    int Veri; 
    Dugum Sonraki; 

    public Dugum(int Veri) {
        this.Veri = Veri;
        this.Sonraki = null;
    }
}

class Bagli_Liste {                                  //Düğüm Nesnesini içerisinde barındıran Bağlı Liste Nesnesi Oluşturulur.
    Dugum Bas; 

    public void Ekle(int Veri) {                     //Düğüm Eklemeyi Sağlayan Method
        Dugum Yeni_Dugum = new Dugum(Veri);
        if (Bas == null) {
            Bas = Yeni_Dugum; 
        } else {
            Dugum Simdiki = Bas;
            while (Simdiki.Sonraki != null) {
                Simdiki = Simdiki.Sonraki; 
            }
            Simdiki.Sonraki = Yeni_Dugum; 
        }
    }
    public boolean Bul(int Veri) {                  //Düğüm Aramayı Sağlayan Method
        Dugum Simdiki = Bas;
        int i = 1;
        while (Simdiki != null) {
            if (Simdiki.Veri == Veri) {
                System.out.println("Aranan Veri "+i+". sirada bulundu.");
                return true; 
            }
            i++;
            Simdiki = Simdiki.Sonraki;
        }
        return false; 
    }

    public void Listeyi_Yazdir() {                   //Bağlı Listeyi Yazdıran Method
        Dugum Simdiki = Bas; 
        while (Simdiki != null) {
            System.out.println(Simdiki.Veri ); 
            Simdiki = Simdiki.Sonraki; 
        }
    }
    public void Listeyi_Bosalt() {                   // Listeyi Boşaltan Method
        Dugum  Simdiki = Bas;
        while (Simdiki != null) {
            Dugum Sonraki_Dugum = Simdiki.Sonraki;
            Simdiki = null; 
            Simdiki = Sonraki_Dugum;
        }
        Bas = null;  
        System.out.println("Liste Temizlendi.");
    }
    public boolean Eleman_Sil(int Veri){             // Listeden Bir Eleman Silen Method
        Dugum Simdiki = Bas;
        Dugum Onceki =Bas;
        int i = 1;
        while (Simdiki != null) {
            if (Simdiki.Veri == Veri) {
                Dugum Sonraki_Dugum=Simdiki.Sonraki;
                Simdiki=null;
                Onceki.Sonraki=Sonraki_Dugum;
                if(i==1) Bas=Sonraki_Dugum;
                return true;
            }
            i++;
            if(i!=1) Onceki =Simdiki;
            Simdiki = Simdiki.Sonraki;
        }
        return false;
    }
}
public class Java_Bagli_Liste {
    public static void main(String[] args) {
        Bagli_Liste Listem = new Bagli_Liste();       // Liste Oluşturulur.
        Listem.Ekle(10);
        Listem.Ekle(20);
        Listem.Ekle(30);
        Listem.Ekle(40);                            
        int arananDeger = 30;
        int silenecekdeger =40;

        Listem.Listeyi_Yazdir();                      // Bağlı listeyi yazdır

        if (Listem.Bul(arananDeger)) {
            System.out.println(arananDeger+" Listede bulundu.");
        } else {
            System.out.println(arananDeger+" Listede bulunamadi.");
        }
        if (Listem.Eleman_Sil(silenecekdeger)) {
            System.out.println(silenecekdeger+" Listeden Silindi.");} 
        else {
            System.out.println(silenecekdeger+" Zaten Listede Yok.");} 
    }
}


