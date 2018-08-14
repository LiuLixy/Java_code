package seqlist;

/**
 * @Author: LiuWang
 * @Created: 2018/8/14 21:00
 */


public class SeqListApplication {
    public static void main(String[] args) {
        ISeqList seqList = new SeqListImpl();
        seqList.addBack("a");
        seqList.addBack("b");
        seqList.addBack("c");
        seqList.addBack("c");
        seqList.addBack("c");
        seqList.addBack("c");
        seqList.addBack("c");
        seqList.addBack("c");
        seqList.addBack("d");
        seqList.addBack("e");
        seqList.addBack("f");
        seqList.addBack("g");
        seqList.removeAll("c");
        seqList.seqListPrint();
    }
}
