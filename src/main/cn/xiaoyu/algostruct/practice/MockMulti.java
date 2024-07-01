package xiaoyu.algostruct.practice;


public class MockMulti {
    public boolean t(int n) {
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n = n / factor;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new MockMulti().t(14));
    }
}
