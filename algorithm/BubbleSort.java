/* 冒泡排序*/
public class BubbleSort{
    private int[] array;
    public BubbleSort(int[] array){
        this.array = array;
    }
    public void sort(){
        int length = array.length;
        if(length > 0){
            for(int i = 1; i < length; i++){//趟数
                for(int j = 0; j < length - i; j++){//每趟排序//个数
                    if(array[j] > array[j+1]){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
        }
    }
    public void sort2(){
        int length = array.length;
        if(length > 0){
            for(int i = 1; i < length; i++){
                for(int j = 0; j < length - i ; j++){
                    if(array[j] < array[j+1]){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] =  temp;
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
        int[] array = new int[]{5,9,1,9,5,3,7,6,1};
        BubbleSort bubbleSort = new BubbleSort(array);
        bubbleSort.sort();
        bubbleSort.print();
    }
}
