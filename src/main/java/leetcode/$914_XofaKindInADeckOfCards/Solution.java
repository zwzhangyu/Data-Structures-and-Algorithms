package leetcode.$914_XofaKindInADeckOfCards;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        //计数统计
        Map<Integer, Integer> timeMap = new HashMap<>();
        for (int key : deck) {
            timeMap.put(key, timeMap.containsKey(key) ? timeMap.get(key) + 1 : 1);
        }
        //求最大公约数
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : timeMap.entrySet()) {
            res = gcd(entry.getValue(), res);
        }
        return res >= 2;
    }

    public int gcd(int num1, int num2) {
        // 利用辗转相除法来计算最大公约数
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1, 1, 1, 4, 4, 4, 3, 3, 3};
        System.out.println(solution.hasGroupsSizeX(input));

    }
}
