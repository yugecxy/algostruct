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
        String path = "hdfs://test-qcloud-dd-insight.net/dd-com-nio-insight-cn-test/dwh/dwd/app_user_1h_f/datetime=2023082115";
        int slash = path.lastIndexOf("/");
        System.out.println(path.substring(slash + 1));
        BitMap solution = new BitMap(17);
        solution.set(12);
        System.out.println(solution.get(12));
    }
}