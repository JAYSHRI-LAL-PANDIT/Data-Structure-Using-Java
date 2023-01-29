import java.util.NoSuchElementException;

public class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int length;
    private class Node{
        private int data;
        private Node next;
        private Node previous;
        public Node(int data){
            this.data=data;
        }
    }
    public DoublyLinkedList(){
        head=null;
        tail=null;
        length=0;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int length(){
        return length;
    }
    public void insertionAtBeginning(int data){
        Node newNode= new Node(data);
        if(isEmpty()){
            tail=newNode;
        }else{
            head.previous = newNode;
        }
        newNode.next=head;
        head=newNode;
        length++;
    }
    public void insertionAtLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            tail=newNode;
        }else{
            tail.next = newNode;
        }
        newNode.previous=tail;
        tail=newNode;
        length++;
    }
    public void displayForward(){
        if(head == null){
            return;
        }
        Node temp=head;
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void displayBackward(){
        if(tail==null){
            return;
        }
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp=temp.previous;
        }
        System.out.println("null");
    }
    public Node deleteFromFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp = head;
        if(head == tail){
            tail=null;
        }else{
            head.next.previous=null;
        }
        head=head.next;
        temp.next=null;
        length--;
        return temp;
    }
    public Node deleteFromLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp = tail;
        if(head == tail){
            head=null;
        }else{
            tail.previous.next=null;
        }
        tail = tail.previous;
        temp.previous=null;
        length--;
        return temp;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertionAtBeginning(0);
        dll.insertionAtBeginning(-1);
        dll.insertionAtBeginning(-2);
        dll.insertionAtLast(1);
        dll.insertionAtLast(2);
        dll.displayForward();
        dll.displayBackward();
        dll.deleteFromFirst();
        dll.deleteFromLast();
        dll.displayForward();
        dll.displayBackward();
    }
}