/* 插入排序*/
public class InsertSort{
    private int[] array;
    public InsertSort(int[] array){
        this.array = array;
    }
    public void sort(){
        if(array == null){
            throw new RuntimeException("array is null");
        }
        int length = array.length;
        if(length > 0){
            for(int i = 1; i < length; i++){
                int temp = array[i];
                int j = i;
                for(;j > 0 && array[j-1] > temp ; j--){
                    array[j] = array[j-1];
                }
                array[j] = temp;
            }
        }
    }
    public void print(){
        for(int i =0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    public  static void main(String[] args){
        int[] array = new int[]{5,9,1,9,5,3,7,6,1};
        InsertSort insertSort = new InsertSort(array);
        insertSort.sort();
        insertSort.print();
    }
}

/* 插入排序是时间复杂度是O(n^2),空间复杂度是o（1），插入排序是稳定的*/
