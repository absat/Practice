public class SinglyLinkedList<T>{
    public class Node{
        public T data;
        public Node next;
    }

    public Node headNode;
    public int size;

    public SinglyLinkedList(){
        headNode = null;
        size=0;
    }

    public boolean isEmpty(){
        if(headNode==null)
            return true;
        return false;
    }
    //Time: O(1)

    public void insertAtHead(T data){
        Node node = new Node();
        node.data = data;
        node.next=headNode;
        headNode = node;
        size++;

    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.next != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.next;
        }
        System .out.println(temp.data.toString() + " -> null");
    }

    public void insertAtEnd(T data){
        Node node = new Node();
            node.data = data;
            node.next=null;
        if(isEmpty()){
            insertAtHead(data);
        }
        else{
            Node temp = headNode;
            while(temp.next!=null)
            temp = temp.next;
            temp.next = node;
        }
        size++;
    }//O(n)

    public void insertAfter(T data, T previous){
        Node node = new Node();
        node.data = data;
        Node prev =headNode;
        while(prev!=null&&prev.data!=previous)
            prev = prev.next;
        if(prev!=null){
            node.next=prev.next;
            prev.next=node;
            size++;
        }
    }

    public boolean searchNode(T data){
        Node node = headNode;
        while(node!=null&&node.data!=data) 
            node = node.next;
        return node!=null;
    }//O(N)

    public void deleteAtHead() {
        //if list is empty then simply return
        if (isEmpty())
            return;
        //make the nextNode of the headNode equal to new headNode
        headNode = headNode.nextNode;
        size--;
    }

    public void deleteByValue(T data){
        Node node = headNode;
        Node prevNode = null;
        if(headNode.data==data){
            headNode = headNode.next;
            return ;
        }
        while(node!=null&&!node.data.equals(data)){
            prevNode = node;
            node = node.next;
        }
        if(node!=null){
            prevNode.next=node.next;
            size--;
        }
    }

}