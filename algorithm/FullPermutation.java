/* 字符串全排列的递归实现*/
public class FullPermutation {
    public static void  recursivePermutation(String str){
        char[] array = str.toCharArray();
        recursivePermutation(array,0,array.length -1);
    }
    private static void  recursivePermutation(char[] array, int start, int end){
        if(start == end){
            for(int i = 0; i <= end; i++){
                System.out.print(array[i]);
            }
            System.out.println();
        }else {
            for(int j = start; j <= end; j++){
                swap(array,j,start);
                recursivePermutation(array,start+1,end);
                swap(array,j,start);
            }
        }
    }
    private static void swap(char[] array,int left,int right){
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    public static void main(String[] args){
        recursivePermutation("abcd");
    }
}
