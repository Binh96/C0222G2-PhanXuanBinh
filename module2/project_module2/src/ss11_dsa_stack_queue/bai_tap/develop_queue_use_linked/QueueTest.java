package ss11_dsa_stack_queue.bai_tap.develop_queue_use_linked;

public class QueueTest {
    public static void main(String[] args) {
        Queue  q = new Queue();

        q.enQueue(14);
        q.enQueue(22);
        q.enQueue(6);
        System.out.println(q);
        System.out.println(" Deleted value = "+ q.deQueue());
        System.out.println(" Deleted value = "+ q.deQueue());

        // Remaining elements in Circular Queue
        System.out.println(q);

        q.enQueue(9);
        q.enQueue(20);
        System.out.println(q);

    }
}
