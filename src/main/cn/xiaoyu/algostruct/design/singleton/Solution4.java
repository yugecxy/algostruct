package xiaoyu.algostruct.design.singleton;

/**
 * 静态内部类
 */
public class Solution4 {

    private static class SingleTonHelper {
        private static final SingleTon singleTon = new SingleTon();
    }

    public static SingleTon getSingTon() {
        return SingleTonHelper.singleTon;
    }
}
