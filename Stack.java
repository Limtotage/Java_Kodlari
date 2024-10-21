/*  Stack (yığın), son giren ilk çıkar (LIFO-Last In, First Out)) prensibi ile çalışan bir veri yapısıdır. 
Genellikle görevlerin sıralı olarak işlenmesi gereken durumlarda kullanılır (örneğin, işlem geçmişi veya parantez dengeleme gibi).*/
import java.util.Stack;

public class Stack {// Parantez denge kontrolü.
    public static boolean Dengelimi(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); // Açık parantezleri yığına ekle
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false; // Eğer yığın boşsa, denge bozuldu
                char top = stack.pop();
                if (!Acilan_kapanmismi(top, ch)) return false; //Uyumlu parantezleri kontrol et
            }
        }
        return stack.isEmpty(); // Yığın boşsa denge sağlanmış demektir
    }

    private static boolean Acilan_kapanmismi(char Ac, char Kapat) {//iki karakter alır ve bu karakterlerin bir eşleşme gibi oluşturup oluşturmadığını kontrol eder.
        return (Ac == '(' && Kapat == ')') || 
               (Ac == '{' && Kapat == '}') || 
               (Ac == '[' && Kapat == ']');
    }

    public static void main(String[] args) {
        String txt = "{[()]}";
        System.out.println(Dengelimi(txt)); // Çıktı: true

        txt = "{[(])}";
        System.out.println(Dengelimi(txt)); // Çıktı: false
    }
}
