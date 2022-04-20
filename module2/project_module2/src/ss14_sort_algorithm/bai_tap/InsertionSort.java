package ss14_sort_algorithm.bai_tap;

public class InsertionSort {
    public static void main(String[] args) {
        int[] list = {9,8,3,5,1,2,6,7};
        insertionSort(list);
    }

    public static void insertionSort(int[] list){
        int pos, x;
        for(int i=1; i< list.length; i++){
            x = list[i];
            pos = i;
            while(pos > 0 && list[pos-1] > x){
                list[pos] = list[pos -1];
                pos--;
            }
            list[pos] = x;
        }
        System.out.println("List after sort: ");
        for(int i=0; i< list.length; i++){
            System.out.print(list[i]+"\t");
        }
    }
}
