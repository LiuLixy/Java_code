package linkedlist;

/**
 * @Author: LiuWang
 * @Created: 2018/8/15 10:24
 */
public class LinkedListApplication {

    public static void main(String[] args) {
        testAddBack();
        testRemoveBack();
        testAddFront();
        testRemoveFront();
        testAdd();
        testRemove();
        testLength();
        testIndexOf();
        testToArray();
        testContains();
        testGetSet();
        testIsEmpty();
        testClear();
        testReversePrint();
    }

    public static void testAddBack() {
        System.out.println("*********** testAddBack ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
    }

    public static void testRemoveBack() {
        System.out.println("*********** testRemoveBack ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        System.out.println("删除空链表: Expect false, Actual " + linkedList.removeBack());
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
        linkedList.removeBack();
        linkedList.linkedListPrint("尾删1个元素");
        linkedList.removeBack();
        linkedList.removeBack();
        linkedList.linkedListPrint("尾删2个元素");
    }

    public static void testAddFront() {
        System.out.println("*********** testAddFront ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addFront("a");
        linkedList.addFront("b");
        linkedList.addFront("c");
        linkedList.linkedListPrint("头插3个元素");
    }

    public static void testRemoveFront() {
        System.out.println("*********** testAddFront ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        System.out.println("删除空链表: Expect false, Actual " + linkedList.removeFront());
        linkedList.addFront("a");
        linkedList.addFront("b");
        linkedList.addFront("c");
        linkedList.linkedListPrint("头插3个元素");
        linkedList.removeFront();
        linkedList.linkedListPrint("头删1个元素");
        linkedList.removeFront();
        linkedList.removeFront();
        linkedList.linkedListPrint("头删2个元素");
    }

    public static void testAdd() {
        System.out.println("*********** testAdd ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.linkedListPrint("尾插3个元素");
        linkedList.add(2, "d");
        linkedList.linkedListPrint("在下标为2处插入元素d");
        linkedList.add(1, "e");
        linkedList.linkedListPrint("在下标为1处插入元素e");
    }

    public static void testRemove() {
        System.out.println("*********** testRemove ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
        System.out.println("删除下标为6的元素: Expect false, Actual " + linkedList.remove(6));
        linkedList.remove(4);
        linkedList.linkedListPrint("删除下标为4的元素");
        linkedList.remove(0);
        linkedList.linkedListPrint("删除下标为0的元素");
    }

    public static void testLength() {
        System.out.println("*********** testLength ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
        System.out.println("链表长度: Expect 5, Actual " + linkedList.length());
        linkedList.removeBack();
        linkedList.removeBack();
        linkedList.linkedListPrint("尾删两个元素");
        System.out.println("链表长度: Expect 3, Actual " + linkedList.length());
    }

    public static void testIndexOf() {
        System.out.println("*********** testIndexOf ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
        System.out.println("f的下标为: Expect -1, Actual " + linkedList.indexOf("f"));
        System.out.println("d的下标为: " + linkedList.indexOf("d"));
    }

    public static void testToArray() {
        System.out.println("*********** testToArray ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
        Object[] array = linkedList.toArray();
        System.out.print("将链表转换为数组: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void testContains() {
        System.out.println("*********** testContains ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
        boolean result = linkedList.contains("g");
        System.out.println("判断元素g是否在链表中: Expect false, Actual " + result);
        result = linkedList.contains("b");
        System.out.println("判断元素b是否在链表中: Expect true, Actual " + result);
    }

    public static void testGetSet() {
        System.out.println("*********** testGetSet ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
        String str = linkedList.get(2);
        System.out.println("下标为2的元素为: Expect c, Actual " + str);
        str = linkedList.get(5);
        System.out.println("下标为5的元素为: Expect null, Actual " + str);
        linkedList.set(0, "f");
        linkedList.linkedListPrint("将下标为0的元素修改为f");
        System.out.println("修改下标为5的元素: Expect false, Actual " + linkedList.set(5, "g"));
    }
    public static void testIsEmpty() {
        System.out.println("*********** testIsEmpty ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        boolean result = linkedList.isEmpty();
        System.out.println("Expect true, Actual " + result);
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
        result = linkedList.isEmpty();
        System.out.println("Expect false, Actual " + result);
    }
    public static void testClear() {
        System.out.println("*********** testClear ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
        linkedList.clear();
        linkedList.linkedListPrint("清空链表");
    }
    public static void testReversePrint() {
        System.out.println("*********** testReversePrint ***********");
        ILinkedList<String> linkedList = new LinkedListImpl<String>();
        linkedList.addBack("a");
        linkedList.addBack("b");
        linkedList.addBack("c");
        linkedList.addBack("d");
        linkedList.addBack("e");
        linkedList.linkedListPrint("尾插5个元素");
        System.out.print("逆序打印: ");
        linkedList.reversePrint();
    }
}
