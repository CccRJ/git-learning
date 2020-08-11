import java.util.Arrays;

public class FirstMissingPositive {
    /*
    * 从未排序数组中，找到第一个没有出现的正整数
    * 时间复杂度O（n）空间复杂度为常数
    * */
    public static int firstMissingPositive(int[] nums){
        Arrays.sort(nums);//排序

        int len = nums.length;
        if(len == 0)return 1;
        int last = nums[len - 1];
        if(last <= 0)return 1;//最大值小于0

        int i;
        for (i = 0; i < len - 1; i++) {//找到0的索引
            if(nums[i] >= 0)break;
        }
        if(nums[i]>1)return 1;
        //判断是否连续
        while(i < len - 1 && (nums[i] + 1 == nums[i+1] || nums[i] == nums[i+1]))i++;
        return nums[i] + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{-10,-3,-100,-1000,-239,1}));
    }
}
