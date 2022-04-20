package ss14_sort_algorithm.bai_tap;

public class InsertionSortByStep {
    public static void main(String[] args) {
        int[] list = {9,2,1,2,6,8,5,3};
        System.out.println("\nBegin sort processing...");
        insertionSort(list);
    }

    public static void insertionSort(int[] list){
        int pos, x;
        for(int i=1; i<list.length; i++){
            x = list[i];
            pos = i;
            while(pos > 0 && list[pos-1] > x){
                System.out.println("Swap " + list[pos] + " with " + list[pos - 1]);
                list[pos] = list[pos-1];
                pos--;
            }
            list[pos] = x;
        }
        System.out.println("list after sort: ");
        for(int i=0; i< list.length; i++){
            System.out.print(list[i] + "\t");
        }
    }
}
