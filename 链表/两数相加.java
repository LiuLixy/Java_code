给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，
它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807


代码实现：
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        ListNode l1 = listNode1;
        ListNode l2 = listNode2;
        listNode1.next = listNode3;
        listNode3.next = listNode5;
        listNode2.next = listNode4;
        listNode4.next = listNode6;
        ListNode result = addTwoNumbers(l1, l2);
        for (ListNode tmp = result; tmp != null; tmp = tmp.next) {
            System.out.println(tmp.val);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, cur = head;
        // 表示是否需要进位(只有两个值:0跟1)
        int carry = 0;
        while (cur1 != null || cur2 != null) {
            // 需要考虑位数不同的数字相加
            int x = (cur1 != null) ? cur1.val : 0;
            int y = (cur2 != null) ? cur2.val : 0;
            int sum = carry + x + y;
            // 进位携带
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        // 加到最后一位
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
