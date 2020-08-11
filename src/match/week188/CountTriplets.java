package match.week188;

/**
 * @program: Java_Learning
 * @description: 5405. 形成两个异或相等数组的三元组数目
 * @author: ChaiRJ
 * @create: 2020-05-10 10:47
 **/
public class CountTriplets {
    public int countTriplets(int[] arr) {
        int count=0;
        int len=arr.length;
        if (len<2)return count;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j; k < len; k++) {
                    int a=0,b=0;
                    for (int x=i;x<j;x++)
                        a=a^arr[x];
                    for (int x=j;x<=k;x++)
                        b=b^arr[x];
                    if (a==b)count++;
                }
            }
        }
        return count;
    }
}
