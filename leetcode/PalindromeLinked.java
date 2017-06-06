/* 给定一个链表，判断它是否是一个回文*/
/* definition for singly-linked  list
   public class ListNode {
   int val ;
   ListNode next;
   ListNode(int x) {val = x;}
}
*/
public class PalindromeLinked {
    public boolean isPalindrome(ListNode head){
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null ;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }
        return prev;
    }
}
