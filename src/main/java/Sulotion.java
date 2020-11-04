import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <p>
 * </p>
 *
 * @author LI BING NAN
 * @since 2020-11-02 1:33 下午
 */
public class Sulotion {

    //最长自串长度
    public static int lengthOfLongestSubstring(String s) {
        char[] temp = s.toCharArray();
        Set<Character> op = new HashSet<Character>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < temp.length; right++) {
            while (op.contains(temp[right]) && left < right) {
                op.remove(temp[left]);
                left++;
            }

            op.add(temp[right]);

            maxLength = maxLength < op.size() ? op.size() : maxLength;
        }
        return maxLength;
    }

    class TreeNewNode {
        int val;
        TreeNewNode left;
        TreeNewNode right;
    }

    //二叉树按层级遍历
    public static int[] levelOrder(final TreeNewNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNewNode> queue = new LinkedList<TreeNewNode>() {{
            add(root);
        }};
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNewNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        String test = "qqwerqtqzxcvvvv";

        System.out.println(lengthOfLongestSubstring(test));


    }
}
