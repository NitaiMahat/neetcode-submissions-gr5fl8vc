/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        Set<ListNode> seenSet = new HashSet<>();
        while(headA!=null){
            seenSet.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(seenSet.contains(headB)){
                return headB;
            }
          
            headB = headB.next;
        }
        return null;
    }
}