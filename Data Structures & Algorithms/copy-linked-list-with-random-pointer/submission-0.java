/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
      Node current = head;
      while(current!=null){
         Node newNode = new Node(current.val);
         Node temp = current.next;
         current.next = newNode;
         newNode.next = temp;
         current = temp;
      }

      current = head;
      while(current!=null){
        if(current.random!=null){
            current.next.random = current.random.next;
        }
        
        current  = current.next.next;
      }

      current = head;
      Node newHead = head.next;
      Node newCurrent = newHead;
      while(current!=null){
        current.next = newCurrent.next;
        current = current.next;
        if(current!=null){
            newCurrent.next = current.next;
            newCurrent = newCurrent.next;
        }
      }
      return newHead;
      
     

    }
}
