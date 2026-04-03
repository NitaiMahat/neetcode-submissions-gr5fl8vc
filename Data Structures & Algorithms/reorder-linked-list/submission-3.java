/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        mid = reverseList(mid);
        ListNode current = head;
        while(mid!=null){
            ListNode temp1 = current.next;
            ListNode temp2 = mid.next;
            current.next = mid;
            mid.next = temp1;
            current = temp1;
            mid = temp2;
        }
       
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while(current!=null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

}
