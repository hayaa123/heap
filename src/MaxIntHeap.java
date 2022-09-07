import java.util.Arrays;   
import java.lang.Math;

public class MaxIntHeap {
    public static int size =0;
    public static int[] heapArr;
    public static int num_of_childs;
    MaxIntHeap(double child_factor,int capacity) {
        heapArr = new int[capacity];
        num_of_childs =(int)Math.pow(2.0,child_factor);
    }   


    /**
     * takes a child index and return its parent index 
     * @param child index 
     * @return the index of its parent
     */
    private static int parentIndex(int child_index){
        return (child_index-1)/num_of_childs;
    }


    /**
    * takes a parent index and return its childes indeces as array 
    * @param parent_index 
    * @return array of its child indices if exist
    */
    private static int[] childsIndex (int parent_index){
        int child_arr_size = 0;
        int[] childs_arr = new int [num_of_childs];

        for (int i =1;i<childs_arr.length+1;i++){
            int index = (num_of_childs *parent_index)+i;
            childs_arr[i] = index;

            if (index < size){
                childs_arr[i-1] = index;
                child_arr_size++;
            } 
        }
        int[] new_arr = new int [child_arr_size];
        for(int i=0;i<child_arr_size;i++){
            new_arr[i]= childs_arr[i];
        }
        return new_arr;
    }
    /**
     * a function that takes a parent index and then returrn the biggest child of its childs 
     * @param parent_index
     * @return biggest child index
     */
    private static int biggestChild(int parent_index){
        int[] child_index = childsIndex(parent_index);
        int max_index = child_index[0];

        for (int i=0;i<child_index.length;i++){
            if (heapArr[child_index[i]]>heapArr[max_index]){
                max_index = child_index[i];
            }
        }
        return max_index;
    }


    private static boolean hasParent (int child_index){
        return parentIndex(child_index) >=0;
    }

    private static boolean hasChilds(int parent_index){
        if(childsIndex(parent_index).length==0){
            return false; 
        }
        else {
            return true;
        }
    }
    private static void swap(int first_index,int second_index){
        int temp  = heapArr[first_index];
        heapArr[first_index] = heapArr[second_index];
        heapArr[second_index] = temp;
    }

    private static void heapfy_up(){
        int parent_value = heapArr[parentIndex(childsIndex(size)[0])];
        int child_index = size;
        while (hasParent(child_index) && heapArr[child_index]>parent_value){
            swap(parentIndex(child_index), child_index);
            child_index = parentIndex(child_index);
            parent_value = heapArr[parentIndex(child_index)];
        }
    }
    /**
     * heapfy_down is a function that order the heap after remove the root
     */
    private static void heapfy_down(){
        int smaller_value = heapArr[0];
        int smaller_value_index = 0;
        int biggest_child_index = biggestChild(smaller_value_index);

        while (biggest_child_index < size-1){
            if (smaller_value < heapArr[biggest_child_index]){
                    swap(smaller_value_index,biggest_child_index);
                    smaller_value_index = biggest_child_index; //update the index
                    if (hasChilds(smaller_value_index)){
                        biggest_child_index = biggestChild(smaller_value_index);
                    }         
            }
            else {
                break;
            }

        } // while we dont reach the end of the arrray
    }

    /**
     * a function that takes a value and added it tothe heap in the right place 
     * @param value
     */
    public static void insert(int value){
      if(size ==0){
        heapArr[0] = value;
        size++;
      } // if the heap empty add to the first index
      else {
        heapArr[size] = value;
        heapfy_up();
        size++;
      }
    }

    /**
     * PopMax is a function that remove the root of the heap
     */
    public static void popMax(){
        heapArr[0] = heapArr[size-1];
        heapArr[size-1] = 0;
        size--; 
        if (size>1){
            heapfy_down();
        }
    }
    public static void print(){
        for (int i=0 ; i<heapArr.length;i++){
            System.out.println(heapArr[i]);
        }
    }
}
