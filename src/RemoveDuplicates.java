public class RemoveDuplicates {
    /*
    * 将给定数组中重复元素删除
    * 把不重复元素放在前n位，并返回新数组长度
    * 额外只能使用O(1)空间
    * */
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{}));
    }
    public static int removeDuplicates(int[] nums){
        int len = nums.length, res = 1;//第一位默认放在对的位置
        if(len == 0)return 0;
        if(len == 1)return 1;
        for (int i = 1; i < len; i++) {
            //当前不同位数放在res位置
            if(nums[i] == nums[i - 1]);
            else {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }
}
