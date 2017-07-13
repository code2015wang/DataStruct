/* 顺序查找*/
public class SequentialSearch {
    private int[] array;
    public SequentialSearch(int[] array){
        this.array = array;
    }
    public int Search(int key){
        if(key == array[0]){
            return 0;
        }
        int temp = array[0];
        array[0] = key;
        int i = array.length - 1;
        while(array[i] != key){
            i--;
        }
        array[0] = temp;
        if(i == 0){
            return -1;
        }
        return i;
    }
    public static void main(String[] args){
        int[] array = {1,3,5,7,9,11,19};
        SequentialSearch seqSearch = new SequentialSearch(array);
        System.out.println(seqSearch.Search(3));
        System.out.println(seqSearch.Search(100));
    }
}
