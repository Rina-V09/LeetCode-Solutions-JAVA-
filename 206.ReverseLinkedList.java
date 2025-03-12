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
    public ListNode reverseList(ListNode head) {
        //Iterative Approach
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode nextNode = cur.next;
            cur.next=prev;
            prev=cur;
            cur=nextNode;
        }
        return prev;

    //Recursive Approach
        if(head==null|| head.next==null){
            return head;
        } 
        ListNode last = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}
