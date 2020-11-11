package leetcode.editor.cn;

/**
 * <p>
 * </p>
 *
 * @author LI BING NAN
 * @since 2020-11-11 4:34 下午
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    static class TreeSNode {
        public int val;
        TreeSNode left;
        TreeSNode right;

        public TreeSNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeSNode root = new TreeSNode(1);
        TreeSNode r1 = new TreeSNode(2);
        TreeSNode r2 = new TreeSNode(3);

        root.left = r1;
        root.right = r2;
        TreeSNode r3 = new TreeSNode(4);
        TreeSNode r4 = new TreeSNode(5);
        r1.left = r3;
        r1.right = r4;
        TreeSNode r5 = new TreeSNode(6);
        TreeSNode r6 = new TreeSNode(7);
        r2.left = r5;
        r2.right = r6;

        ArrayList<ArrayList<Integer>> list = levelOrder(root);

        return;
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeSNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList();

        LinkedList<TreeSNode> nodes = new LinkedList();
        if (root == null) {
            return list;
        }
        TreeSNode temp = root;
        nodes.add(temp);
        while (nodes.size() > 0) {
            ArrayList<Integer> arrayList = new ArrayList();

            ArrayList<TreeSNode> tempList = new ArrayList<>();
            while (nodes.size() > 0) {
                TreeSNode x = nodes.poll();
                arrayList.add(x.val);
                tempList.add(x);
            }
            list.add(arrayList);
            for (TreeSNode treeSNode : tempList) {
                if (treeSNode.left != null) {
                    nodes.add(treeSNode.left);
                }
                if (treeSNode.right != null) {
                    nodes.add(treeSNode.right);
                }
            }

        }

        return list;
    }
}