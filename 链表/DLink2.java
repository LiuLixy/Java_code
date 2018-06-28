import javax.print.attribute.Size2DSyntax;
import javax.xml.soap.Node;
import javax.xml.transform.Templates;

import org.omg.CORBA.PRIVATE_MEMBER;

interface Link<T> {
	boolean add(T t);
	boolean remove();
	int length();
	boolean contains(T t);
	int indexOf(T t);
	T get(int index);
	Object[] toArray();
	boolean set(int index, T t);
	boolean isEmpty();
	void printLink();
	void clear();
}

//class LinkFactory {
//	private LinkFactory() {}
//	public static Link getInstance() {
//		return new LinkImpl();
//	}
//}

class LinkImpl<T> implements Link<T> {
	private int size = 0;
	private Node first;
	private Node last;
	
	private class Node {
		T t;
		private Node prev;
		private Node next;
		private Node(Node prev, T t, Node next) {
			this.t = t;
			this.prev = prev;
			this.next = next;
		}
 	}
 
	@Override
	public boolean add(T t) {
		Node tmp = this.last;
		Node newNode = new Node(tmp, t, null);
		last = newNode;
		if(tmp == null) {
			this.first = this.last = newNode;
		} else {
			tmp.next = newNode;
		}
		newNode = last;
		this.size++;
		return true;
	}

	@Override
	public boolean remove() {
		if (this.size == 0) {
			return false;
		}
		if (this.first == this.last) {
			this.first = this.last = null;
			this.size--;
			return true;
		}
		@SuppressWarnings("unused")
		Node toDelete = this.last;
		last = last.prev;
		toDelete = null;
		last.next = null;
		this.size--;
		return true;
	}

	@Override
	public int length() {
		return this.size;
	}

	@Override
	public boolean contains(T t) {
		for(Node tmp = first; tmp != null; tmp = tmp.next) {
			if(tmp.t.equals(t)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(T t) {
		int index = 0;
		for(Node tmp = this.first; tmp != null; tmp = tmp.next) {
			if(tmp.t.equals(t)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public T get(int index) {
		if(index < 0 || index >= this.size) {
			return null;
		}
		if(index < this.size >> 1) {
			Node tmp = this.first;
			for(int i = 0; i < index; i++) {
				tmp = tmp.next;
			}
			return tmp.t;
		} else {
			Node tmp = this.last;
			for(int i = this.size - 1; i > index; i--) {
				tmp = tmp.prev;
			}
			return tmp.t;
		}
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[this.size];
		int i = 0;
		for(Node tmp = first; tmp != null; tmp = tmp.next) {
			result[i++] = tmp.t;
		}
		return result;
	}

	@Override
	public boolean set(int index, T t) {
		if (index < 0 || index >= this.size) {
			return false;
		}
		if(index < this.size >> 1) {
			Node tmp = this.first;
			for(int i = 0; i < index; i++) {
				tmp = tmp.next;
			}
			tmp.t = t;
			return true;
		} else {
			Node tmp = this.last;
			for(int i = this.size - 1; i > index; i--) {
				tmp = tmp.prev;
			}
			tmp.t = t;
			return true;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void printLink() {
		System.out.print("链表内容为: ");
		Object[] result = this.toArray();
		for(Object obj : result) {
			System.out.print(obj+" ");
		}
		System.out.println();
	}

	@Override
	public void clear() {
		Node tmp = this.first;
		for(int i = 0; i < this.size; i++) {
			Node tmpNext = tmp.next;
			tmp.next = null;
			tmp.prev = null;
			tmp.t = null;
			tmp = tmpNext;
		}
		this.first = this.last = null;
		this.size = 0;
	}
}

public class DLink2 {
	public static void main(String[] args) {
		Link<String> link = new LinkImpl<>();
		link.add("a");
		link.add("b");
		link.add("c");
		link.add("d");
		link.add("e");
		link.printLink();
//		link.remove();
//		link.printLink();
		System.out.println(link.contains("e"));
		System.out.println(link.indexOf("d"));
		System.out.println(link.get(4));
//		link.set(1, "a");
//		link.printLink();
		link.clear();
		link.printLink();
	}
}



