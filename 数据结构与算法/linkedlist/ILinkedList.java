package linkedlist;

/**
 * @Author: LiuWang
 * @Created: 2018/8/15 9:22
 */
public interface ILinkedList<T> {

    /**
     * 从链表尾部插入节点
     *
     * @param t
     * @return
     */
    boolean addBack(T t);

    /**
     * 删除链表尾部节点
     *
     * @return
     */
    boolean removeBack();

    /**
     * 从链表头部插入节点
     *
     * @param t
     * @return
     */
    boolean addFront(T t);


    /**
     * 删除链表头节点
     *
     * @return
     */
    boolean removeFront();

    /**
     * 指定下标位置插入
     *
     * @param index
     * @param t
     * @return
     */
    boolean add(int index, T t);

    /**
     * 指定下标位置删除
     *
     * @param index
     * @return
     */
    boolean remove(int index);

    /**
     * 求链表长度
     *
     * @return
     */
    int length();

    /**
     * 求元素 t 的下标, 如果有多个，只返回第一次出现的下标
     *
     * @param t
     * @return
     */
    int indexOf(T t);

    /**
     * 转换为数组
     *
     * @return
     */
    Object[] toArray();

    /**
     * 判断元素 t 是否在链表中
     *
     * @param t
     * @return
     */
    boolean contains(T t);

    /**
     * 将下标为 index 的元素修改为 t
     *
     * @param index
     * @param t
     * @return
     */
    boolean set(int index, T t);

    /**
     * 取得下标为 index 的元素的内容
     *
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 判断链表是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 清空链表
     */
    void clear();

    /**
     * 打印单链表
     */
    void linkedListPrint();

}
