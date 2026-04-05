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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        int carry = 0;
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;
        ListNode dummy = new ListNode(0);
        ListNode dummyPointer = dummy;
        while(l1Pointer!=null || l2Pointer!=null){
            int sum = 0+ carry;
            if(l1Pointer!=null){
                sum += l1Pointer.val;
                l1Pointer = l1Pointer.next;
            }
            if(l2Pointer!=null){
                sum += l2Pointer.val;
                l2Pointer = l2Pointer.next;
            }
            carry = sum/10;
            sum = sum%10;
            dummyPointer.next = new ListNode (sum);
            dummyPointer = dummyPointer.next;

        }
        if(carry==1){
            dummyPointer.next = new ListNode(1);
        }
        return dummy.next;
    }
}
