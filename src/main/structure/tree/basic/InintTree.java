package structure.tree.basic;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/12
 * Desc:
 */
public class InintTree {
    /**
     *        1
     *     2     3
     *   4   5 6   7
     * @return
     */
    public static BasicTree tree1() {
        BasicTree t1 = new BasicTree();
        BasicTree t2 = new BasicTree();
        BasicTree t3 = new BasicTree();
        BasicTree t4 = new BasicTree();
        BasicTree t5 = new BasicTree();
        BasicTree t6 = new BasicTree();
        BasicTree t7 = new BasicTree();
        t1.data = 1;
        t2.data = 2;
        t3.data = 3;
        t4.data = 4;
        t5.data = 5;
        t6.data = 6;
        t7.data = 7;
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        return t1;
    }
}
