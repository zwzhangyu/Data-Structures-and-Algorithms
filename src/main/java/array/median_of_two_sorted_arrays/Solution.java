package array.median_of_two_sorted_arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @author zhangyu
 * @date 2023/4/5
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int ptr1 = 0;
        int ptr2 = 0;
        double[] newNums = new double[totalLength];
        for (int i = 0; i < totalLength; i++) {
            if ((ptr2 >= nums2.length) ||
                    (ptr1 < nums1.length && nums1[ptr1] < nums2[ptr2])) {
                newNums[i] = nums1[ptr1];
                ptr1++;
            } else {
                newNums[i] = nums2[ptr2];
                ptr2++;
            }
        }
        if (totalLength % 2 == 0) {
            return (newNums[(totalLength / 2) - 1] + newNums[totalLength / 2]) / 2;
        } else {
            return newNums[totalLength / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {2, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
