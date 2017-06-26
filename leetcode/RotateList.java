/* 给定一个列表，将列表向右旋转k个位置，其中k是非负数。如 1->2->3->4->5, k = 2
   返回 4->5->1->2->3
   由于n可能与列表长度相比较大。所以我们需要知道链表的长度，之后将第(l- n % l)节点之后的列表移到前面完成旋转。
   代码可以分为三部分：
   1. 获取藏读
   2. 移动到第（l - n % l）个节点
   3. 进行旋转
*/
/*
  public class  ListNode {
  int val ;
  ListNode next;
  ListNode(int x) {val = x; }

}
*/
public class  RotateList {
    public ListNode rotateRight(ListNode haed, int k ){
        if(head == null || head.next == null) return head ;
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode fast = dumy,slow = dumy;
        int i = 0;
        for(i = 0; fast.next != null; i++){
            fast =fast.next;
        }//i 是链表的长度
        for(int j = i - k % i; j > 0; j++){
            slow = slow.next;
        }
        fast.next = dumy.next;
        dumy.next = slow.next;
        slow.next = null;
        return dumy.next;
    }
}
