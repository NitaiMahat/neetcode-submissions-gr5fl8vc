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
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null &&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseNode = reverse(slow.next);
        slow.next = null;
      
    
        ListNode current = head;
     
        while(reverseNode!=null){
            ListNode temp = current.next;
            ListNode temp2 = reverseNode.next;
            current.next = reverseNode;
            reverseNode.next = temp;
            current = temp;
            reverseNode = temp2;

        }
    

    }
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode current = node;
        while(current!=null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
