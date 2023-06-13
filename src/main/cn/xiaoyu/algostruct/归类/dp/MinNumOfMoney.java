package xiaoyu.algostruct.归类.dp;

/**
 * 身上有足够的1、5、11元面值的钞票。现在您的目标是凑出某个金额w，需要用到尽量少的钞票
 */
public class MinNumOfMoney {
    public void getMinNumOfMoney(int w) {
        int[] arrayList = new int[w + 1];
        arrayList[0] = 0;
        for (int i = 1; i <= w; i++) {
            int tmp = Integer.MAX_VALUE;
            if (i >= 1) {
                tmp = Math.min(arrayList[i - 1] + 1, tmp);
            }
            if (i >= 5) {
                tmp = Math.min(arrayList[i - 5] + 1, tmp);
            }
            if (i >= 11) {
                tmp = Math.min(arrayList[i - 11] + 1, tmp);
            }
            arrayList[i] = tmp;
            System.out.println(i + " " + tmp);
        }
    }

    public static void main(String[] args) {
        new MinNumOfMoney().getMinNumOfMoney(15);
    }
}
