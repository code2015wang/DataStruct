/* 快速排序 是对冒泡算法的一种改进，它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据比凉意部分小，再按照这种方法对这两部分分别进行快速排序，整个过程可以进行递归进行，使整个数据变成有序序列。快速排序的思想非常简单，我们首先选择一个数作为基准数。*/
public class QuickSort {
    private int[] array;
    public QuickSort(int[] array){
        this.array =array;
    }
    public void sort(){
        quickSort(array,0,array.length - 1);
    }
    public void print(){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    private void quickSort(int[] src, int begin, int end){
        if(begin < end ){
            int key = src[begin];
            int i = begin;
            int j = end;
            while(i < j){
                while(i < j && src[j] > key){
                    j --;
                }
                if(i < j){
                    src[i] = src[j];
                    i++;
                }
                while(i < j && src[i] < key){
                    i++;
                }
                if(i < j){
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quickSort(src,begin, i-1);
            quickSort(src,i+1,end);
        }
    }
    public static void main(String[] args){
        int[] array = new int[]{5,9,1,9,5,3,7,6,1};
        QuickSort quickSort = new QuickSort(array);
        quickSort.sort();
        quickSort.print();
    }
}
/* 快速排序在冒泡法的基础上改进过来的，冒泡法每次只能交换相邻的两个元素，而快速排序是跳跃式的交换，交换距离很大，因此总的比较和交换册数少了很多，速度也快了不少。时间复杂度是o(n^2),空间复杂度是o(nlogn).但算法不稳定。
 */
