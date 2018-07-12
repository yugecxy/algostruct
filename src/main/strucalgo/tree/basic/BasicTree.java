package strucalgo.tree.basic;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/12
 * Desc:
 */
public class BasicTree {
    int data;
    BasicTree left;
    BasicTree right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BasicTree getLeft() {
        return left;
    }

    public void setLeft(BasicTree left) {
        this.left = left;
    }

    public BasicTree getRight() {
        return right;
    }

    public void setRight(BasicTree right) {
        this.right = right;
    }
}
