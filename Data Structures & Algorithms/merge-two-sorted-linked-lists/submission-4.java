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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode current1 = list1;
        ListNode current2 = list2;
        while(current1!=null && current2!=null){
            if(current1.val < current2.val){
                current.next = current1;
                current1 = current1.next;
            }else{
                current.next = current2;
                current2 = current2.next;
            }
            current = current.next;
            current.next = null;
            
          
        }
        if(current1!=null){
            current.next = current1;
        }
        if(current2!=null){
            current.next = current2;
        }
        return dummy.next;
    }
}