package cn.xiaoyu.algostruct.structure.heap;

public class Heap {

    /**
     * 初始化一个二叉树（用数组表示）
     * -------1
     * ----6     3
     * --9   5 10   19
     */
    public static int[] initBinaryTree() {
        return new int[]{1, 6, 3, 9, 5, 10, 19};
    }

    /**
     * 建堆
     *
     * @param arrays          看作是完全二叉树
     * @param currentRootNode 当前父节点位置
     * @param size            节点总数
     */
    public static void createHeap(int[] arrays, int currentRootNode, int size) {

        if (currentRootNode < size) {
            //左子树和右字数的位置
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;

            //把当前父节点位置看成是最大的
            int max = currentRootNode;

            if (left < size) {
                //如果比当前根元素要大，记录它的位置
                if (arrays[max] < arrays[left]) {
                    max = left;
                }
            }
            if (right < size) {
                //如果比当前根元素要大，记录它的位置
                if (arrays[max] < arrays[right]) {
                    max = right;
                }
            }
            //如果最大的不是根元素位置，那么就交换
            if (max != currentRootNode) {
                int temp = arrays[max];
                arrays[max] = arrays[currentRootNode];
                arrays[currentRootNode] = temp;

                //继续比较，直到完成一次建堆（交换后要保证被交换的节点也要是最大堆）
                createHeap(arrays, max, size);
            }
        }
    }

    /**
     * 完成一次建堆，最大值在堆的顶部(根节点)
     */
    public static void finishCreateHeap(int[] arrays, int size) {

        // 从数组的尾部开始，直到第一个元素(角标为0)
        for (int i = size - 1; i >= 0; i--) {
            createHeap(arrays, i, size);
        }

    }

    /**
     * 接下来不断建堆，然后让数组最后一位与当前堆顶(数组第一位)进行交换即可排序：
     */
    public static void heapSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {

            //每次建堆就可以排除一个元素了
            finishCreateHeap(arrays, arrays.length - i);

            //交换
            int temp = arrays[0];
            arrays[0] = arrays[(arrays.length - 1) - i];
            arrays[(arrays.length - 1) - i] = temp;

        }
    }

    public static void main(String[] args) {
        int[] initTree = initBinaryTree();
        heapSort(initTree);
        for (int i : initTree) {
            System.out.println(i);
        }
    }
}
