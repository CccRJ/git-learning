package recursive;

import org.w3c.dom.ls.LSOutput;

public class MyPow {
    /*
    * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
    * 数组，二分查找
    * */
    public static double myPow(double x,int n){
        if(x == 0)return 0;
        int m = Math.abs(n);

        if(n > 0)return p(1,x,m);
        else return 1 / p(1,x,m);
    }
    private static double p(double res,double x,int n){
        //超出栈的大小
        if(n == 0)return res;
        return p(res * x,x,n - 1);
    }

    private static double myPow2(double x,int n){
        long N = Math.abs(n);

        if(n > 0)return p(x,N);
        else return 1 / p(x,N);
    }
    private static double p(double x,long n){
        //重载
        //对半求幂
        if(n == 0)return 1.0;
        double half = p(x,n / 2);
        if(n % 2 == 0)//n是偶数
            return half * half;
        else{//n是奇数
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(myPow2(2,-2));
    }
}
