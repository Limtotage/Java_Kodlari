/*Dinamik Programlama (Dynamic Programming), karmaşık problemleri daha küçük alt problemlere
bölerek çözen bir optimizasyon tekniğidir. DP, her alt problemi yalnızca bir kez çözer ve 
sonuçları kaydeder (genellikle bir tablo veya dizi kullanarak), böylece aynı problemi tekrar tekrar çözmekten kaçınır.*/

public class FibonacciDP {
    // Fibonacci sayısını DP ile hesaplayan fonksiyon
    public static int fibonacci(int n) {
        // Fibonacci hesaplaması için tablodaki iki temel durum
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Fibonacci sayıları için DP dizisi
        int[] dp = new int[n + 1];

        // İlk iki Fibonacci sayısını başlangıç olarak ayarla
        dp[0] = 0;
        dp[1] = 1;

        // Tüm Fibonacci sayıları hesapla ve DP dizisine kaydet
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];  // F(n) = F(n-1) + F(n-2)
        }

        return dp[n];  // n. Fibonacci sayısını döndür
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }
}
