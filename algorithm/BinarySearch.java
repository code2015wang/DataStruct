/* 二分查找*/
public class BinarySearch {
    private int[] array;
    public BinarySearch(int[] array){
        this.array = array;
    }
    public int search(int target){
        if(array == null){
            return -1;
        }
        int start = 0;
        int end = array.length;
        while(start <= end){
            int mid  = start + (end -start) / 2;
            if(array[mid] == target){
                return mid;
            }else if(target < array[mid]){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] array = {1,3,5,7,9,11,19};
        BinarySearch binarySearch = new BinarySearch(array);
        System.out.println(binarySearch.search(11));
    }
}
