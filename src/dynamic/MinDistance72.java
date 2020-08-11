package dynamic;

/**
 * @program: Java_Learning
 * @description: 72.编辑距离（动态规划）
 * @author: ChaiRJ
 * @create: 2020-05-08 22:22
 **/
public class MinDistance72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        //空字符串
        if (len1 * len2 == 0) return len1 + len2;
        //dp数组，word1前i个字符和word2前j个字符之间的距离
        int[][] dp = new int[len1 + 1][len2 + 1];

        //边界状态初始化
        for (int i = 0; i < len1+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < len2+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                int up = dp[i - 1][j] + 1;
                int left = dp[i][j - 1] + 1;
                int left_up = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_up++;
                dp[i][j] = Math.min(Math.min(left, up), left_up);
            }
        }
        return dp[len1][len2];
    }
}
