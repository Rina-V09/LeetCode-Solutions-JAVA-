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
    public int pairSum(ListNode head) {
       ListNode slow=head, fast=head, first=head;
       int maxSum=0;

       //middle of linkedList
       while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
       }

       //reverse the second half
       ListNode nextNode = slow, prev=null;
       while(slow!=null){
        nextNode=slow.next;
        slow.next=prev;
        prev=slow;
        slow=nextNode;
       }

       //maximum twin sum
       while(prev!=null){
        maxSum=Math.max(maxSum,prev.val+first.val);
        prev=prev.next;
        first=first.next;
       }
       return maxSum;
    }
}
