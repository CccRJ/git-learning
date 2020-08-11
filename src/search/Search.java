package search;

public class Search {
    /*
    * 查找算法，二分查找
    * */
    public static int search(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right){
            mid =(left + right) / 2;
            if(nums[mid] == target)return mid;
            if(nums[left] <= nums[mid]){//左侧是升序
                if(target >= nums[left] && target <= nums[mid])
                    //左侧升序所以判断是否在左侧好判断，其它情况都在右侧
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else{//右侧是升序
                if(target >= nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},3));
    }
}
