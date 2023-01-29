import java.util.EmptyStackException;

public class Stack{
    private Node top;
    private int length;
    public Stack(){
        top=null;
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
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next=top;
        top=newNode;
        length++;
    }
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result = top.data;
        top=top.next;
        length--;
        return result;
    }
    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}