public class DP_MultiDimensions {
  /*Bu problemde, bir 2D matrisin sol üst köşesinden başlayarak sağ alt köşesine gitmek istiyoruz.
  Her hücrede bir sayı var ve her adımda sağa veya aşağıya doğru hareket edebiliriz. 
  Hedefimiz, bu hücrelerden geçerken toplayacağımız sayıların toplamını en küçük olacak şekilde seçmek.*/
    public static int MinYol_Problemi_Top(int[][] Cerceve) {
        int Satirlar = Cerceve.length;
        int Sutunlar = Cerceve[0].length;

        // DP tablosunu oluştur
        int[][] dp = new int[Satirlar][Sutunlar];

        // İlk hücreye Cerceve'in ilk değeri atanır
        dp[0][0] = Cerceve[0][0];

        // İlk satırı doldur
        for (int i = 1; i < Sutunlar; i++) {
            dp[0][i] = dp[0][i - 1] + Cerceve[0][i];
        }

        // İlk sütunu doldur
        for (int i = 1; i < Satirlar; i++) {
            dp[i][0] = dp[i - 1][0] + Cerceve[i][0];
        }

        // Diğer hücreleri doldur
        for (int i = 1; i < Satirlar; i++) {
            for (int j = 1; j < Sutunlar; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + Cerceve[i][j];
            }
        }

        // Sağ alt köşedeki değer, minimum toplam maliyeti verir
        return dp[Satirlar - 1][Sutunlar - 1];
    }

    public static void main(String[] args) {
        int[][] Cerceve = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        int Cozum = MinYol_Problemi_Top(Cerceve);
        System.out.println("Minimum Yol Problem Toplami: " + Cozum);
    }
}
