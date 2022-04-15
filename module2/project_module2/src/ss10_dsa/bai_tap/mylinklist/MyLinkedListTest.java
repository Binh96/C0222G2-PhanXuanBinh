package ss10_dsa.bai_tap.mylinklist;



public class MyLinkedListTest{
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList<Integer> ll = new MyLinkedList<Integer>(3);
        ll.add(2, 19);
        ll.add(4, 5);
        ll.add(1, 7);
        ll.add(3, 10);
        ll.printList();
        System.out.println("Get element: " + ll.get(2));
        System.out.println("Size: "+ ll.size());
        System.out.println("Contains: "+ ll.contains(3));
    }
}
