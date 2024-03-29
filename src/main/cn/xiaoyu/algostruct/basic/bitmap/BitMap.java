package xiaoyu.algostruct.basic.bitmap;

public class BitMap {

    private final byte[] bytes;

    public BitMap(int capacity) {
        bytes = new byte[capacity / 8 + 1];
    }

    public void set(int value) {
        int byteIndex = value / 8;
        int bitIndex = value % 8;
        bytes[byteIndex] = (byte) (bytes[byteIndex] | (1 << (8 - bitIndex)));
    }

    public boolean get(int value) {
        int byteIndex = value / 8;
        int bitIndex = value % 8;
        return (bytes[byteIndex] & (1 << (8 - bitIndex))) != 0;
    }


    public static void main(String[] args) {
        BitMap solution = new BitMap(17);
        solution.set(12);
        System.out.println(solution.get(12));
    }
}