/*实现链表*/
public class Link{
    class Node{
        private int data;
        private Node next;
        public int getData(){
            return data;
        }
        public void setData(int data){
            this.data = data;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next = next;
        }
    }
    private int size = 0;
    private Node first;
    private Node last;
    public Link(){ }
    /*链表后部插入*/
    public void addLast(int data){
        if(size == 0){
            fillStart(data);
        }else{
            Node node = new Node();
            node.setData(data);
            last.setNext(node);
            last = node;
        }
        size++;
    }
    /*链表头部插入*/
    public void addFirst(int data){
        if(size == 0){
            fillStart(data);
        }else{
            Node node = new Node();
            node.setData(data);
            node.setNext(first);
            first = node;
        }
        size++;
    }
    /*在指定位置插入*/
    public void add(int data,int index){
        if(size > index){
            if(size == 0){
                fillStart(data);
                size++;
            }else if(index == 0){
                addFirst(data);
            }else if(index + 1 ==size){
                addLast(data);
            }else{
                Node temp = get(index);
                Node node = new Node();
                node.setData(data);
                node.setNext(temp.getNext());
                temp.setNext(node);
                size++;
            }
        } else{
            throw new IndexOutOfBoundsException("链表没有这么长");
        }
    }
    /* 删除表头*/
    public void removeFirst(){
        if(size == 0){
            throw new IndexOutOfBoundsException("链表没有元素");
        }else if(size == 1){
            clear();
        }else{
        Node temp = first;
        first = temp.getNext();
        temp = null;
        size --;
    }
    }
    /* 删除表尾元素*/
   public  void removeLast (){
        if(size == 0){
            throw new IndexOutOfBoundsException("链表中没有元素");
        }else if(size == 1){
            clear();
        }else{
            Node temp = get(size-2);
            temp.setNext(null);
            size--;
        }
    }
    /*删除链表中间元素*/
    public void removeMiddle(int index){
        if(size == 0){
            throw new IndexOutOfBoundsException("链表中没有元素");
        }else if(size == 1){
            clear();
        }else{
            if(index == 1){
                removeFirst();
            } else if(size == index + 1){
                removeLast();
            }else{
                Node temp = get(index-1);
                Node next = temp.getNext();
                temp.setNext(next.getNext());
                next = null;
                size--;
            }
        }
    }
    /*获取指定下标的元素*/
    public Node get( int index){
        Node temp = new Node();
        for(int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp;
    }
    /*打印所有元素*/
    public void printAll(){
        Node temp = first;
        System.out.println(temp.getData());
        for(int i = 1; i < size; i++){
            temp = temp.getNext();
            System.out.println(temp.getData());
        }
    }
    public int size(){
        return size;
    }
    /* 在链表中插入第１个元素*/
    private void fillStart(int data){
        first = new Node();
        first.setData(data);
        last = first;
    }
    private void clear(){
        first = null;
        last = null;
        size = 0;
    }
    public voiod reverse(){
        Node temp = first;
        last = temp;
        Node next = first.getNext();
        for(int i = 0; i < size - 1; i++){
            Node nextNext = next.getNext();
            next.setNext(temp);
            temp = next;
            next = nextNext;
        }
        last.setNext(null);
        first = temp;
    }
    public static void main(String[] args){
        Link link = new Link();
        link.addFirst(2);
        link.addFirst(1);
        link.addLast(4);
        link.addLast(5);
        //        link.add(3,1);
        link.printAll();
    }
}
