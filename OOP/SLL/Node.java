public class Node {
    private int value;
    private Node next;

    public Node(int number){
        value = number;
        next = null;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node node){
        next = node;
    }

    public int getValue(){
        return value;
    }
  
}