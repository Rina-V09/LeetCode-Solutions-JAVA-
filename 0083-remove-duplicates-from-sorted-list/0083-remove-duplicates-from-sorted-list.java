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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode orig = head;
        ListNode newHead = null;
        ListNode temp = head;

        while(orig!=null){
            while(orig.next!=null && orig.val == orig.next.val){
                orig = orig.next;
            }
            if(newHead == null){
                newHead = temp = orig;
            }else{
                temp.next = orig;
                temp = orig;
            }
            orig=orig.next;
        }
        return newHead;
    }
}