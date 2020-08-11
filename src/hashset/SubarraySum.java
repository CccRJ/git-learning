package hashset;

/**
 * @program: Java_Learning
 * @description: 560.和为K的字数组
 * @author: ChaiRJ
 * @create: 2020-05-15 22:08
 **/
public class SubarraySum {
    public int subarraySum(int[] nums,int k){
        int len=nums.length;
        int ans=0;
        int sum=0;
        if (len==0)return ans;

        int l=0;
        for (int r = 0; r < len; r++) {
            sum+=nums[r];
            if (sum==k)ans++;

            while(sum>k){
                sum-=nums[l++];
                if (sum==k && l<=r){
                    ans++;
                    sum-=nums[l++];
                }
            }

        }
        return ans;
    }
}
