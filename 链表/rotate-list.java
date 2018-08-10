题目：
Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given1->2->3->4->5->NULLand k =2,
return4->5->1->2->3->NULL.

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
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cur = head;
        ListNode pre = head;
        int total;
        for (total = 1; cur.next != null; total++)
            cur = cur.next;
        for (int i = 1; i < total - k % total; i++) {
            pre = pre.next;
        }
        cur.next = preHead.next;
        preHead.next = pre.next;
        pre.next = null;
 
        return preHead.next;
    }
}