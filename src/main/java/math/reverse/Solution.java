package math.reverse;


/**
 * @Author zhangyu
 * @Date 2020/6/13
 * @Description 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 leetcode 7. Reverse Integer
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  23^1 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 **/

public class Solution {

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    public static void main(String[] args) {
        int reverse = new Solution().reverse(120);
        System.out.println(reverse);
    }

}
