public class App {
 
        public static void main(String[] args) throws Exception {
        MaxIntHeap new_heap =  new MaxIntHeap(2,100);
        new_heap.insert(2); 
        new_heap.insert(12); 
        new_heap.insert(21); 
        new_heap.insert(5);
        // System.out.println(new_heap.heapArr[]);
        new_heap.print();
    }
}
