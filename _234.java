/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static int len = 0;
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        
        cut(head, slow);
        ListNode revHead = revList(slow);

        while(head != null && revHead != null){
            if(head.val != revHead.val){
                return false;
            }
            head = head.next;
            revHead = revHead.next;
        }
        return true;
    }
    
    private void cut(ListNode head, ListNode midNode){
        while(head.next != midNode){
            head = head.next;
        }
        head.next = null;
    }
    
    private ListNode revList(ListNode head){
        ListNode newHead = new ListNode(-1);
        while(head != null){
            len++;
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
