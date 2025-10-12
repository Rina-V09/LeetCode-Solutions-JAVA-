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
        int lenA = getListLen(headA);
        int lenB = getListLen(headB);

        while(lenA>lenB){
            lenA--;
            headA = headA.next;
        }

        while(lenB>lenA){
            lenB--;
            headB = headB.next;
        }

        while(headA!= null && headB!= null){
            if(headA == headB){
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int getListLen(ListNode head){
        int len = 0;

        while(head!= null){
            len++;
            head= head.next;
        }
        return len;
    }
}