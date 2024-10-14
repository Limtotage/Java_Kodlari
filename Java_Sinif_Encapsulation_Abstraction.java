// Encapsulation, abstravtion ve polymorphism Hakkında Örnek
abstract class Banka_Hesabi {// Banka Hesabı soyut sınıfı ve methodları oluşturulur.                       
    private String hesapNo;
    private double bakiye;

    public Banka_Hesabi(String hesapNo, double bakiye) {
        this.hesapNo = hesapNo;
        this.bakiye = bakiye;
    }

    public String Hesap_No_Goster() {
        return hesapNo;
    }

    public double Bakiyeyi_Goster() {
        return bakiye;
    }
    public void Bakiyeyi_Guncelle(double miktar) {// Parentın sahip olduğu Fonksiyonlar.
        this.bakiye=miktar;
    }

    public abstract void Para_Yatir(double miktar);// Childın Doldurması Gereken Fonksiyonlar
    public abstract void Para_Cek(double miktar);
}

class Vadesiz_Hesap extends Banka_Hesabi {// Vadesiz Hesap Childtır.

    public Vadesiz_Hesap(String hesapNo, double bakiye) {// Kurulum fonksiyonu
        super(hesapNo, bakiye);
    }

    @Override
    public void Para_Yatir(double miktar) {// Para Yatırma Fonksiyonu
        if (miktar > 0) {// Miktar sıfırdan büyük olduğu sürece para hesaba yatar.
            double yeniBakiye = Bakiyeyi_Goster() + miktar;
            System.out.println(miktar + " TL Yatirildi.");
            Bakiyeyi_Guncelle(yeniBakiye);// Bakiye Guncellemesi
            System.out.println("Yeni bakiyeniz: " + Bakiyeyi_Goster() + " TL.");
        } else {
            System.out.println("Para Tespit Edilememistir. Lutfen Para Yatirip Tekrar Deneyiniz!");
        }
    }

    @Override
    public void Para_Cek(double miktar) {// Para Çekme Fonksiyonu
        if (miktar > 0 && miktar <= Bakiyeyi_Goster()) {// Miktar sıfırdan büyük, Bakiyeden Küçük olduğu sürece para hesabtan Çekilir.
            double yeniBakiye = Bakiyeyi_Goster() - miktar; 
            System.out.println(miktar + " TL cekildi.");
            Bakiyeyi_Guncelle(yeniBakiye); // Bakiye Guncellenir.
            System.out.println("Kalan bakiyeniz: " + Bakiyeyi_Goster() + " TL.");
        } else if(miktar<=0) { // Miktar sıfıra eşit ya da küçükse burası çalışır.
            System.out.println("Istenilen miktar gecersizdir. Lutfen Tekrar Deneyiniz. veya bakiye yetersiz.");
        }else{// Bakiye Aşılmışsa burası çalışır.
            System.out.println("Hesabinizda "+miktar +" TL Yoktur. Bakineyiz Yetersizdir.");
        }
    }
}
public class Java_Sinif_Encapsulation_Abstraction {
    public static void main(String[] args) {
        Vadesiz_Hesap hesap = new Vadesiz_Hesap("123456", 1000.0);

        hesap.Para_Yatir(200.0);
        hesap.Para_Cek(150.0);  
        hesap.Para_Cek(1200.0);  
    }
}


