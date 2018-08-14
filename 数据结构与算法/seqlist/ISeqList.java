package seqlist;

/**
 * @Author: LiuWang
 * @Created: 2018/8/14 21:16
 */
public interface ISeqList {
    /**
     * 从顺序表尾部插入元素
     *
     * @param obj
     * @return
     */
    boolean addBack(Object obj);

    /**
     * 从顺序表尾部删除
     *
     * @return
     */
    boolean removeBack();

    /**
     * 从顺序表头部插入元素
     *
     * @param obj
     * @return
     */
    boolean addFront(Object obj);


    /**
     * 从顺序表头部删除
     * @return
     */
    boolean removeFront();

    /**
     * 指定下标位置插入元素
     *
     * @param index 要插入的位置
     * @param obj
     * @return
     */
    boolean add(int index, Object obj);


    /**
     * 删除指定下标的元素
     *
     * @param index 要删除的下标
     * @return
     */
    boolean remove(int index);

    /**
     * 删除指定元素，如果出现多次则删除第一次出现的元素
     *
     * @param obj
     * @return
     */
    boolean remove(Object obj);

    /**
     *
     * 删除指定元素，如果出现多次，则全部删除
     *
     * @param obj
     * @return
     */
    boolean removeAll(Object obj);

    /**
     * 求顺序表长度
     *
     * @return
     */
    int size();

    /**
     * 查找某个元素是否在顺序表中
     *
     * @param obj
     * @return
     */
    boolean contains(Object obj);

    /**
     * 查找指定元素的下标位置, 如果出现多次，则返回第一次出现的下标
     *
     * @param obj
     * @return
     */
    int indexOf(Object obj);

    /**
     * 取得指定下标的元素值
     *
     * @param index
     * @return
     */
    Object get(int index);

    /**
     * 将下标为 index 的元素值修改为 obj
     *
     * @param index
     * @param obj
     * @return
     */
    boolean set(int index, Object obj);

    /**
     * 判断顺序表是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 打印顺序表
     *
     */
    void seqListPrint();

    /**
     * 清空顺序表
     */
    void clear();
}
