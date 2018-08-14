package seqlist;

/**
 * @Author: LiuWang
 * @Created: 2018/8/14 21:17
 */
public class SeqListFactory {
    private SeqListFactory() {}
    public static ISeqList getInstance() {
        return new SeqListImpl();
    }
}
