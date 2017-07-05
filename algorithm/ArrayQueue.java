/* 数组实现顺序队列*/
/*一旦你声明final，你将不能改变这个引用*/
public class ArrayQueue {
    private final Object[] items;
    private int head;
    private int tail;
    public ArrayQueue(int capacity){
        this.items = new Object[capacity];
    }
    public boolean put(Object item){
        if(head ==(tail+1) % items.length){
            return false;
        }
        items[tail] = item;
        tail = (tail+1) % items.length;
        return true;
    }
    public Object peek(){
        if(head == tail) {
            return null;
        }
        return items[head];
    }
    public Object poll(){
        if(head == tail){
            return null;
        }
        Object item = items[head];
        items[head] = null;
        head = (head+1) % items.length;
        return item;
    }
    public boolean isFull(){
        return (head == (tail+1) % items.length);
    }
    public boolean isEmpty(){
        return head == tail;
    }
    public int size(){
        if(tail >= head){
            return tail - head;
        }else{
            return tail + items.length - head;
        }
    }
    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue(4);
        System.out.println(queue.put("A"));
        System.out.println(queue.put("B"));
        System.out.println(queue.put("C"));
        System.out.println(queue.put("D"));
        System.out.println(queue.isFull());
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());
    }
}
