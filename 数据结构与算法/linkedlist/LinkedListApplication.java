package linkedlist;

/**
 * @Author: LiuWang
 * @Created: 2018/8/15 10:24
 */
public class LinkedListApplication {

    public static void main(String[] args) {
        ILinkedList<String> linkedList = new LinkedListImpl<String>();

        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.linkedListPrint();
    }

}
