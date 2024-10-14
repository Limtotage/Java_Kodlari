
import java.util.Scanner;

public class Java_Yas_sormaca {

    public static void main(String[] args) {
        Scanner Tarayici = new Scanner(System.in);
        System.out.println("Bir sayi girin:"); //Kullanıcadan Aldığı veriyi if - else if - else yapısıyla sınıflandırır.
        try {
            int yas = Tarayici.nextInt();
            if (yas <= 3) {
                System.out.println("Bebek.");
            } else if (yas > 3 && yas <= 18) {
                System.out.println("Cocuk.");
            } else if (yas > 18 && yas <= 30) {
                System.out.println("Genc.");
            } else if (yas > 30 && yas <= 40) {
                System.out.println("Orta Yasli.");
            } else if (yas > 40 && yas <= 65) {
                System.out.println("Yasli.");
            } else {
                System.out.println("Iyice Yaslandi.");
            }

        } catch (Exception e) {
            System.out.println(e +"\nBir Sayi Girmeliydiniz.");
        }
        Tarayici.close();
    }
}
