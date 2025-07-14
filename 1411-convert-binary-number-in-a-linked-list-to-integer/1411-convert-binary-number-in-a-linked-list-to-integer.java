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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int l=0, sum=0;
        // while(temp!=null){
        //     l++;
        //     temp=temp.next;
        // }
        // temp=head;
        // while(temp!=null){
        //     sum=sum + temp.val * (int)Math.pow(2,--l);
        //     temp=temp.next;
        // }
        // return sum;
        int num=0;
        while(head!=null){
            num<<=1;
            num+=head.val;
            head=head.next;
        }
        return num;
    }
}