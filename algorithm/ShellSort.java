/* 希尔排序*/
/*希尔排序的基本思想是：把待排的数列按照一定增量分割成多个子数列。但是这个子树列不是连续的，而是通过前面提到的增量，按照一定相隔的增量进行分割。然后对各个子数列进行插入排序，接着增量逐渐减少，然后对每部分进行插入排序*/
public class ShellSort {
    private int[] array;
    public ShellSort(int[] array){
        this.array = array;
    }
    public void sort(){
        int temp;
        for(int k = array.length / 2; k > 0; k /= 2){
            for(int i = k; i < array.length; i++){
                for(int j = i; j >= k;j-= k){
                    if(array[j-k] > array[j]){
                        temp = array[j-k];
                        array[j-k] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }
    public void print(){
        for(int i = 0; i < array.length; i++){


        System.out.println(array[i]);
        }
    }
    public static void main(String[] args){
        int[]  array = {5,9,1,9,5,3,7,6,1};
        ShellSort shellSort = new ShellSort(array);
        shellSort.sort();
        shellSort.print();
    }
}
