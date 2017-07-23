/* 反转字符串 */
public class Reverse{
    public static String reverse(String str, int start,int end){
        char[] array = str.toCharArray();
        int finished = end + 1;
        while(finished > start){
            char temp = array[start];
            for(int j = start + 1; j < finished; j++){
                array[j-1] = array[j];
            }
            array[finished -1 ] = temp;
            finished--;
        }
        return String.valueOf(array);
    }
    public static String reverse2(String str,int start,int end){
        char[] array = str.toCharArray();
        int mid = (end - start) / 2 + start;
        for(int i = 0; i < mid -start; i++){
            swap(array,start+i ,end - i);

        }
        return String.valueOf(array);
    }
    private static void swap(char[] array,int left, int right){
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    public static String rotate(String str, int index){
        str = reverse2(str,0,index);
        str = reverse2(str,index+1,str.length()-1);
        str = reverse2(str,0,str,length()-1);
        return str;
    }
    public static void main(String[] args){
        System.out.println(reverse("abcdefg",0,6));
    }
}
