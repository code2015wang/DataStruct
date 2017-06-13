/* 给定一个链表，交换每两个相邻的节点并返回其头。如 1->2->3->4 ,返回2->1->4->3*/
/*
  public class ListNode {
  int val ;
  ListNode next;
  ListNode(int x){ val = x;}
}
*/
public class SwapPairs {
    public ListNode swapPairs (ListNode head) {
        if((head == null) || (head.next == null)){
            return head;
        }
        ListNode first = head.next;
        head.next = swapPairs(head.next.next);
        first.next = head;
        return first;
    }
}
/* 注意这道题的递归的思想*/
