![image.png](https://pic.leetcode-cn.com/1599462285-gPdWKl-image.png)

思路：删除所有头部的重复节点，返回不重复的第一个节点。


1.特殊情况，头节点为null或头节点下一节点为null，直接返回头节点，这时不存在重复节点
2.如果头节点与，头节点的下一节点值相等，跳过所有相等节点。递归调用函数判断最后一个跳过节点的后一节点。
3.如果头节点与，头节点的下一节点值不等，递归调用函数判断头节点的后一节点。

```
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
```
