package xiaoyu.algostruct.design.singleton;

/**
 * 饿汉
 */
public class Solution1 {
    private static final SingleTon singleTon = new SingleTon();

    public static SingleTon getSingTon() {
        return singleTon;
    }
}
