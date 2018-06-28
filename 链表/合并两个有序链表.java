题目: 合并两个有序链表；
输入两个单调递增的链表，输出两个链表合成后的链表，
当然我们需要合成后的链表满足单调不递减规则。

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode cur = list1;
        ListNode ptr = list2;
        ListNode list3 = null;
        if(cur.val < ptr.val) {
            list3 = cur;
            cur = cur.next;
         } else {
            list3 = ptr;
            ptr = ptr.next;
         }
        ListNode head = list3;
        while (cur != null && ptr != null) {
             if(cur.val < ptr.val) {
                head.next = cur;
                cur = cur.next;
             } else {
                head.next = ptr;
                ptr = ptr.next;
             }
            head = head.next;
        }
        if (cur != null) {
            head.next = cur;
        }
        if (ptr != null) {
            head.next = ptr;
        }
        return list3;
    }
}