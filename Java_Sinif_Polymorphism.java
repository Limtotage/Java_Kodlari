interface Hayvan { // Arayüzü ve arayüzden olacak methodları tanımlıyoruz.
    void sesCikar();
    void hareketEt();
    void nasilsin();
}
class Kedi implements Hayvan {// Kedi sınıfının hayvan arayüzünün kullandığını belirtiyoruz.
    private String isim;

    public Kedi(String isim) {
        this.isim = isim;
    }

    @Override
    public void sesCikar() {// Kediye ait arayüz fonksiyonlarını yazıyoruz.
        System.out.println(isim + " Miyavliyor.");
    }

    @Override
    public void hareketEt() {
        System.out.println(isim + " Yavas Kosuyor.");
    }

    @Override
    public void nasilsin() {
        System.out.println(isim+" Sag Arka ayaginda yara var.");
    }
}
class Kopek implements Hayvan {// Köpek sınıfının hayvan arayüzünün kullandığını belirtiyoruz.
    private String isim;

    public Kopek(String isim) {
        this.isim = isim;
    }

    @Override
    public void sesCikar() {// Köpeğe ait arayüz fonksiyonlarını yazıyoruz.
        System.out.println(isim + " Havliyor.");
    }

    @Override
    public void hareketEt() {
        System.out.println(isim + " Hizli Kosuyor.");
    }

    @Override
    public void nasilsin() {
        System.out.println(isim+" Gayet Saglikli");
    }
}
public class Java_Sinif_Polymorphism {
    public static void main(String[] args) {
        Hayvan[] hayvanlar = new Hayvan[2];// Hayvanlar Oluşturuluyor.

        hayvanlar[0] = new Kedi("Mavis");
        hayvanlar[1] = new Kopek("KaraBas");

        for (Hayvan hayvan : hayvanlar) {
            hayvan.sesCikar();
            hayvan.hareketEt();
            hayvan.nasilsin();
        }
    }
}