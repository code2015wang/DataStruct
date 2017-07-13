/* 简单选择排序 ，即在待排的数列中寻找最大的一个数与第一个数进行交换，接着在剩余的待排数列中继续寻找最大的与第二个数进行交换。依次类推，一直等到待排数组中只有一个元素为止。*/
public class SelectSort{
    private int[] array;
    public SelectSort(int[] array){
        this.array = array;
    }
    public void sort(){
        int length = array.length;
        for(int i = 0; i < length; i++){
            int minIndex = i;
            for(int j = i+1; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
    public void print(){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args){
        int[] array = {5,9,1,9,5,3,7,6,1};
        SelectSort selectSort = new SelectSort(array);
        selectSort.sort();
        selectSort.print();
    }
}
