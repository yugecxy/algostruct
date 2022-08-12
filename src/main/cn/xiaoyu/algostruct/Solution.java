package xiaoyu.algostruct;

class Test {
    private class T {
        public String m = x + "";

    }

    public String x = "asd";

    public String y = x + "asd";

    private class T2 {
        public String m = x + "";
    }

    public void k() {
        String x = new T().m;

    }

    public static void main(String[] args) {

        System.out.println(new Test().y);
    }
}

public class Solution {
    private String a = "asdasdda";

    public static void main(String[] args) {
    }
}

