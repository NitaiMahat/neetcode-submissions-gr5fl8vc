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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode counter = head;
        int size = 0;
        while(counter!=null){
            counter = counter.next;
            size++;
        }
        if(size==n){
            return head.next;
        }
        counter = head;
        for(int i=0;i<size-n-1;i++){
            counter = counter.next;
        }
        counter.next = counter.next.next;
        
        return head;
    }
}
