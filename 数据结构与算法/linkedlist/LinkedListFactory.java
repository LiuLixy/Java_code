package linkedlist;

/**
 * @Author: LiuWang
 * @Created: 2018/8/15 10:04
 */
public class LinkedListFactory {

    private LinkedListFactory() { }

    public static ILinkedList getInstance() {
        return new LinkedListImpl();
    }
}
