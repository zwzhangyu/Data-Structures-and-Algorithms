package array.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 直接在数组上进行求解，双指针，一个从前往后，一个从后往前，O(n)
 * <p>
 * leetcode 1. Two Sum
 **/
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int differ = target - nums[i];
            if (map.containsKey(differ)) {
                return new int[]{map.get(differ), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        //nums = [2, 7, 11, 15], target = 9
        int[] nums = {3, 2, 4};
        int[] ints = new Solution1().twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));
    }
}
