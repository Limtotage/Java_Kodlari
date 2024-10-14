class Sayac {
    private static int sayac = 0; //static olarak tanımlandığı için tüm sınıflarda tek bir adresi var.

    public Sayac() {
        sayac++; 
    }

    public static int getSayac() {
        return sayac;
    }
}
public class Java_Static_Kavrami {
    public static void main(String[] args) {
        Sayac s1 = new Sayac();
        Sayac s2 = new Sayac();
        Sayac s3 = new Sayac();
        System.out.println("Olusturulan nesne sayisi: " + Sayac.getSayac());
    }
}
