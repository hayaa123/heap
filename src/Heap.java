import java.lang.reflect.Array;

public class Heap {
    public static int size =0;
    public static int capacity = 20;
    public static int[] heapArr = new int[capacity];
    

    private static int leftChildIndex(int parent_index){
        return 2*parent_index +1;
    }
    private static int rightChildIndex(int parent_index){
        return 2*parent_index +2;
    }
    private static int parentIndex(int child_index){
        return (child_index-1 )/2;
    }
    private static boolean hasLeftChild(int parent_index){
        return leftChildIndex(parent_index) < size;
    }
    private static boolean hasRightChild(int parent_index){
        return rightChildIndex(parent_index) < size;
    }
    private static boolean hasParent(int child_index){
        return parentIndex(child_index) >= 0 ;
    }

    private static void swap(int first_index,int second_index){
        int temp = heapArr[first_index];
        heapArr[first_index] = heapArr[second_index];
        heapArr[second_index] = temp;
    }

    private static void heapfyUp(){
        int valueIndex = size ;
        int parentValue = heapArr[parentIndex(valueIndex)];
        System.out.println("value_value :"+heapArr[valueIndex]);
        System.out.println("parent_value :"+parentValue);
        while(hasParent(valueIndex) && parentValue> heapArr[valueIndex]){

            swap(parentIndex(valueIndex), valueIndex);
            valueIndex =  parentIndex(valueIndex) ;
            parentValue = heapArr[parentIndex(valueIndex)];
        }
            
    }
    public static void insert(int value){
        if (size ==0){
            heapArr[0] = value;
            size++; 
        }
        else {
            heapArr[size] = value;
            heapfyUp();
            size++; 
        }
    }
    public static void print(){
        for(int i=0;i<size;i++){
            System.out.println(heapArr[i]);
        }
    }
}

