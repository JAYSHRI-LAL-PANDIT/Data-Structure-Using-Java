import java.util.NoSuchElementException;

public class Queue{
    private Node front;
    private Node rear;
    private int length;
    public Queue(){
        front=null;
        rear=null;
        length=0;
    }
    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
        }
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int length(){
        return length;
    }
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            front=newNode;
        }else{
        rear.next=newNode;
        }
        rear=newNode;
        length++;
    }
    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty.");
        }
        int result = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return result;
    }
    public void print(){
        if(isEmpty()){
            return;
        }
        Node temp = front;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.print();
        queue.dequeue();
        queue.print();
    }
}