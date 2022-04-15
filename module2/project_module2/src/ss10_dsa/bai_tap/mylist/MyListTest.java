package ss10_dsa.bai_tap.mylist;

public class MyListTest{
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>(10);
        listInteger.add(0, 1);
        listInteger.add(1, 2);
        listInteger.add(2, 3);
        listInteger.add(3, 4);
        listInteger.add(4, 5);
        listInteger.add(5, 6);
        listInteger.add(6, 7);
        listInteger.add(7, 8);
        listInteger.add(8, 9);
        listInteger.add(9, 10);
        System.out.println("Size: "+listInteger.size());
        for(int i=0; i< listInteger.size(); i++){
           System.out.print(listInteger.get(i)+"\t");
        }
        System.out.println("\nindex: "+listInteger.indexOf(2));
        System.out.println("contains: "+listInteger.contains(3));
        System.out.println("contains: "+listInteger.contains(11));
        System.out.println("remove: "+listInteger.remove(2));
        System.out.println("Array after remove: ");
        for(int i=0; i< listInteger.size(); i++){
            System.out.print(listInteger.get(i)+"\t");
        }
        System.out.println("\nSize: "+listInteger.size());
        listInteger.add(2, 3);
        System.out.println("Array after add: ");
        for(int i=0; i< listInteger.size(); i++){
            System.out.print(listInteger.get(i)+"\t");
        }
        listInteger.add(3, 11);
        listInteger.add(15, 11);
        listInteger.add(16, 11);
        listInteger.add(17, 11);
        System.out.println("\nArray after add: ");
        for(int i=0; i< listInteger.size(); i++){
            System.out.print(listInteger.get(i)+"\t");
        }
        System.out.println("\nSize: "+listInteger.size());
        listInteger.clear();
        System.out.println("\nAfter clear: "+listInteger.size());
    }

}
