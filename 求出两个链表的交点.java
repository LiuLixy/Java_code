题目: 输入两个链表，找出它们的公共节点

思路: 先计算出这两个链表的长度差，因为如果链表有交点，
那么它们必定有一段公共区域，公共区域的长度是一样的，
所以只需要让长度较长的链表先走上这两个链表的长度差，
然后再同时两个链表依次向后遍历找出相交点。

class ListNode {
	int val;
	ListNode next = null;

	public ListNode(int val) {
		this.val = val;
	}
}

public class Test {
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(1);
		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(2);
		ListNode c1 = new ListNode(3);
		ListNode c2 = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		ListNode pHead1 = a1;
		ListNode pHead2 = a2;
		pHead1.next = b1;
		pHead2.next = b2;
		b1.next = c1;
		b2.next = c2;
		c1.next = d;
		c2.next = d;
		d.next = e;
		e.next = f;
		System.out.println(FindFirstCommonNode(pHead1, pHead2).val);
	}

	public static int ListSize(ListNode head) {
		int size = 0;
		for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
			size++;
		}
		return size;
	}

	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		ListNode pListNode1 = pHead1;
		ListNode pListNode2 = pHead2;
		if (ListSize(pHead1) > ListSize(pHead2)) {
			for (int i = ListSize(pHead1) - ListSize(pHead2); i > 0; i--) {
				pListNode1 = pListNode1.next;
			}
		} else {
			for (int i = ListSize(pHead2) - ListSize(pHead1); i > 0; i--) {
				pListNode2 = pListNode2.next;
			}
		}
		while (pListNode1 != pListNode2) {
			pListNode1 = pListNode1.next;
			pListNode2 = pListNode2.next;
		}
		// 如果两个链表没有交点，则返回null。
		if (pListNode1 == null || pListNode2 == null) {
			return null;
		} else {
			return pListNode1;
		}
	}
}
