package leetcode.$1202_smallestStringWithSwaps;

import java.util.*;

/**
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 * <p>
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 **/
public class Solution {

    private int[] parent = new int[100000];

    int find(int root) {
        int son, tmp;
        son = root;
        //找祖先节点
        while (root != parent[root])
            root = parent[root];
        while (son != root)//路径压缩
        {
            tmp = parent[son];
            parent[son] = root;
            son = tmp;
        }
        return root;
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        //第一步：初始化
        int len = s.length();
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
        //第二步：合并
        for (List<Integer> pair : pairs) {
            parent[find(pair.get(0))] = pair.get(1);
        }
        //第三步：分组加入集合中
        Map<Integer, PriorityQueue<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.computeIfAbsent(find(i), v -> new PriorityQueue<>()).add(String.valueOf(s.charAt(i)));
        }
        //依次取出每个集合元素
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(map.get(find(i)).poll());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> objects1 = new ArrayList<>();
        objects1.add(0);
        objects1.add(3);
        ArrayList<Integer> objects2 = new ArrayList<>();
        objects2.add(1);
        objects2.add(2);

        ArrayList<Integer> objects3 = new ArrayList<>();
        objects3.add(0);
        objects3.add(2);
        list.add(objects1);
        list.add(objects2);
        list.add(objects3);
        String dcab = new Solution().smallestStringWithSwaps("dcab", list);
        System.out.println(dcab);


    }


}
