package com.steve.algorithms.repeat.matrixTraversal;

import com.steve.algorithms.base.TreeNode;
import org.codehaus.groovy.runtime.dgmimpl.arrays.LongArrayGetAtMetaMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 深度优先遍历示例，找寻最短路径类似的问题,
 * 算法详解：
 *    数据结构使用： stack 或者递归
 */
public class DFSSample {

    /**
     * 验证二叉搜索树 左节点 < 根 < 右子树
     * 这个算法有缺陷，当root.val == Integer.MIN_VALUE 的时候，这个算法就解决不了(修改成 Long 类型能解决)
     *
     * @param root
     * @return 空树默认属于任何类型
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double min = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= min) return false;
            min = root.val;
            root = root.right;
        }
        return true;
    }


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> inner = new ArrayList<>();

    /**
     * 113: 路径总和2
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        inner.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null){
            if(sum == 0){                               // 判断目标条件是否达到
                res.add(new ArrayList<>(inner));        // 理论上来讲这一步后面需要返回了，但因为只有一个数组保存路径，所以后面得删除最后的节点，这里就不需要
            }
        }
        if(root.left != null) pathSum(root.left, sum);
        if(root.right != null) pathSum(root.right, sum);
        inner.remove(inner.size() - 1);
        return res;
    }

}
