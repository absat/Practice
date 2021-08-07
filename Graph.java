public class Graph {
    int vertices;
    DoublyLinkedList2<Integer> adjacencyList[];

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList2[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedList2<>();
        }
    }

    public void addEdge(int source, int destination){
        if(source<vertices &&destination<vertices){
            this.adjacencyList[source].insertAtTail(destination);
        }
        //for undirected, also:
        //this.adjacencyList[destination].insertAtEnd(source);
    }

    public void printGraph()
    {
        for (int i = 0; i < vertices; i++)
        {
            if(adjacencyList[i]!=null){
                System.out.print("|" + i + "| => ");

                DoublyLinkedList2<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null)
                {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            }
            else{

                System.out.println("|" + i + "| => "+ "null");
            }
        }
    }
    public static void main(String args[]){
        Graph g= new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        g.printGraph();
    }
}
