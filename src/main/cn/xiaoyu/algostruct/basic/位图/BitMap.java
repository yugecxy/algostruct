package xiaoyu.algostruct.basic.位图;

public class BitMap {
    private final char[] bytes;
    private final int nBits;

    public BitMap(int nBits) {
        this.nBits = nBits;
        this.bytes = new char[nBits / 16 + 1];
    }

    public void set(int k) {
        if (k > nBits) return;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nBits) return false;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(18);
        bitMap.set(3);
        System.out.println(bitMap.get(3));
    }
}