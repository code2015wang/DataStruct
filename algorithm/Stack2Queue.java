/*两个栈实现队列
 入队都在stack1中进行，出队在stack2中进行，同时遵循以下规则。
 入队：直接将元素压入stack1
 出队：如果stack不空，然后弹出stack2中元素，如果stack2为空，则stack1中元素倒入stack2中。若stack1和stack2都为空，则队列为空。
 */
import java.util.Stack;
public class Stack2Queue {
    private Stack stack1;
    private Stack stack2;
    private int maxLength;
    public Stack2Queue(int capacity){
        maxLength = capacity;
        stack1 = new Stack();
        stack2 = new Stack();
    }
    public boolean put(int item){
        if( maxLength == size()){
            return false;
        }
        stack1.push(item);
        return true;
    }
    public int poll(){
        if(!stack2.isEmpty()){
            return (int)stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return (int)stack2.pop();
        }
    }
    public int size(){
        return stack1.size()+stack2.size();
    }
    public static void main(String[] args){
        Stack2Queue queue = new Stack2Queue(5);
        queue.put(1);
        queue.put(2);
        System.out.println(queue.poll());
        queue.put(3);
        queue.put(4);
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
