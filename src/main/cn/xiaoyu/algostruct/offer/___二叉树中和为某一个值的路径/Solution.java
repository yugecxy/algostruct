package xiaoyu.algostruct.offer.___二叉树中和为某一个值的路径;

import java.util.LinkedList;
import java.util.List;

import xiaoyu.algostruct.helper.TreeNode;

/**
 *  <a href="https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/">...</a>
 *  二叉树中和为某一值的路径: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有从根节点到叶子节点路径总和等于给定目标和的路径
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode node, int target){
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        if(node == null) {
            return ret;
        }
        dfs(curList,ret,node,target);
        return ret;
    }

    public void dfs(List<Integer> curList,List<List<Integer>> ret,TreeNode node,int target){
        curList.add(node.val);
        if(node.left == null && node.right == null){
            if(target - node.val == 0){
                ret.add(new LinkedList<>(curList));
            }
            return;
        }


        if(node.left!=null){
            dfs(curList,ret,node.left,target-node.val);
            curList.remove(curList.size() - 1);
        }

        if(node.right!=null){
            dfs(curList,ret,node.right,target-node.val);
            curList.remove(curList.size() - 1);
        }
    }
}
