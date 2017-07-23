/* 邻接矩阵的深度优先遍历*/
import java.util.Stack;
public class DepthFirstTravel {
    class MatrixGraph {
        private int[] mapping;
        private int[][] matrix;
        public MatrixGraph(int[] vertexes){
            int length = vertexes.length;
            mapping = new int[length];
            matrix = new int[length][length];
            for(int i =0; i < length; i++){
                mapping[i] = vertexes[i];
            }
        }
        public void depthFirstTravel(){
            System.out.println("邻接矩阵的深度优先遍历");
            Stack stack = new Stack(mapping.length);
            int[] visited  = new int[mapping.length];
            int unvisited = getUnVisited(visited);
            while(unvisited >= 0){
                visited[unvisited] = 1;
                stack.push(mapping[unvisited] + ",");
                while(!stack.isEmpty()){
                    int index = stack.peek();
                    boolean found = false;
                    for(int i = 0; i < mapping.length; i++){
                        if(index != i && visited[i] == 0 && matrix[index][i] > 0){
                            visited[i] = 1;
                            stack.push(i);
                            System.out.println(mapping[i] + ",");
                            found = true;
                            break;
                        }
                    }
                    if(!fonud){
                        stack.pop();
                    }
                }
                unvisited = getUnVisited(visited);
            }
            System.out.println();
        }
        private int getUnVisited(int[] visited){
            int index = -1;
            for(int i = 0; i < visited.length; i++){
                if(visited[i] == 0){
                    index = i;
                    break;
                }
            }
            return index;
        }
    }
    public static void main(String[] args){
        int[] vertexes2 = {0,1,2,3,4,5,6};
        MatrixGraph graph2 = new MatrixGraph(vertexes2);
        graph2.addEdges(0,1);
        graph2.addEdges(0,2);
        graph2.addEdges(1,3);
        graph2.addEdges(1,4);
        graph2.addEdges(2,5);
        graph2.addEdges(2,6);
        graph2.printMatrix();
        graph2.depthFirstTravel();

    }
}
