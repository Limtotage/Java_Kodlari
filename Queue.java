/*Queue (Kuyruk), verilerin sıralı bir şekilde işlendiği ve yalnızca 
iki uçtan işlem yapılabilen bir veri yapısıdır. Queue, FIFO (First In, First Out)
prensibine dayanır; yani, kuyruğa eklenen ilk eleman ilk olarak çıkar. 
Bu özellik, kuyrukları belirli durumlarda (örneğin, görev sıralama veya veri akışları) 
çok kullanışlı hale getirir.
Enqueue: Kuyruğa bir eleman ekleme işlemi.
Dequeue: Kuyruktan bir eleman çıkarma işlemi.*/
import java.util.LinkedList;
import java.util.Queue;

public class Queue {
    public static void main(String[] args) {
        // Queue olusturma
        Queue<Integer> Kuyruk = new LinkedList<>();

        // Kuyruga eleman ekleme (enqueue)
        Kuyruk.offer(10);
        Kuyruk.offer(20);
        Kuyruk.offer(30);

        System.out.println("Kuyruga eklenen elemanlar: " + Kuyruk);

        // Kuyruktan eleman cikarma (dequeue)
        int Cikan = Kuyruk.poll(); // En öndeki elemani cikarir
        System.out.println("Cikarilan eleman: " + Cikan);
        System.out.println("Guncellenmis kuyruk: " + Kuyruk);

        // Kuyrugun en öndeki elemanini göruntuleme (peek)
        int Ondeki = Kuyruk.peek(); // En öndeki elemani göruntuler
        System.out.println("Kuyrugun en öndeki elemani: " + Ondeki);
        System.out.println("Son durumu: " + Kuyruk);
    }
}
