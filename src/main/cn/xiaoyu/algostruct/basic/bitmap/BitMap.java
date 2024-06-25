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

    public void del(int value) {
        int byteIndex = value / 8;
        int bitIndex = value % 8;
        bytes[byteIndex] = (byte) (bytes[byteIndex] & ~(1 << (8 - bitIndex)));
    }

    public boolean get(int value) {
        int byteIndex = value / 8;
        int bitIndex = value % 8;
        return (bytes[byteIndex] & (1 << (8 - bitIndex))) != 0;
    }


    public static void main(String[] args) {
        BitMap solution = new BitMap(17);
        solution.set(12);
        solution.set(10);
        solution.set(11);
        System.out.println(solution.get(12));
        solution.del(12);
        System.out.println(solution.get(12));


    }
}