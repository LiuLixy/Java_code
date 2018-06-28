题目: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
    	HashMap<RandomListNode,RandomListNode> map = 
                        new HashMap<RandomListNode,RandomListNode>();
    	RandomListNode pRandomListNode = pHead;
    	RandomListNode qRandomListNode = new RandomListNode(-1);
    	while (pRandomListNode != null) {
    		RandomListNode tmp = new RandomListNode(pRandomListNode.label);
        	map.put(pRandomListNode, tmp);
    		pRandomListNode = pRandomListNode.next;
    		qRandomListNode.next = tmp;
   			qRandomListNode = tmp;
   		}
   		Set<Entry<RandomListNode,RandomListNode>> set = map.entrySet();        
   		Iterator<Entry<RandomListNode,RandomListNode>> it = set.iterator();        
        while(it.hasNext()) {
    		Entry<RandomListNode, RandomListNode> next = it.next();            
   		    next.getValue().random = map.get(next.getKey().random);
   		}
           return map.get(pHead);
   }
}