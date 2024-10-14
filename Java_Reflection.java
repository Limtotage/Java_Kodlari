import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Araba {// Basit bir Sınıf tanımlıyoruz.
    private String model;
    private int yil;
    public Araba(String model, int yil) {
        this.model = model;
        this.yil = yil;
    }

    public String Model_Goster() {
        return model;
    }

    public void Model_Duzenle(String model) {
        this.model = model;
    }

    public int Yili_Goster() {
        return yil;
    }

    public void Yili_Duzenle(int yil) {
        this.yil = yil;
    }

    public void Sur() {
        System.out.println("Araba Suruluyor...");
    }

    private void Gizli_Bilgi() {// Özel bir Metot yazdık. Normalde Erişemeyiz.
        System.out.println("Bu gizli bir bilgi.");
    }
}

public class Java_Reflection {//Reflect ile yapılabilecek şeyler
    public static void main(String[] args) {
        try {
            // 1. Reflection ile Sınıfı Almak
            Class<?> Araba_Sinifi = Class.forName("Araba");// Araba isminde bir sınıf aramasını söyledik ve bunuda araba_Sınıfı değişkenine atadık.

            // 2. Sınıfın adını almak
            System.out.println("Sinif Adi: " + Araba_Sinifi.getName());

            // 3. Sınıfın Yapıcılarını (Constructors) Almak
            Constructor<?>[] Yapicilar = Araba_Sinifi.getConstructors(); 
            for (Constructor<?> Yapici : Yapicilar) {
                System.out.println("Yapici Methodun Verileri: " + Yapici);// Yapıcı değişken tiplerini ekrana veriyor. String,int
            }
            int i =0;
            // 4. Sınıfın Metodlarını Almak
            Method[] Metotlar = Araba_Sinifi.getDeclaredMethods();
            for (Method Metot : Metotlar) {//Metodları çağırarak kaç Metod var ve hangileri public hangileri private öğreniyoruz.
                i++;
                System.out.println(i+". Metot Adi: " + Metot.getName() + ", Metot Belirteci: " + Modifier.toString(Metot.getModifiers()));// Metodları ve Metot tiplerini ekrana veriyor.
            }

            // 5. Sınıfın Alanlarını (Fields) Almak
            Field[] Degerler = Araba_Sinifi.getDeclaredFields();// Sınıfta bulunan değişkenlerin isimlerini ve tiplerini alıyoruz.
            for (Field Deger : Degerler) {
                System.out.println("Deger Adi: " + Deger.getName() + ", Deger Tipi: " + Deger.getType());
            }

            // 6. Yeni Bir Nesne Oluşturmak
            Constructor<?> Yapici = Araba_Sinifi.getConstructor(String.class, int.class);// Öğrendiğimiz verilerle constructor oluşturuyoruz.
            Object Araba_Nesnesi = Yapici.newInstance("Tesla", 2023);// Yeni Bir nesne Oluşturuyoruz. Araba Sınıfını teknik olarak kullanmadan.

            // 7. Nesne Üzerinde Bir Metodu Çağırmak
            Method Sur_Metot = Araba_Sinifi.getMethod("Sur");// Sur isimli methodu Çağırıyoruz.
            Sur_Metot.invoke(Araba_Nesnesi);// Yeni Nesne Üzerinden methodu çalıştırıyoruz.

            // 8. Private Bir Metoda Erişmek
            Method Gizli_Metot = Araba_Sinifi.getDeclaredMethod("Gizli_Bilgi"); // Private methoda erişmek için özel olarak çağırıyoruz. 
            Gizli_Metot.setAccessible(true);  // Private metodu erişilebilir yapıyoruz
            Gizli_Metot.invoke(Araba_Nesnesi);

            // 9. Private Bir Alana Erişmek ve Değer Atamak
            Field Model_Degiskeni = Araba_Sinifi.getDeclaredField("model"); // Nu sefer private değişkene erişiyoruz.
            Model_Degiskeni.setAccessible(true);  // Private alanı erişilebilir yapıyoruz
            Model_Degiskeni.set(Araba_Nesnesi, "BMW");

            // Model alanının güncellenmiş değerini almak
            Method Model_Goster_Metodu = Araba_Sinifi.getMethod("Model_Goster");// Değiştirilmiş olan veriyi kontrol ediyoruz.
            String Yeni_Model = (String) Model_Goster_Metodu.invoke(Araba_Nesnesi);
            System.out.println("Guncellenmis Model: " + Yeni_Model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
