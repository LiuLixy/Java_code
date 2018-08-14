package seqlist;

/**
 * @Author: LiuWang
 * @Created: 2018/8/14 21:17
 */
public class SeqListImpl implements ISeqList {

    private final int SEQ_MAX_SIZE = 1000;
    private int size = 0;
    Object[] seqListArray = new Object[SEQ_MAX_SIZE];

    @Override
    public boolean addBack(Object obj) {
        if (size() >= SEQ_MAX_SIZE) {
            return false;
        }
        seqListArray[this.size] = obj;
        this.size++;
        return true;
    }

    @Override
    public boolean removeBack() {
        if (size() <= 0) {
            return false;
        }
        this.size--;
        return true;
    }

    @Override
    public boolean addFront(Object obj) {
        if (this.size >= SEQ_MAX_SIZE) {
            return false;
        }
        for (int i = this.size - 1; i >= 0; i--) {
            seqListArray[i + 1] = seqListArray[i];
        }
        seqListArray[0] = (Integer) obj;
        this.size++;
        return false;
    }

    @Override
    public boolean removeFront() {
        if (this.size <= 0) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            seqListArray[i] = seqListArray[i + 1];
        }
        this.size--;
        return true;
    }

    @Override
    public boolean add(int index, Object obj) {
        if (index > this.size || this.size >= SEQ_MAX_SIZE) {
            return false;
        }
        for (int i = this.size - 1; i >= index; i--) {
            seqListArray[i + 1] = seqListArray[i];
        }
        seqListArray[index] = (Integer) obj;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (index >= this.size) {
            return false;
        }
        while (index < this.size) {
            seqListArray[index] = seqListArray[index + 1];
            index++;
        }
        this.size--;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index != -1) {
            remove(index);
        }
        return false;
    }

    @Override
    public boolean removeAll(Object obj) {
        for (int i = 0; i < this.size; i++) {
            int index = indexOf(obj);
            if (index != -1) {
                remove(index);
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) == -1 ? false : true;
    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        if (index >= this.size) {
            return null;
        }
        return seqListArray[index];
    }

    @Override
    public boolean set(int index, Object obj) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    @Override
    public void seqListPrint() {
        System.out.print("顺序表内容为: [");
        for (int i = 0; i < this.size; i++) {
            if (i == this.size - 1) {
                System.out.print(get(i));
            } else {
                System.out.print(get(i) + ", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public void clear() {
        this.size = 0;
    }
}
