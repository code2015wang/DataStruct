/* 给定一个链式链表和一个起始点和结束点，反转起始到结束点的链表节点。如 1->2->3->4->5 ,m = 2 ,n = 4
   返回 1->4->3->2->5
*/
/* public class ListNode {
   int val;
   ListNode next;
   ListNode(int x){ val = x;}

}
*/
public class ReverseLinkedListII {
    public ListNode reverseBetween (ListNode head , int m,int n){
        if(head == null) return null;
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode pre = new ListNode(0);
        pre = dumy;
        for(int i = 0; i < m-1; i++) pre = pre.next;
        ListNode start = pre.next;
        ListNode then = start.next;
        for(int i = 0; i < n-m; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dumy.next;
    }
}
