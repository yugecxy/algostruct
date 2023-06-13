package xiaoyu.algostruct.design.singleton;

/**
 * 双重检测
 */
public class Solution3 {
    private static volatile SingleTon singleTon;

    public static SingleTon getSingTon() {
        if (singleTon == null) {
            synchronized (Solution3.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
