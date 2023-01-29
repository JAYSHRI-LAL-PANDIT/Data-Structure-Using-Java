
public class SinglyLinkedList {
    private Node head;

    private static class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public int length(){
        if(head==null)
            return 0; 
        Node temp= head;
        int count=0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public void insertFirst(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }
    public void insertLast(int value){
        Node newNode = new Node(value);
        if(head==null){
            head = newNode;
            return;
        }
            
        Node temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        temp.next = newNode;

    }
    public void insert(int position, int value){
        Node newNode = new Node(value);
        if(position == 1){
            newNode.next = head;
            head = newNode;
            return;
        }else{
        Node temp = head;
        int count=1;
        while(count<position-1){
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        }
    }
    public Node deleteFirst(){
        if(head == null){
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    public Node deleteLast(){
        if(head == null || head.next == null){
            return head;
        }
        Node current = head;
        Node previous= null;
        while(current.next!=null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }
    public void delete(int position){
        if(position==1){
            head = head.next;
        }else{
            Node previous = head;
            int count=1;
            while(count<position-1){
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            previous.next=current.next;
        }

    }
    public boolean find(Node head, int searchKey){
        if(head == null){
            return false;
        }
        Node temp = head;
        while(temp!=null){
            if(temp.data == searchKey){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public Node reverse(Node head){
        if(head == null){
            return head;
        }
        Node current = head;
        Node previous = null;
        Node temp = null;
        while(current!=null){
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
    public Node getMiddleNode(){
        if(head == null){
            return null;
        }
        Node slowPtr = head;
        Node fastPtr= head;

        while(fastPtr !=null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    public Node getNthNodeFromEnd(int n){
        if(head == null){
            return null;
        }
        if(n<=0){
            throw new IllegalArgumentException("Invalid value ="+n);
        }
        Node mainPtr = head;
        Node refPtr = head;

        int count =0;

        while(count < n){
            if(refPtr == null){
                throw new IllegalArgumentException(n+" is greater than the number of nodes in list");
            }
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }
    public void removeDuplicate(){
        if(head == null){
            return ;
        }
        Node current = head;

        while(current!= null && current.next !=null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
    }
    public Node insertInSortedList(int value){
        Node newNode = new Node(value);
        if(head == null){
            return newNode;
        }
        Node current = head;
        Node temp = null;

        while(current!=null && current.data<newNode.data){
            temp = current;
            current = current.next;
        }

        newNode.next = current;
        temp.next = newNode;
        return head;
    }
    public void removeGivenKeyNode(int Key){
        Node current = head;
        Node temp = null;

        if(current != null && current.data == Key){
            head = current.next;
            return;
        }

        while(current != null && current.data != Key){
            temp = current;
            current = current.next;
        }

        if(current == null){
            return;
        }

        temp.next = current.next;
    }
    public boolean containsloop(){
        Node fastPtr = head;
        Node slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }
    public void createALoopInLinkedList(){
        
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node forth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);

        head = first;
        first.next = second;
        second.next = third;
         third.next = forth;
         forth.next = fifth;
         fifth.next = sixth;
         sixth.next = third;
    }
    public Node startNodeInALoop(){
        Node fastPtr = head;
        Node slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }
    private Node getStartingNode(Node slowPtr) {
        Node temp = head;
        while(temp != slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }
    public void removeLoop(){
        Node fastPtr = head;
        Node slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr){
                removeLoop(slowPtr);
                return;
            }
        }
    }
    private void removeLoop(Node slowPtr) {
         Node temp = head;
            while(temp.next != slowPtr.next ){
                temp = temp.next;
                slowPtr = slowPtr.next;
            }
            slowPtr.next = null;
    }
    public static Node merge(Node a, Node b){
        //a-->1-->3-->5-->null
        //b-->2-->4-->6-->null
        //result-->1-->2-->3-->4-->5-->6-->null.
        Node dummy = new Node(0);
        Node tail = dummy;
        while(a != null && b != null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next; 
            }
            tail = tail.next;
        }
            //a --> 1 --> 3 --> null
            //b --> 2 --> 4 --> 6 --> 7 --> 9 --> 10 --> null
        if(a == null){
            tail.next = b;
        }else{
            tail.next = a;
        }
        return dummy.next;
    }
    public static Node add(Node a, Node b){
        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0;
        while(a !=null || b !=null){
            int x = (a !=null) ? a.data :0;
            int y = (b !=null) ? b.data :0;
            int sum = carry + x + y;
            carry = sum /10;
            tail.next = new Node(sum % 10);
            tail = tail.next;
            if(a != null)
                a =a.next;
            if(b != null)
                b = b.next;    
        }
        if(carry > 0){
            tail.next = new Node(carry);
        }
        return dummy.next;
    }
    public static void main(String args[]){
        SinglyLinkedList sll = new SinglyLinkedList();
        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll.head = new Node(0);
        Node second = new Node(1);
        Node third = new Node(2);
        Node forth = new Node(3);
        // Linking nodes....
        sll.head.next = second;
        second.next = third;
        third.next = forth;
        // sll.insertFirst(-1);
        // sll.insertLast(3);
        // // sll.insert(1,-2);
        // // sll.insert(7, 3);
        // sll.insert(9, 5);
        // System.out.println(sll.deleteFirst().data);
        // System.out.println(sll.deleteLast().data);
        //sll.delete(2);
        // if(sll.find(sll.head, -1)){
        //     System.out.println("Key Element is found!!");
        // }
        // else
        //     System.out.println("Key Element is not found!!");
        // System.out.println("Middle Node in the list is :"+sll.getMiddleNode().data);
        // System.out.println("Nth node form the last is :"+sll.getNthNodeFromEnd(2).data);
        // sll.insertInSortedList(2);
        // sll.removeGivenKeyNode(2);
        //sll.createALoopInLinkedList();
        //System.out.println(sll.containsloop());
        //System.out.println(sll.startNodeInALoop().data);
        //sll.removeLoop();
        //sll.display(sll.head);
        
        // sll.display(sll.head);
        // sll.removeDuplicate();
        // System.out.println();
        // sll.display(sll.head);
        // System.out.println();
        // // sll.display(sll.reverse(sll.head));
        // System.out.println(); 
        // System.out.println("Total Number of Node is :"+sll.length());
        /////////////
        sll2.insertLast(3);
        sll2.insertLast(6);
        sll2.insertLast(9);
        sll2.insertLast(12);
        sll.display(sll.head);
        System.out.println();
        sll2.display(sll2.head);
        System.out.println();
        SinglyLinkedList result = new SinglyLinkedList();
            //result.head = merge(sll.head, sll2.head);
            result.head = add(sll.head, sll2.head);
            result.display(result.head);
        
    
    }
}
