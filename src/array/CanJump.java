package array;

public class CanJump{
    /*
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     * */
    public static boolean jumpPoint(int[] nums,int end){
        //找到能跳到最后位置的点，再将这些点进行递归
        if(nums[0] >= end)return true;
        for (int i = end - 1; i >= 0; i--) {
            if(nums[i] >= end - i){
                boolean res = jumpPoint(nums,i);
                if(res) return res;
            }
        }
        return false;
    }
    public static boolean jumpPoint2(int[] nums,int start){
        //起始位置能到达的最大长度，从远到近，进行递归
        if(start + nums[start] >= nums.length - 1)return true;
        for (int i = start + nums[start]; i > start ; i--) {
            boolean res = jumpPoint2(nums,i);
            if(res) return true;
        }
        return false;
    }
    public static boolean canJump(int[] nums){
        /*
        * 如果全是正数则可达，导致不可达的是0点
        * 判断0 点前是否有点可以跳过0点，有则成功，没有则不可达
        * */
        int len = nums.length;
        if(len == 1)return true;
        if(nums[0] == 0)return false;
        for (int i = len - 2; i >= 0; i--) {//从倒数第二个开始遍历
            if(nums[i] == 0){//碰到 0 找寻前面元素能否跳过这个 0
                for (int j = i; j >= 0; j--) {
                    if(j + nums[j] > i){//可以跳过
                        i = j;//更新位置
                        break;
                    }
                    else if(j == 0)//失败
                        return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{5,4,3,2,1,0,0}));
    }


}
