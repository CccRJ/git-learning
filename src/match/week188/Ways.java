package match.week188;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 5407. 切披萨的方案数
 * @author: ChaiRJ
 * @create: 2020-05-10 11:34
 **/
public class Ways {
    private final int MOD= (int)Math.pow(10,9)+7;
    public int ways(String[] pizza,int k){
        int row=pizza.length;
        int col=pizza[0].length();
        int[][] num=new int[row+1][col+1];//从i，j坐标到右下角的所有苹果数
        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {
                num[i][j]=num[i+1][j]+num[i][j+1]-num[i+1][j+1];
                if (pizza[i].charAt(j)=='A')num[i][j]++;
            }
        }
        int[][][] dp=new int[k][row][col];//dp[k][i][j]切了k刀剩下区域i，j的可行方案
        dp[0][0][0]=1;
        for (int n = 1; n < k; n++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (num[i][j]==0){
                        dp[n][i][j]=0;
                        continue;
                    }
                    //切了n次剩下i，j区域的切法次数
                    int count=0;
                    //横切
                    for (int l = 0; l < i; l++) {
                        int flag=num[l][j]-num[i][j];
                        if (flag!=0){
                            count+=dp[n-1][l][j];
                            count%=MOD;
                        }
                    }
                    //竖切
                    for (int l = 0; l < j; l++) {
                        int flag=num[i][l]-num[i][j];
                        if (flag!=0){
                            count+=dp[n-1][i][l];
                            count%=MOD;
                        }
                    }
                    dp[n][i][j]=count;
                }
            }
        }
        int res=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res+=dp[k-1][i][j];
                res%=MOD;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Ways w=new Ways();
        System.out.println(w.ways(new String[]{"A..", "AA.", "..."}, 3));
    }
}
