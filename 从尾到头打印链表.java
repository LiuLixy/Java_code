题目: 从尾到头打印链表。


/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/

import java.util.*;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		ListNode tmp = listNode;
		while (tmp != null) {
			stack.push(tmp.val);
			tmp = tmp.next;
		}
		while (!stack.empty()) {
			arrayList.add(stack.peek());
			stack.pop();
		}
		return arrayList;
    }
}