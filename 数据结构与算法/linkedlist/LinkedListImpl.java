package linkedlist;

/**
 * @Author: LiuWang
 * @Created: 2018/8/15 10:06
 */
public class LinkedListImpl<T> implements ILinkedList<T> {

    private int size = 0;
    private ListNode head;

    private class ListNode {
        T t;
        ListNode next;

        private ListNode(T t) {
            this.t = t;
            next = null;
        }
    }

    @Override
    public boolean addBack(T t) {
        ListNode newNode = new ListNode(t);
        if (head == null) {
            head = newNode;
            this.size++;
            return true;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        this.size++;
        return true;
    }

    @Override
    public boolean removeBack() {
        if (head == null) {
            return false;
        }
        ListNode cur = head;
        if (cur.next == null) {
            cur = null;
            this.size--;
            return true;
        }
        while (cur.next != null) {
            // 找到倒数第二个节点
            if (cur.next.next == null) {
                cur.next = null;
                this.size--;
                return true;
            }
            cur = cur.next;
        }
        return true;
    }

    @Override
    public boolean addFront(T t) {
        ListNode newNode = new ListNode(t);
        // 新节点的 next 指向原链表的头节点，
        // 再将 head 指向新节点，就完成了头插操作
        newNode.next = head;
        head = newNode;
        this.size++;
        return true;
    }

    @Override
    public boolean removeFront() {
        if (head == null) {
            return false;
        }
        ListNode toDelete = head;
        head = head.next;
        toDelete.next = null;
        toDelete = null;
        this.size--;
        return true;
    }

    @Override
    public boolean add(int index, T t) {
        if (index > this.size || index < 0) {
            return false;
        }
        if (index == 0) {
            addFront(t);
            return true;
        }
        if (index == this.size) {
            addBack(t);
            return true;
        }
        ListNode newNode = new ListNode(t);
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (index >= this.size || index < 0) {
            return false;
        }
        if (index == 0) {
            removeFront();
            return true;
        }
        if (index == this.size - 1) {
            removeBack();
            return true;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode toDelete = cur;
        ListNode toDeleteNext = cur.next;
        toDelete.t = toDeleteNext.t;
        toDelete.next = toDeleteNext.next;
        toDeleteNext.next = null;
        toDeleteNext = null;
        this.size--;
        return true;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public int indexOf(T t) {
        ListNode cur = head;
        for (int i = 0; i < this.size; i++) {
            if (t.equals(cur.t)) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            array[i] = get(i);
        }
        return array;
    }

    @Override
    public boolean contains(T t) {
        int result = indexOf(t);
        if (result != -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean set(int index, T t) {
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.t;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    @Override
    public void clear() {
        ListNode cur = head;
        for (int i = 0; i < this.size; i++) {
            ListNode curNext = cur.next;
            cur.next = null;
            cur.t = null;
            cur = curNext;
        }
        head = null;
        this.size = 0;

    }

    @Override
    public void linkedListPrint() {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print("[" + cur.t + "] -> ");
        }
        System.out.println("[null]");
    }
}
