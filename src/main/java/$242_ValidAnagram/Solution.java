package $242_ValidAnagram;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 **/
public class Solution {

    //字母异位词，俩个字符串中相同字符的数量对应相等
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']--;
            if (chars[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean anagram = new Solution().isAnagram("zlap", "kcqx");
        System.out.println(anagram);
    }
}