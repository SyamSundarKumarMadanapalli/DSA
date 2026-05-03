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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode head1, head2, tempHead2;
        head1 = head;
        head2 = head.next;
        tempHead2 = head.next;
        while(head2 != null && head2.next != null){
            head1.next = head1.next.next;
            head1 = head1.next;
            head2.next = head2.next.next;
            head2 = head2.next;
        }

        head1.next = tempHead2;

        return head;
    }
}