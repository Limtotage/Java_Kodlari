/* Monotonic Stack, öğeleri monotonik (artan veya azalan) bir sırada tutan
 özel bir yığın (stack) türüdür. Bu veri yapısı, özellikle her bir eleman 
 için daha büyük ya da daha küçük öğeleri bulma gibi problemleri çözmek için
 kullanılır. Monotonic Stack, birçok problemde O(n) zaman karmaşıklığına
 ulaşılmasını sağlar, çünkü her eleman Yığına sadece bir kez eklenir 
 ve yalnızca bir kez çıkartılır. */
import java.util.Stack;

public class Monotonic_Stack {

    public static int EnByk_Dikdortgenin_Alani(int[] Yukseklikler) {
        Stack<Integer> stack = new Stack<>();
        int EnByk_Alan = 0;
        int[] Yeni_Yukseklikler = new int[Yukseklikler.length + 1];

        System.arraycopy(Yukseklikler, 0, Yeni_Yukseklikler, 0, Yukseklikler.length);

        for (int i = 0; i < Yeni_Yukseklikler.length; i++) {
            // Yığın boş değilse ve mevcut çubuğun yüksekliği, Yığındaki en üstteki çubuğun yüksekliğinden küçükse
            while (!stack.isEmpty() && Yeni_Yukseklikler[stack.peek()] > Yeni_Yukseklikler[i]) {
                int yksklik = Yeni_Yukseklikler[stack.pop()]; // Yığından en üstteki çubuğun yüksekliğini alıyoruz
                int gnslik = stack.isEmpty() ? i : i - stack.peek() - 1; //Genişliği buluyoruz (eğer Yığın boşsa genişlik i, değilse farkı)
                EnByk_Alan = Math.max(EnByk_Alan, yksklik * gnslik);
            }
            stack.push(i);
        }

        return EnByk_Alan;
    }

    public static void main(String[] args) {
        int[] Numaralar = { 4, 5, 2, 10, 8 };
        int Sonuc = EnByk_Dikdortgenin_Alani(Numaralar);

        System.out.print("En Buyuk Dikdortgenin Alani: " + Sonuc);
    }
}
