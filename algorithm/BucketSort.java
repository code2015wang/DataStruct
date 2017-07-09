/* 桶排序，是一种排序算法，也是所有排序算法中最快、最简单的排序算法，其中的思想是我们首先需要知道所有待排序元素的范围，然后需要有在这个范围的同样数量的桶，接着把元素放到对应的桶里面，最后按顺序输出。更多时候，桶排序和其他排序算法一起使用。每个桶内不仅仅是一个数，在桶内使用其他排序算法*/
public class BucketSort {
    private int[] buckets;
    private int[] array;
    public BucketSort(int range, int[] array){
        this.buckets = new int[range];
        this.array = array;
    }
    public void sort(){
        if(array != null && array.length > 1){
            for(int i = 0; i < array.length; i++){
                buckets[array[i]]++;
            }
        }
    }
    public void print(){
        for(int i = buckets.length - 1; i >= 0; i--){
            for(int j = 0; j < buckets[i]; j++){
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args){
        int[] array = new int[]{5,9,1,9,5,3,7,6,1};
        BucketSort bucketsSort = new BucketSort(11,array);
        bucketsSort.sort();
        bucketsSort.print();
    }
}
/* 桶排序实际上只需要遍历一遍所有的排序元素，然后依次放入指定的位置。如果加上输出时间的话，那么需要的遍历所有的桶，时间复杂度就是O(n+m),其中ｎ为待排序的元素个数，ｍ为桶的个数。这是相当快的排序算法，但对空间的消耗有点大。桶排序适用于数据均匀分布或者数据跨度范围不大时，桶排序速度还是相当快且简单的。*/
