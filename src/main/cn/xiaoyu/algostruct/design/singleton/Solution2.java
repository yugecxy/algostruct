package xiaoyu.algostruct.design.singleton;

/**
 * 懒汉
 */
public class Solution2 {
    private static SingleTon singleTon;

    public static synchronized SingleTon getSingTon() {
        if (singleTon == null) {
            singleTon = new SingleTon();
        }
        return singleTon;
    }
}
