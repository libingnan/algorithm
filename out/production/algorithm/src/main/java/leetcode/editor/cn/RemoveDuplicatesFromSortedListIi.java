//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 412 👎 0

package leetcode.editor.cn;

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(1);

        head = solution.deleteDuplicates(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode ln = null;
            ListNode pn = head;
            while (pn != null) {
                if (pn.next == null) {
                    return head;
                }
                if (pn.next.val != pn.val) {
                    ln = pn;
                    pn = pn.next;
                } else {
                    ListNode x = getRemoveNodeNext(pn);
                    if (ln == null) {
                        head = x;
                        ln = null;
                    } else {
                        ln.next = x;
                    }
                    pn = x;
                }

            }
            return head;
        }

        private ListNode getRemoveNodeNext(ListNode pn) {
            ListNode aaa;
            ListNode c;
            while (pn.next != null && pn.next.val == pn.val) {
                c = pn;
                pn = pn.next;
                c.next = null;
            }
            aaa = pn.next;
            return aaa;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}