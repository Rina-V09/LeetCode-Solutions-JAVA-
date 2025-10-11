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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next;
        ListNode nextSum = curr;

        while(nextSum!=null){
            int sum = 0;
            while(nextSum.val != 0){
                sum += nextSum.val;
                nextSum = nextSum.next;
            }
            curr.val = sum;
         nextSum=nextSum.next;
            curr.next = nextSum;
            curr=nextSum;
        }
        return head.next;
    }
}