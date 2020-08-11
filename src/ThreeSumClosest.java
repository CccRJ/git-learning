import javax.xml.transform.stax.StAXResult;
import java.util.Arrays;
import java.util.Map;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums,int target){
        int len = nums.length;
        //初始化 结果和距离
        int res = nums[0] + nums[1] + nums[len-1];
        int dif = res - target;
        Arrays.sort(nums);//排序

        for (int i = 0; i < len-2; i++) {
            int sum = nums[i] + nums[i+1] + nums[len-1];//三数和
            dif = sum - target;//重置dif
            //左右指针
            int left = i + 1;
            int right = len - 1;

            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum == target){//等于目标返回结果
                    return sum;
                }
                else{
                    if(Math.abs(dif) > Math.abs(sum - target)){//距离大于现在值 替换
                        dif = sum - target;
                    }
                    if(sum - target < 0)left++;
                    if(sum - target > 0)right--;
                }
            }
            if(Math.abs(res - target) > Math.abs(dif))res = dif + target;//现在最近的距离 求出目前结果
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums= {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(threeSumClosest(nums, -2));
    }
}
