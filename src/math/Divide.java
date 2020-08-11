package math;

/**
 * @program: Java_Learning
 * @description: 29.两数相除 不使用乘除取余
 * @author: ChaiRJ
 * @create: 2020-05-12 21:21
 **/
public class Divide {
    public static int divide(int a, int b) {
        int ans = 0;
        boolean neg = false;
        //负数最大值 变为整数会溢出
        long x = a, y = b;
        //xy变为正数
        if (x < 0) {
            x = -x;
            neg = !neg;
        }
        if (y < 0) {
            y = -y;
            neg = !neg;
        }
        //a每次减b，如果b小于等于a的一半，就可以让b乘二，再减b
        while (x >= y) {
            long n = y;
            int r = 1;
            while (n <= (x >> 1)) {
                n <<= 1;
                r <<= 1;
            }
            x -= n;
            ans += r;
        }

        return neg ? -ans : ans;
    }

    public static void main(String[] args) {
        int n=0;
        for (int i = 1; i < 8; i+=1) {
            for (int i1 = 1; i1 < 8; i1+=1) {
                for (int i2 = 1; i2 < 8; i2+=1) {
                    for (int i3 = 1; i3 < 8; i3+=1) {
                        if (i+i1+i2+i3==10){
                            System.out.print(i+" "+i1+" "+i2+" "+i3+";");
                            n++;
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println(n);
    }
}
