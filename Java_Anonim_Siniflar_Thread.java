public class Java_Anonim_Siniflar_Thread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {// Bir Runnable arayüzü kullandık ve run fonksiyonuna tek seferkik bir kod yazdık.
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {//Çok basit Bir thread uyku düzeni yazdık.
                    System.out.println("Yeni Thread calisiyor: " + i);
                    try {
                        Thread.sleep(1000); // 1 saniye bekleme
                    } catch (InterruptedException hata) {
                        hata.printStackTrace();
                    }
                }
            }
        });

        thread.start(); // Oluşturduğumuz Thread'i Çalıştırdık.
        for (int i = 1; i <= 5; i++) {//main threadi yarım saniye uyutmaya çalışıyoruz. Bu sayede main threadin oluşturduğumuz threadden ayrı çalıştığını gösteriyoruz.
            System.out.println("Main Thread: " + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException hata) {
                hata.printStackTrace();
            }
        }
    }
}
