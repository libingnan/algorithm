package leetcode.editor.cn;

/**
 * <p>
 * </p>
 *
 * @author LI BING NAN
 * @since 2020-11-09 12:44 下午
 */
public class RevertLinkList {
    public static void main(String[] args) {
        Solution solution = new RevertLinkList().new Solution();
        ListNode head = new ListNode(1);
        ListNode node1;
        ListNode node2;
        ListNode node3;
        ListNode node4;
        head.next = node1 = new ListNode(2);
        node1.next = node2 = new ListNode(3);
        node2.next = node3 = new ListNode(4);
        node3.next = node4 = new ListNode(5);
        ListNode newHead = solution.reverseKGroup(head);
        ListNode temp = newHead;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head) {
            ListNode preNode = null, currentNode;
            currentNode = head;
            while (currentNode != null) {
                ListNode temp = currentNode.next;
                currentNode.next = preNode;
                preNode = currentNode;
                currentNode = temp;
            }


            return preNode;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, leetcode.editor.cn.ListNode next) {
        this.val = val;
        this.next = next;
    }
}
