题目: 输入一个链表，输出该链表的倒数第K个节点

class ListNode {
	 int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
}

public class Test {
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
		ListNode result = FindKthToTail(head, 3);
		System.out.println(result.val);
	}
	public static ListNode FindKthToTail(ListNode head,int k) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < k - 1; i++) {
			if(fast.next != null) {
				fast = fast.next;
			} else {
				return null;
			}
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}