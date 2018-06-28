题目: 输入一个链表，翻转链表后，输出该链表翻转后的所有元素。


class ListNode {
	int val;
	ListNode next = null;
	
	public ListNode(int val) {
		this.val = val;
	}
}

public class Test {
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode head = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
			System.out.println(tmp.val);
		}
		ListNode head2 = ReverseList(head);
		for (ListNode tmp = head2; tmp != null; tmp = tmp.next) {
			System.out.println(tmp.val);
		}
	}
    public static ListNode ReverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode ptr = null;
		while (cur != null) {
			ListNode tmp = cur;
			cur = cur.next;
			tmp.next = ptr;
			ptr = tmp;
		}
		head = ptr;
    	return head;
	}
}