enum Gun {// Enum sınıf tipini kullanarak haftanın günlerini gün tipini gün aktivitesini oluşturuyoruz.
    PAZARTESI("Hafta Ici", "Toplanti yap","Bacak Gunu"),
    SALI("Hafta Ici", "Kod yaz","Kol Gunu"),
    CARSI("Hafta Ici", "Test et","Gogus Gunu"),
    PERSEMBE("Hafta Ici", "Dokumantasyon","Bugun Spor Yok, Dinlen."),
    CUMA("Hafta Ici", "Kod gozden gecirme","Karin Gunu"),
    CUMARTESI("Hafta sonu", "Dinlenme","Basketbol Maci Gunu"),
    PAZAR("Hafta sonu", "Aile ziyareti","Bugun Spor Yok, Dinlen.");

    private String gunTipi; 
    private String etkinlik;
    private String Spor;

    Gun(String gunTipi, String etkinlik,String Spor) {// enum tanımlar değiştirilemez. kolaylık sağlamak amacıyla kullanılır.
        this.gunTipi = gunTipi;
        this.etkinlik = etkinlik;
        this.Spor=Spor;
    }
    public String GunTipini_Goster() {
        return gunTipi;
    }

    public String Etkinligi_Goster() {
        return etkinlik;
    }
    public String Sporu_Goster() {
        return Spor;
    }
}
public class Java_Enum {
    public static void main(String[] args) {
        for (Gun gunler : Gun.values()) {//Gunleri Ekrana Basıyor.
            System.out.println(gunler + ": " + gunler.GunTipini_Goster() + ", Etkinlik: " + gunler.Etkinligi_Goster()+", Spor Aktivitesi: "+gunler.Sporu_Goster());
        }
    }
}

