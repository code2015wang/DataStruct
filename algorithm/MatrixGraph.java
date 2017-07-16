/*　图的邻接矩阵表示*/
public class MatrixGraph{
    private int[] mapping;
    private int[][] matrix;
    public MatrixGraph(int[] vertexes){
        int length = vertexes.length;
        mapping = new int[length];
        matrix = new int[length][length];
        for(int i = 0; i < length; i++){
            mapping[i] = vertexes[i];
        }
    }
    public void addEdge(int start ,int end){
        int x = -1;
        int y = -1;
        for(int i = 0; i < mapping.length; i++){
            if(x != -1 && y != -1){
                break;
            }
            if(start == mapping[i]){
                x = i;
            }
            if(end == mapping[i]){
                y = i;
            }
        }
        if(x == -1 || y == -1 || x > mapping.length -1 || y > mapping.length -1){
            throw new IndexOutOfBoundsException("边的定点不存在");
        }
        matrix[x][y] = 1;
    }
    public void printMatrix(){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[] vertexes = {0,1,2,3};
        MatrixGraph graph = new MatrixGraph(vertexes);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.printMatrix();
    }
}
