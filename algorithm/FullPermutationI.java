/* ASCII码排序全排列*/
public class FullPermutationI {
    public static void asciiPermutation(String str){
        char[] array = str.toCharArray();
        shellSort(array);
        int length = array.length;
        int i = 0;
        while(true){
            System.out.println(array);
            for(i = length -2; (i >= 0) && (array[i] >= array[i+1]); --i){
                ;
            }
            if(i < 0){
                return;
            }
            int j;
            for(j = length - 1; (j > i) && (array[j] <= array[i]); --j){
                ;
            }
            swap(array,i,j);
            reverse(array,i+1,length-1);
        }
    }
    private static void swap(char[] array, int left, int right){
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    private static void reverse(char[] array, int start,int end){
        int mid = (end - start) / 2 + start;
        for(int i = 0; i <= mid - start; i++){
            swap(array,start + i, end -i);
        }
    }
    private static void shellSort(char[] array){
        char temp;
        for(int k = array.length / 2; k > 0; k /= 2){
            for(int i = k; i <array.length; i++){


            for(int j = i; j >= k; j -= k){
                if(array[j-k] > array[j]){
                    temp = array[j-k];
                    array[j-k] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    }
    public static void main(String[] args){
        asciiPermutation("bcda");
    }
}
