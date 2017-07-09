/*静态链表*/
public class StaticLinkedList{
    class Element{
        private int data;
        private int cur;
        public int getData(){
            return data;
        }
        public void setData(int data){
            this.data = data;
        }
        public int getCur(){
            return cur;
        }
        public void setCur(int cur){
            this.cur = cur;
        }
    }
    private Element[] elements;
    private int head;
    private int tail;
    private int unUsed;
    private int size;
    public StaticLinkedList(int capacity){
        elements = new Element[capacity];
        unUsed = 0;
        for(int i = 0; i < capacity -1 ; i++){
            elements[i] = new Element();
            elements[i].setCur(i+1);
        }
        elements[capacity - 1] = new Element();
        elements[capacity - 1].setCur(-1);
    }
    public void insert(int data, int index ){
        if(index == 0){
            insertFirst(data);
        }else if(index == size){
            insertLast(data);
        }else{
            checkFull();
            Element preElement = get(index);
            Element unUsedElement = elements[unUsed];
            int temp = unUsed;
            unUsed = unUsedElement.getCur();
            unUsedElement.setCur(preElement.getCur());
            preElement.setCur(temp);
            unUsedElement.setData(data);
            size++;
        }
    }
}
