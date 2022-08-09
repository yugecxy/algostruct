package xiaoyu.algostruct;

public class Solution {
    byte[] bytes;

    public Solution(int bitLen) {
        bytes = new byte[bitLen / 8 + 1];
    }

    public void set(int value) {
        int byteIndex = value / 8;
        int bitIndex = value % 8;
        bytes[byteIndex] |= 1 << (8 - bitIndex);
    }

    public boolean get(int value) {
        int byteIndex = value / 8;
        int bitIndex = value % 8;
        return (bytes[byteIndex] & (1 << (8 - bitIndex))) != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(7);
        solution.set(6);
        System.out.println(solution.get(6));
    }

}
