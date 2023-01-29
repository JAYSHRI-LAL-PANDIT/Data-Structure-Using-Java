import java.util.NoSuchElementException;

public class CircularSinglyLinkedList{
    private Node last;
    private int length;

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data= data;
        }
    }
    public CircularSinglyLinkedList(){
        last=null;
        length=0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public void createCircularLinkedList(){
        Node first = new Node(0);
        Node second = new Node(1);
        Node third = new Node(2);
        Node forth = new Node(3);
//Linkin nodes
        first.next=second;
        second.next=third;
        third.next =forth;
        forth.next=first;

        last = forth;

    }
    public void insertAtFirst(int data){
         Node newNode = new Node(data);
         if(last == null){
            last= newNode;
         }else{
            newNode.next=last.next;
         }
         last.next=newNode;
         length++;

    }
    public void insertAtLast(int data){
        Node newNode = new Node(data);
        if(last==null){
            last=newNode;
            newNode.next=last;
        }else{
            newNode.next=last.next;
            last.next=newNode;
            last=newNode;
        }
        length++;
    }
    public Node removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Circular Singly Linked is already empty");
        }
        Node temp = last.next;
        if(last.next == last){
            last = null;
        }else{
            last.next = temp.next;
        }
        temp.next=null;
        length--;
        return temp;
    }
    public void display(){
        if(last==null){
            return;
        }
        Node first = last.next;
        while(first != last){
            System.out.print(first.data+"-->");
            first=first.next;
        }
        System.out.println(first.data);
    }
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        //csll.createCircularLinkedList();
        //csll.insertAtFirst(-1);
        csll.insertAtLast(4);
        csll.removeFirst();
        csll.removeFirst();
        csll.display();
    }
}