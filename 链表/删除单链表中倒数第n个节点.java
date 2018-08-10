题目：删除一个单链表的倒数第 n 个节点。

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
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode head = listNode1;
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode result = removeNthFromEnd(head, 2);
        for (ListNode tmp = result; tmp != null; tmp = tmp.next) {
            System.out.println(tmp.val);
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0 || n > listSize(head)) {
            return head;
        }
        if (n == 1) {
            ListNode toRemove = head;
            ListNode preRemove = head;
            while (toRemove.next != null) {
                preRemove = toRemove;
                toRemove = toRemove.next;
            }
            preRemove.next = null;
            return head;
        }

        int indexOfRemove = listSize(head) - n;
        ListNode toRemove = head;
        for (int i = 0; i < indexOfRemove; i++) {
            toRemove = toRemove.next;
        }
        ListNode toDelete = toRemove.next;
        toRemove.val = toDelete.val;
        toRemove.next = toDelete.next;
        toDelete.next = null;
        return head;
    }

    public static int listSize(ListNode head) {
        if (head == null) {
            return 0;
        }
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }
}