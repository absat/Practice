public class DoublyLinkedList2<T>{

    public class Node{
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public Node tailNode;
    public int size;

    public DoublyLinkedList(){
        this.headNode = null;
        this.tailNode = null;
    }

    public boolean isEmpty(){
        if(headNode == null && tailNode == null)
            return true;
        return false;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public int getSize() {
        return size;
    }

    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        newNode.prevNode = null;
        if(headNode!=null)
            headNode.prevNode=newNode;
        else
            tailNode=newNode;
        headNode = newNode;
        size++;
    }

    public void insertAtTail(T data){
        if(isEmpty()){
            insertAtHead(data);
            return;
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.prevNode = tailNode;
        newNode.nextNode = null;
        tailNode.nextNode = newNode;
        tailNode = newNode;
        size++;
    }

    public void printList(){
        if(isEmpty()){
            System.out.println("List is Empty!");
            return;
        }
        Node temp = headNode;
        System.out.print("List: null <- ");

        while(temp!=null){
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.nextNode;
        }

        System.out.println(" -> null");
    }

    public void printListRevers(){
        if(isEmpty()){
            System.out.println("List is Empty!");
            return;
        }
        Node temp = tailNode;
        System.out.print("List: null <- ");

        while(temp!=null){
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.prevNode;
        }

        System.out.println(" -> null");
    }

    public void deleteAtHead(){
        if(isEmpty()){
            return;
        }
        headNode = headNode.next;
        if(headNode == null)
            tailNode=null;
        else
            headNode.prevNode = null;
        size--;     
    }

    public void deleteAtTail(){
        if (isEmpty())
            return;
        tailNode = tailNode.prevNode;
        if(tailNode == null)
            headNode = null;
        else
            tailNode.nextNode = null;
            size--;
    }

}