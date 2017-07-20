/* 图的邻接表表示，邻接表的表示法其实和散列表有些类似。在图的邻接表表示法中，数组的每个元素是顶点，也就是链表的头，而链表中的每个元素为这个顶点的邻接的顶点 。
   什么时候用邻接图那？当图的顶点的边数远小于图的顶点的时候，非常适合使用邻接表来表示图。*/
public class ListGraph{
    class ListGraphNode{
        int value;
        ListGraphNode next;
        public ListGraphNode(int value,ListGraphNode next){
            this.value = value;
            this.next = next;
        }
    }
    private ListGraphNode[] nodes;
    public ListGraph(int[] vertexes){
        nodes = new ListGraphNode[vertexes.length];
        for(int i = 0; i < vertexes.length; i++){
            nodes[i] = new ListGraphNode(vertexes[i],null);
        }
    }
    /* 添加start可到达的边，
       @paran start 起始的边
       @param ends 可到达的顶点数组
    */
    public void addEdges(int start ,int[] ends){
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i].value == start){
                ListGraphNode node = nodes[i];
                for(int j = 0; j < ends.length; j++){
                    node.next = new ListGraphNode(ends[j],null);
                    node = node.next;
                }
            }
        }
    }
    public void printListGraph(){
        for(int i = 0; i < nodes.length; i++){
            ListGraphNode node = nodes[i];
            do{
                System.out.print(node.value);
                node = node.next;

            }while(node !=null);
                System.out.println();
        }
    }
    public static void main(String[] args){
        int[] vertexes = {0,1,2,3};
        ListGraph graph = new ListGraph(vertexes);
        graph.addEdges(0,new int[]{1,2,3});
        graph.addEdges(1,new int[]{2});
        graph.addEdges(3,new int[]{2});
        graph.printListGraph();
    }
}
