import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) {
        // Min Heap (PriorityQueue default olarak Min Heap'dir)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Eleman ekleyelim
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(15);
        minHeap.add(5);
        
        // Min Heap'ten eleman çıkarırken her zaman en küçük eleman çıkar
        System.out.println("Min Heap'den elemanlar cikariliyor:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());  // Her seferinde en küçük elemanı çıkarır
        }
    }
}
