/* 两个队列实现堆栈
入栈 ：两个队列哪个部位空，就把元素入到哪个队列中;如果都为空则任选一个入对，假设这个为queue1
出栈：把不为空的队列中除最后一个元素外的所有元素移到另一个队列中，然后出队最后一个元素。
 */
public class Queue2Stack {
    private ArrayQueue queue1;
    private ArrayQueue queue2;
    private int maxLength;
    public Queue2Stack(int capacity) {
        maxLength = capacity;
        queue1 = new ArrayDeue(capacity);
        queue2 = new ArrayDeue(capacity);
    }

}
