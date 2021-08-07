public class SinglyLinkedListRun {
    public static void main(String args[]){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        for(int i=1;i<11;i++)
        {
            sll.insertAtEnd(i);
            //sll.printList();
        }
        //sll.insertAfter(11, 1);
        //sll.printList();
        /*System.out.println(sll.searchNode(10));
        System.out.println(sll.searchNode(11));
        System.out.println(sll.searchNode(9));*/
        sll.deleteByValue(10);
        sll.deleteByValue(1);
        sll.deleteByValue(10);

        sll.printList();


    }
}
