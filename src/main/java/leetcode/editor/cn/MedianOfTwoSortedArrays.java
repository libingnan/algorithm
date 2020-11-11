//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3374 👎 0

package leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int num1[] = {5, 6, 7, 8, 9, 10, 11, 12, 13};
        int num2[] = {13, 14, 15, 16, 17, 18, 19};
        System.out.println(solution.findMedianSortedArrays(num1, num2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length < nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            boolean flag = ((nums1.length + nums2.length) & 1) == 1;
            int flag1 = (nums1.length & 1) == 1 ? ((nums1.length) >> 1) : ((nums1.length - 1) >> 1);
            int flag2 = ((nums2.length - 1) >> 1);
            while (true) {
                int maxLeft = nums1[flag1] > nums2[flag2] ? nums1[flag1] : nums2[flag2];
                int minRight = nums1[flag1 + 1] < nums2[flag2 + 1] ? nums1[flag1 + 1] : nums2[flag2 + 1];
                if (maxLeft <= minRight) {
                    return flag ? maxLeft : ((double) maxLeft + (double) minRight) / 2d;
                } else {
                    if (maxLeft == nums1[flag1]) {

                        if (flag2 < nums2.length - 2) {
                            flag1--;
                            flag2++;
                        } else {
                            return flag ? nums1[flag1 - 1] : nums1[flag1 - 1] + nums1[flag1] / 2d;
                        }
                    } else {
                        if (flag2 > 0) {
                            flag1++;
                            flag2--;
                        } else {
                            return flag ? nums1[flag1 + 1] : (nums1[flag1] + nums1[flag1 + 1]) / 2d;
                        }

                    }
                }
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}