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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }


    public int pairSum(ListNode head) {
        ListNode slow, fast;
        slow = head;
        fast = head;

        while(fast != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rev = reverse(slow); 

        int maxValue = 0;
        while(rev != null){
            maxValue = Math.max(maxValue, head.val + rev.val);
            head = head.next;
            rev = rev.next;
        }

        return maxValue;
    }
}