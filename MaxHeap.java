import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        // Max Heap (ters sıralama düzenleyici kullanılarak)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Eleman ekleyelim
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(15);
        maxHeap.add(5);

        // Max Heap'ten eleman çıkarırken her zaman en büyük eleman çıkar
        System.out.println("Max Heap'den elemanlar çıkarılıyor:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());  // Her seferinde en büyük elemanı çıkarır
        }
    }
}
