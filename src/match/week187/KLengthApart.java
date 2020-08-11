package match.week187;

/**
 * @program: Java_Learning
 * @description: 5401 是否所有 1 都至少相隔 k 个元素
 * @author: ChaiRJ
 * @create: 2020-05-03 10:38
 **/
public class KLengthApart {
    public static boolean kLengthApart(int[] nums, int k) {
        if (k==0)return true;
        int pre=-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1 && pre==-1){
                pre=i;
                continue;
            }
            else if (nums[i]==1 && pre != -1 && i-pre-1<k){
                return false;
            }
            else if (nums[i]==1)
                pre=i;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1,0,0,1,0,1},2));
    }
}
