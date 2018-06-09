题目: 给定一个单链表的头节点 head, 链表长度为 N, 如果N为偶数，那么前 N/2 个节点算作左半区，
后 N/2 个节点算作右半区。如果N为奇数，那么前 N/2 个节点算作左半区，后 N/2+1 个节点算作右半区。
左半区依次记作L1->L2->…，右半区从左到右依次记为R1->R2->…，请将单链表调整成L1->R1->L2->R2->…的形式。

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode head = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        relocateList(head);
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.val + " ");
        }
    }
    public static void relocateList(ListNode head) {
        int listSize = listSize(head);
        // 节点个数小于 3 个，不需要重新组合
        if (listSize <= 3) {
            return;
        }
        // 将链表拆分成左右两个链表
        // 左边的链表
        ListNode lList = head;
        ListNode mid = head;
        for (int i = 0; i < listSize / 2 - 1; i++) {
            mid = mid.next;
        }
        // 右边的链表
        ListNode rList = mid.next;
        mid.next = null;

        ListNode tmp = null;
        while(lList.next != null){
            tmp = rList.next;
            rList.next = lList.next;
            lList.next = rList;
            lList = rList.next;
            rList = tmp;
        }
        lList.next= rList;

    }
    public static int listSize(ListNode head) {
        if (head == null) {
            return 0;
        }
        int size = 0;
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            ++size;
        }
        return size;
    }
}