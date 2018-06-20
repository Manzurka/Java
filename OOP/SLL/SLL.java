public class SLL {
    private Node head;

    public void setSLL(){
        head = null;
    }

    public SLL add(int number){
        Node node1 = new Node(number);
            if (head == null){
                head = node1;
                return this;
            } else { 
                Node temp = head;
                while (temp.getNext() != null){
                    temp = temp.getNext();
                }
                temp.setNext(node1);
                return this;
            }
    }

    public SLL remove(){
        if (head == null){
            return this;
        } else {
            Node temp = head;
            while (temp.getNext().getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(null);
            return this;
        }
    }

    public void printValues(){
        if (head == null) {
            System.out.println("No nodes");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.getValue());
                temp = temp.getNext();
            }
        }
    }
}

    