/* 堆的基本操作*/
public class Heap{
    private int[] element;
    public Heap(int maxSize){
        element = new int[maxSize+1];
        element[0] = 0;
    }
    public boolean isEmpty(){
        return element[0] == 0;
    }
    public boolean isFull(){
        return element[0] == element.length-1;
    }
    /*大顶堆插入元素*/
    public void  insert(int value){
        if(isFull()){
            throw new IndexOutOfBoundsException("大顶堆已经满了");
        }
        if(isEmpty()){
            element[1] = value;
        }else{
            int i = element[0]+1;//确定新增元素的下标
            while(i != 1 && value > element[ i / 2]){
                //如果比父节点大，则父节点的值下移
                element[i] = element[i / 2];
                i /= 2;
            }
            element[i] = value;
        }
        element[0]++;
    }
    /*删除大顶堆的根节点元素*/
    public int  delete(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("大顶堆已空");
        }
        //删除元素，先赋值为最后一个有效元素
        int deleteElement = element[1];
        element[1] = element[element[0]];
        element[0] --;
        int temp = element[1];
        int parent = 1;
        int child = 2;
        while(child <= element[0]){
            if(child < element[0] && element[child] < element[child+1]){
                child++;
            }
            if(temp > element[child]){
                break;
            }else{
                element[parent] = element[child];
                parent = child;
                child*=2;

            }
        }
        element[parent] = temp;
        return deleteElement;
    }
    public void printAll(){
        for(int i = 1; i < element[0]+1; i++){
            System.out.print(element[i]);
            if(i!=element[0]){
                System.out.print(",");
            }
        }
        System.out.println();
    }
    public void sort(){
        if(isEmpty()){
            throw new RuntimeException("先给初始化数据再排序");
        }
        int size = element[0];
        for(int i = 0; i < size ; i++){
            int deleteElement =delete();
            element[element[0] +1] = deleteElement;
        }
        for(int i = 1; i < size+1; i++){
            System.out.print(element[i]);
            if(i != size){
                System.out.print(",");
            }
        }
    }
    public static void main(String[] args){
        Heap heap = new Heap(100);
        heap.insert(9);
        heap.insert(18);
        heap.insert(34);
        heap.printAll();
    }
}
