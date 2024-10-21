/*  Performansı artırmak, bellek tasarrufu sağlamak ve çeşitli algoritmalarda daha etkili
çözümler sunmak için bit düzeyinde işlemler kullanılır. Bit manipülasyonu, bilgisayarlarda 
verilerin ikili (binary) biçimde temsil edilmesi üzerine yapılan işlemlerdir. Bu işlemler,
bit düzeyinde yapılır ve genellikle performans açısından etkili çözümler sağlar.
Bit manipülasyonu, özellikle düşük seviyeli programlama, veri sıkıştırma, kriptografi
ve algoritma optimizasyonları gibi alanlarda yaygın olarak kullanılır.*/

public class BitManipulation {
    public static void main(String[] args) {
        int Numara = 29; // Binary: 11101

        System.out.println("Orjinal Numara: " + Numara);
        
        // 1. Bit Kaydırma (Shifting) 2'ye çarpma ya da bölme
        int Sola_Kay = Numara << 2; // 29 * 2^2 = 116 (Binary: 1110100)
        int Saga_Kay = Numara >> 2; // 29 / 2^2 = 7 (Binary: 111)

        System.out.println("Sola Kaymis (Numara << 2): " + Sola_Kay);
        System.out.println("Saga Kaymis (Numara >> 2): " + Saga_Kay);

        // 2. Bit Maskeleme (Masking) Belirli bitleri kontrol etmek veya elde etmek için kullanılır. 
        int Maske = 1 << 3; // 8 (Binary: 1000)
        int Maskelenmis_Deger = Numara & Maske; // Numara ile Maske'ın AND işlemi

        System.out.println("Maskelenmis Deger (Numara & Maske): " + Maskelenmis_Deger);

        // 3. Bit Ayarlama (Set Bit)
        int Bit_pozisyonu = 1; // 2. bit
        int Bit_Atama_Sonuc = Numara | (1 << Bit_pozisyonu); // 29 | (1 << 1)

        System.out.println("Atanmis Bit  (2. Bit): " + Bit_Atama_Sonuc); // 31 (Binary: 11111)

        // 4. Bit Sıfırlama (Clear Bit)
        int Bit_pozisyonu = 3; // 3. bit
        int Bit_Silme_Sonuc = Numara & ~(1 << Bit_pozisyonu); // 29 & ~(1 << 3)

        System.out.println("Silinmis Bit (3. bit): " + Bit_Silme_Sonuc); // 21 (Binary: 10101)

        // 5. Bit Ters Çevirme (Toggle Bit)
        int Bit_pozisyonu = 2; // 2. bit
        int Bit_Degis_Sonuc = Numara ^ (1 << Bit_pozisyonu); // 29 ^ (1 << 2)

        System.out.println("Degistirilmis Bit (2.bit): " + Bit_Degis_Sonuc); // 25 (Binary: 11001)

        // 6. Bit Kontrolü
        int Bit_pozisyonu = 4; // 4. bit
        boolean Atanmis_mi = (Numara & (1 << Bit_pozisyonu)) != 0;

        System.out.println("4. Bit Atanmis mi? " + Atanmis_mi); // true
    }
}

