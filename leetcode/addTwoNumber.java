/* 给定两个非空的链表，表示两个非负整数。数字以反序存放，每个节点包含一个数字。两数相加，结果以链表形式返回。假设两个数字不包含任何前导零，除了数字0本身。如(2->4->3)+(5->6->4) 输出 7->0->8
 */
/**
   public class listNode{
   int val;
   listNode next;
   listNode(int x) {val = x;}
}
*/
public class addTwoNumber{
    public listNode addTwoNumber(listNode l1, listNode l2){
        listNode prev = new listNode(0);
        listNode head = prev;//存放结果的链表
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            listNode cur = new listNode(0);
            int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;//注意这里链表指针的转换
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
            //另外注意三元运算符的运用.
        }
        return haed.next;
    }
}
