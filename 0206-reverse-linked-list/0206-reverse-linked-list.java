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
        if(head == null || head.next == null) return head;
        
        ListNode prev, curr, after;
        prev = null;
        curr = head;
        after = head.next;

        while(after != null){
            curr.next = prev;
            prev = curr;
            curr = after;
            after = after.next;
        }

        curr.next = prev;

        return curr;
    }
}