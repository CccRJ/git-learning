package list;

/**
 * @program: Java_Learning
 * @description: 440. 字典序的第K小数字
 * @author: ChaiRJ
 * @create: 2020-06-30 15:44
 **/
public class DicFindKthNumber440 {
    public int findKthNumber(int n, int k) {
        int pre = 1;//当前前缀
        int cur = 1;//当前查询到底几个数
        while (cur < k) {
            //获得当前前缀下的子节点数
            int count = getCount(pre, n);
            //如果但前位置加当前位置的子节点数大于k，则k在当前子节点下
            //否则k在之后的前缀节点下
            if (cur + count > k) {
                pre *= 10;//前缀*10，进入下一层
                cur++;//当前是第几个数，加一
            } else {
                pre++; //不在当前节点下，进入下一个前缀节点
                cur += count;//当前第几个数，加上当前节点下的所有子节点
            }
        }
        return pre;
    }

    /**
     * 找到当前前缀下所有的子节点数
     * cur = 1，next = 2 则count += 1；
     * cur = 10 next = 20 则count += 10；
     */
    private int getCount(int pre, int n) {
        long cur = pre;//当前前缀
        long next = pre + 1;//下一个前缀
        int count = 0;
        while (cur <= n) {
            //下一个前缀减去当前前缀=当前前缀这一层的所有节点
            //如果next值大于n则需要用（n+1）-cur
            count += Math.min(next, n + 1) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }
}
