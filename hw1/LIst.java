package hw1;

public class LIst {
    Node head;
    Node tail;


    public void add(int value){
        Node node = new Node();
        node.value = value;
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if(next == null){
            tail = newNode;
        }else{
            next.previous = newNode;
            newNode.next = next;
        }

    }

    public void delete(Node node){
        Node previous = node.previous;
        Node next = node.next;
        if(previous == null){
            node.next.previous = null;
            head = next;
        }else{
            if(next == null){
                previous.next = null;
                tail = previous;
            }else{
                previous.next = next;
                next.previous = previous;
            }
        }
        previous.next = next;
        next.previous = previous;

    }

    public Node find(int value) {
        Node currnetNode = head;
        while (currnetNode != null) {
            if (currnetNode.value == value) {
                return currnetNode;
            }

            currnetNode = currnetNode.next;
        }
        return null;
    }

    public void revert(){
        Node currnetNode = head;
        while(currnetNode != null){
            Node next = currnetNode.next;
            Node previous = currnetNode.previous;
            currnetNode.next = previous;
            currnetNode.previous = next;
            if(previous == null){
                tail = currnetNode;
            }
            if(next == null){
                head = currnetNode;
            }
            currnetNode = next;
            
        }
    }

    public class Node {
        int value;
        Node next;
        Node previous;
    }
}
