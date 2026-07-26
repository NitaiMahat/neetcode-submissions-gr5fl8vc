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
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        int carry = 0;
        while(l1Pointer!=null || l2Pointer!=null){
            int sum = carry;
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
            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        if(carry==1){
            curr.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
