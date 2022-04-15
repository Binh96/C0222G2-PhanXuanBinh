package ss11_dsa_stack_queue.bai_tap.develop_queue_use_linked;

public class Queue {
    private Node front;
    private Node rear;

    public Queue(){
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int element){
        Node node = new Node(element);
        if(rear == null){
            front = rear = node;
            return;
        }
        this.rear.link = node;
        this.rear = node;
    }

    public Node deQueue(){
        if(front == null){
            return null;
        }
        Node temp = this.front;
        this.front = this.front.link;
        if(this.front == null){
            this.rear = null;
        }
        return temp;
    }

    public class Node{
        public int data;
        public Node link;

        public Node(int data){
            this.data = data;
            this.link = null;
        }
    }
}
