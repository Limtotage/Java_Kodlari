class Canli { // T:Tip V:Deger K:Anahtar E:Eleman Generic Kodlarının kullanım örneği
    public void nefesAl() {//Canli Parent Class'ı
        System.out.println("Canli nefes aliyor...");
    }
}

class Insan extends Canli {// İnsan Canlinin alt sınıfıdır.
    private String isim;

    public Insan(String isim) {
        this.isim = isim;
    }

    public String Isim_Goster() {
        return isim;
    }

    public void konus() {
        System.out.println(isim + " konusuyor...");
    }
}

class Cift_Ozellikli_Sinif<K extends Canli, V extends Number> {//Hem Canli sınıfının Hem de Number sınıfının özelliklerini miras alıyor. K: Key'dir. V:  değer'dir
    private K anahtar; // Anahtar değişkeni canli sınıfının özelliklerini gösterebilir.
    private V deger;// Deger değişkeni Float, double, int olabilir.

    public Cift_Ozellikli_Sinif(K anahtar, V deger) {
        this.anahtar = anahtar;
        this.deger = deger;
    }

    public K Anahtar_Goster() {
        return anahtar;
    }

    public V Deger_Goster() {
        return deger;
    }

   
    public void Nefes_Al() {
        anahtar.nefesAl(); // Canli sinifinin alt sinifi oldugu için erisimi var.
    }
}

class Kutuphane {
    public static <T extends Insan, E extends Number> void yazdir(T eleman, E yas) { // eleman değişkeni bir insandır
        System.out.println(eleman.Isim_Goster() + " " + yas + " yasinda."); //yas degeri Number sinifinin alt sinifi oldugu icin sadece sayi degerleri alabilir.
        eleman.konus(); //Canli sinifinin alt sinifi oldugu için erisimi var. 
    }
}

public class Java_Generic_Siniflar {
    public static void main(String[] args) {
        // Insan sinifindan bir nesne olustur
        Insan insan1 = new Insan("Ali");

        Cift_Ozellikli_Sinif<Insan, Integer> Cift_Ozellikli_Sinifim = new Cift_Ozellikli_Sinif<>(insan1, 25);

        Cift_Ozellikli_Sinifim.Nefes_Al();

        Kutuphane.yazdir(insan1, 25);

        Cift_Ozellikli_Sinif<Insan, Double> Cift_Ozellikli_Sinifim_ikinci = new Cift_Ozellikli_Sinif<>(new Insan("Ayse"), 30.1);
        Cift_Ozellikli_Sinifim_ikinci.Nefes_Al();
        System.out.println("Anahtar: " + Cift_Ozellikli_Sinifim_ikinci.Anahtar_Goster().Isim_Goster() + ", Değer: " + Cift_Ozellikli_Sinifim_ikinci.Deger_Goster());
    }
}
