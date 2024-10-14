abstract class Hayvan { // Soyut Sınıflar En Az 1 Tane Soyut Methoda sahip olmalıdır.
    public abstract void Ses_Cikar(); // Soyut Method
    public abstract void Tehlikeli_mi();

    public void Uyku() {
        System.out.println("Hayvan uyuyor.");
    }
}
class Kedi extends Hayvan { // Kedi Sınıfı Oluşturuluyor ve Soyut Sınıfın child'ı Oluyor.
    private String isim;

    public Kedi(String isim) {
        this.isim = isim;
    }

    @Override
    public void Ses_Cikar() {
        System.out.println(isim + " Miyavliyor.");
    }

    @Override
    public void Tehlikeli_mi() {
        System.out.println("Turuncu Olmadigi Surece Sikinti Yok.");
    }
}
class Inek extends Hayvan {// İnek Sınıfı Oluşturuluyor ve Soyut Sınıfın child'ı Oluyor.
    private String isim;

    public Inek(String isim) {
        this.isim = isim;
    }

    @Override
    public void Ses_Cikar() {
        System.out.println(isim + " Mooluyor.");
    }

    @Override
    public void Tehlikeli_mi() {
        System.out.println("Kizdirilirsa Cifte Atabilir. Dikkatli Yaklasin!");
    }
}
public class Java_Sinif_Abstract {
    public static void main(String[] args) {
        Hayvan[] hayvanlar = new Hayvan[2];

        hayvanlar[0] = new Kedi("Cimcime");
        hayvanlar[1] = new Inek("SariKiz");

        for (Hayvan hayvan : hayvanlar) {
            hayvan.Ses_Cikar();
            hayvan.Uyku(); 
            hayvan.Tehlikeli_mi();    
        }
    }
}


