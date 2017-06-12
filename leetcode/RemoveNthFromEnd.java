/*移除链表倒数第n个节点，返回移除之后的链表,如list: 1->2->3->4->5 ,n=2.返回1->2->3->5*/
/*这道题我们这样思考，一个快指针，一个慢指针，慢指针从链表开头，快指针距离慢指针n个距离，同时移动两指针当快指针到末尾时，慢指针跳过写一个节点即可得到想要的链表。*/
/*public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x;}
}
*/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        for(int i =1; i<= n+1; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
