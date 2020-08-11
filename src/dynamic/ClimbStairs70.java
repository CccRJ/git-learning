package dynamic;

public class ClimbStairs70 {
    /*
    * 70 爬楼梯
    * 每次你可以爬 1 或 2 个台阶。
    * 你有多少种不同的方法可以爬到楼顶n
    * res[n] = res[n-1] + res[n-2]
    * */
    public static int climbStairs(int n){
        if(n <= 2)return n;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}
