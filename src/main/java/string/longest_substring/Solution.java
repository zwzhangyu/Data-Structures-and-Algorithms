package string.longest_substring;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author zhangyu
 * @date 2023/3/28
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            // 检查当前元素是否已经在map中
            if (map.containsKey(alpha)) {
                // 更新滑动窗口，即整体向右移
                start = Math.max(map.get(alpha), start);
            }
            // 更新最大不重复子串长度
            ans = Math.max(ans, end - start + 1);
            // 将当前元素添加到map中
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}
