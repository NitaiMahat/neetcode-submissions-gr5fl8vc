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
        ListNode current = slow.next;
        slow.next = null;
        ListNode prev = slow.next;
        while(current!=null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        ListNode first = head;
        current = prev;
        while(current!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = current.next;
            first.next = current;
            current.next = temp1;
            first = temp1;
            current = temp2;
        }
    }
}
