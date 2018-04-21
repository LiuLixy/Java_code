interface Link {
	boolean pushBack(Object obj);  //尾插
	boolean popBack();             //尾删
	int length();                  //求链表长度
	boolean contains(Object obj);  //查找某一元素是否在链表中
	int indexOf(Object obj);       //求某元素的下标
	Object get(int index);         //求指定下标的元素的值
	Object[] toArray();            //转换为数组
	boolean set(int index, Object obj);  //改变指定位置的元素
	boolean push(int index, Object obj);   //在指定位置之前插入元素
	boolean pop(int index);        //指定位置删除节点
	boolean isEmpty();             //判断链表是否为空
	void printLink();
	void clear();                  //清空链表
}

class LinkFactory{
	private LinkFactory() {}
	public static Link getInstance() {
		return new LinkImpl();
	}
}

class LinkImpl implements Link {
	private int size = 0;
	private Node first;
	private Node last;
	
	private class Node {
		Object obj;
		private Node prev;
		private Node next;
		private Node(Node prev, Object obj, Node next) {
			this.obj = obj;
			this.prev = prev;
			this.next = next;
		}
	}
	@Override
	public boolean pushBack(Object obj) {
		Node tmp = this.last;
		Node newNode = new Node(tmp, obj, null);
		last = newNode;
		if(tmp == null) {
			this.first = newNode;
		} else {
			tmp.next = newNode;
		}
		newNode = last;
		this.size++;
		return true;
	}
	@Override
	public boolean popBack() {
		//空链表
		if(this.first == null) {
			return false;
		}
		//只有一个节点
		if(this.first == this.last) {
			first = null;
			last = null;
			this.size--;
			return true;
		}
		Node toDelete = this.last;
		last = toDelete.prev;
		last.next = null;
		toDelete = null;
		this.size--;
		return true;
	}
	@Override
	public int length() {
		return this.size;
	}
	@Override
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}
	@Override
	public int indexOf(Object obj) {
		int index = 0;
		if(obj == null) {
			for(Node tmp = first; tmp != null; tmp = tmp.next) {
				if(tmp.obj == null) {
					return index;
				}
				index++;
			}
		}else {
			for(Node tmp = first; tmp != null; tmp = tmp.next) {
				if(obj.equals(tmp.obj)) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}
	@Override
	public Object get(int index) {
		if(index >= length()) {
			return null;
		}
		if(index > (length()>>1)) {
			Node tmp = last;
			for(int i = length(); i > index; i--) {
				tmp = tmp.prev;
			}
			return tmp.obj;
		} else {
			Node tmp = first;
			for(int i = 0; i < index; i++) {
				tmp = tmp.next;
			}
			return tmp.obj;
		}
	}
	@Override
	public Object[] toArray() {
		Object[] result = new Object[this.size];
		int i = 0;
		for(Node tmp = first; tmp != null; tmp = tmp.next) {
			result[i++] = tmp.obj;
		}
		return result;
	}
	@Override
	public boolean set(int index, Object obj) {
		if(index < 0 ||index > length()) {
			return false;
		}
		Node newNode = node(index);
		newNode.obj = obj;
		return true;
	}
	@Override
	public boolean push(int index, Object obj) {
		if(index < 0 ||index > length()) {
			return false;
		}
		if(index == length()) {
			pushBack(obj);
			return true;
		}
		if(index == 0) {
			Node tmp = this.first;
			Node newNode = new Node(null, obj, null);
			newNode.next = tmp;
			tmp.prev = newNode;
			this.first = newNode;
			this.size++;
			return true;
		}else {
			Node tmp = first;
			for(int i = 0; i < index; i++) {
				tmp = tmp.next;
			}
			Node newNode = new Node(null, obj, null);
			Node newNodePrev = tmp.prev;
			Node newNodeNext = tmp;
			newNode.prev = newNodePrev;
			newNode.next = newNodeNext;
			newNodeNext.prev = newNode;
			newNodePrev.next = newNode;
			this.size++;
			return true;
		}
	}
	@Override
	public boolean pop(int index) {
		if(index < 0 ||index >= length()) {
			return false;
		}
		if (index == 0) {
			if(first == last) {
				this.first = this.last = null;
				this.size = 0;
				return true;
			}
			Node toDelete = first;
			first = first.next;
			first.prev = null;
			toDelete.next = null;
			toDelete = null;
			this.size--;
			return true;
		}
		if(index == size - 1) {
			Node toDelete = last;
			last = last.prev;
			last.next = null;
			toDelete.prev = null;
			toDelete = null;
			this.size--;
			return true;
		}
		Node tmp = first;
		for(int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		Node toDelete = tmp;
		Node toDeleteNext = toDelete.next;
		Node toDeletePrev = toDelete.prev;
		
		toDeleteNext.prev = toDelete.prev;
		toDeletePrev.next = toDelete.next;
		toDelete = null;
		this.size--;
		return true;
	}
	@Override
	public void clear() {
		for(Node tmp = first; tmp != null; ) {
			Node tmpNext = tmp.next;
			tmp.obj = null;
			tmp.next = null;
			tmp.prev = null;
			tmp = tmpNext;
		}
		this.first = this.last = null;
		this.size = 0;
	}
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	private Node node(int index) {
		if(index > (length()>>1)) {
			Node tmp = last;
			for(int i = length(); i > index; i--) {
				tmp = tmp.prev;
			}
			return tmp;
		}else {
			Node tmp = first;
			for(int i = 0; i < index; i++) {
				tmp = tmp.next;
			}
			return tmp;
		}
	}
	@Override
	public void printLink() {
		System.out.print("链表内容为: ");
		Object[] result = this.toArray();
		for(Object object : result) {
			System.out.print(object+" ");
		}
		System.out.println();
	}
}

public class DLink {
	public static void main(String[] args) {
		Link link = LinkFactory.getInstance();
		link.pushBack("a");
		link.pushBack("b");
		link.pushBack("c");
		link.pushBack("d");
		link.pushBack("e");
		System.out.println("链表的长度为："+link.length());
		link.printLink();
		//link.popBack();
		//System.out.println(link.length());
		//link.popBack();
		//link.popBack();
		//link.popBack();
		//link.popBack();
		//System.out.println(link.length());
		//link.popBack();
		//System.out.println(link.length());
		System.out.println("判断元素'c'是否存在: "+link.contains("c"));
		System.out.println("判断元素'f'是否存在: "+link.contains("f"));
		System.out.println("元素'd'的下标为: "+link.indexOf("d"));
		System.out.println("查找不存在的元素'f': "+link.indexOf("f"));
		System.out.println("取下标为0的元素: "+link.get(0));
		System.out.println("取下标为5的元素: "+link.get(5));
		System.out.print("将下标为2的元素的值改成'f': ");
		link.set(2, "f");
		link.printLink();
		System.out.print("在下标为0的位置之前插入元素'g': ");
		link.push(0, "g");
		link.printLink();
		System.out.print("在下标为3的位置之前插入元素'c': ");
		link.push(3, 'c');
		link.printLink();
		System.out.print("删除下标为0的元素: ");
		link.pop(0);
		link.printLink();
		System.out.print("清空链表 ");
		link.clear();
		link.printLink();
		System.out.println("链表长度为: "+link.length());
	}
}
