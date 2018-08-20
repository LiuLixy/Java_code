package linkedlist.writtentest;

/**
 * @Author: LiuWang
 * @Created: 2018/8/20 10:52
 */

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class LinkedListWrittenTest {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode head = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode head2 = linkReverse(head);
        linkPrint(head2);
//        System.out.println(findMidNode(head).val);
//        System.out.println(findLastKNode(head, 2).val);

//        ListNode head1 = listNode1;
//        ListNode head2 = listNode2;
//
//        listNode1.next = listNode3;
//        listNode3.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode8;
//
//        listNode2.next = listNode4;
//        listNode4.next = listNode7;
//        listNode7.next = listNode9;
//
//        ListNode head = linkMerge(head1, head2);
//        linkPrint(head);

//        reversePrint(listNode1);

//        listNode5.next = listNode1;
//        System.out.println(JosephCircle(listNode1, 3));

//        listNode4.next = listNode3;
//        listNode3.next = listNode5;
//        listNode5.next = listNode2;
//        listNode2.next = listNode1;
//        System.out.print("排序前: ");
//        linkPrint(listNode4);
//        System.out.print("排序后: ");
//        linkBubbleSort(listNode4);
//        linkPrint(listNode4);


    }

    public static void reversePrint(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.next != null) {
            reversePrint(head.next);
        }
        System.out.print(head.val + " ");
    }

    /**
     * 单链表实现约瑟夫环
     *
     * @param head
     * @param n
     * @return
     */
    public static int JosephCircle(ListNode head, int n) {
        if (head == null) {
            return -1;
        }
        ListNode cur = head;
        while (cur.next != cur) {
            for (int i = 1; i < n; i++) {
                cur = cur.next;
            }
            // 这里要删除的元素实际上是 cur，
            // 只需要将 cur.next 的值赋给 cur，
            // 再删除 cur.next 节点即可
            ListNode toDelete = cur.next;
            cur.val = toDelete.val;
            cur.next = toDelete.next;
        }
        return cur.val;
    }

    /**
     * 单链表的冒泡排序
     *
     * @param head
     */
    public static void linkBubbleSort(ListNode head) {
        if (head == null) {
            return;
        }
        for (ListNode cur = head; cur != null; cur = cur.next) {
            for (ListNode ptr = head; ptr != cur; ptr = ptr.next) {
                if (ptr.val > ptr.next.val) {
                    int tmp = ptr.val;
                    ptr.val = ptr.next.val;
                    ptr.next.val = tmp;
                }
            }
        }
    }

    /**
     * 合并两个有序链表，合并之后依然有序
     *
     * @param head1
     * @param head2
     * @return 新链表
     */
    public static ListNode linkMerge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = null;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        if (cur1.val > cur2.val) {
            head = cur2;
            cur2 = cur2.next;
        } else if (cur1.val < cur2.val) {
            head = cur1;
            cur1 = cur1.next;
        } else {
            head = cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        ListNode cur = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                cur = cur2;
                cur2 = cur2.next;
            } else if (cur1.val < cur2.val) {
                cur = cur1;
                cur1 = cur1.next;
            } else {
                cur = cur1;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        // head2 的长度小于 head1 的长度，将 head2 剩余的节点放到 head 中
        if (cur1 != null) {
            cur.next = cur1;
        }
        // head2 的长度大于 head1 的长度，将 head2 剩余的节点放到 head 中
        if (cur2 != null) {
            cur.next = cur2;
        }
        return head;
    }

    /**
     * 查找链表的中间节点，要求只能遍历一次链表
     * @param head
     * @return
     */
    public static ListNode findMidNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 查找单链表倒数第 k 个节点，要求只能遍历一次链表
     * @param head
     * @param k
     * @return
     */
    public static ListNode findLastKNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k > length(head) || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while ((--k) != 0) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 单链表的逆置
     * @param head
     * @return
     */
    public static ListNode linkReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ptr = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = ptr;
            ptr = tmp;
        }
        return ptr;
    }

    public static int length(ListNode head) {
        int length = 0;
        if (head == null) {
            return length;
        }
        for (ListNode cur = head; cur != null; cur = cur.next) {
            ++length;
        }
        return length;
    }

    public static void linkPrint(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
