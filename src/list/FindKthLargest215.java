package list;

import java.util.PriorityQueue;

/**
 * @program: Java_Learning
 * @description: 215. 数组中的第K个最大元素
 * @author: ChaiRJ
 * @create: 2020-06-29 13:44
 **/
public class FindKthLargest215 {
    //堆排序
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() < num) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }

    //
    private int partition(int[] nums, int start, int end) {
        if (start == end) return start;
        int l = start, r = end;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && pivot >= nums[r]) r--;
            nums[l] = nums[r];
            while (l < r && pivot <= nums[l]) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
    public int findKthLargest2(int[] nums,int k){
        int low = 0,high = nums.length-1;
        int pivot = partition(nums, low, high);
        while (pivot!=k-1){
            if (pivot > k-1){
                high = pivot-1;
            } else {
                low = pivot+1;
            }
            pivot = partition(nums,low,high);
        }
        return nums[pivot];
    }

}
