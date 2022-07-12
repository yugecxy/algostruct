package xiaoyu.algostruct;

class Test {

}

public class Solution {
    private static volatile Test test;

    public static Test getSingleTonTest() {
        if (test == null) {
            synchronized (Solution.class) {
                if (test == null) {
                    test = new Test();
                }
            }
        }
        return test;
    }
}
