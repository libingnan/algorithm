//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 814 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            char[] sChars = s.toCharArray();
            int sl = s.length();
            int tl = t.length();
            HashMap<Character, Integer> map = new HashMap<>();
            int leftIndex = 0;
            int rightIndex = tl - 1;
            String maxString = "";
            for (char x : t.toCharArray()) {
                if (map.keySet().contains(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }
            }

            while (leftIndex < sl && rightIndex < sl) {
                int tempTl = tl;
                HashMap<Character, Integer> tempMap = (HashMap<Character, Integer>) map.clone();
                for (int j = leftIndex; j < rightIndex; j++) {
                    Integer count = tempMap.get(sChars[j]);
                    if (Objects.nonNull(count)) {
                        count--;
                        if (count >= 0) {
                            tempTl--;
                        }
                        tempMap.put(sChars[j], count);
                    } else {
                        if (j == leftIndex) {
                            leftIndex++;
                            rightIndex++;
                            continue;
                        }
                    }
                    if (j == rightIndex - 1) {
                        if (tempTl == 0) {
                            String temp = s.substring(leftIndex, rightIndex);
                            if (temp.length() < maxString.length() || maxString.length() == 0) {
                                maxString = temp;
                            }
                            leftIndex++;
                            if (rightIndex - leftIndex < tl) {
                                rightIndex++;
                            }
                            break;
                        } else if (tempTl == tl) {
                            leftIndex += tl;
                            rightIndex = leftIndex + tl;
                        } else {
                            rightIndex++;
                            if (rightIndex >= sl) {
                                return maxString;
                            }
                        }
                    }
                }

            }
            return maxString;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}