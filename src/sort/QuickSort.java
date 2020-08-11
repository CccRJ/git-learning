package sort;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 快排实现
 * @author: ChaiRJ
 * @create: 2020-06-02 12:16
 **/
public class QuickSort {
    public static void QuickSort(int[] nums,int start,int end){
        if(start >= end)return;
        int key = nums[start];

        int l = start,r=end;
        while (l < r){
            while (l < r && nums[r] >= key){
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= key){
                l++;
            }
            nums[r] =nums[l];
        }
        nums[l]= key;
        QuickSort(nums,start,l-1);
        QuickSort(nums,l+1,end);
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,1,1,7,9,8,6,4,2,0};
        QuickSort(n,0,9);
        System.out.println(Arrays.toString(n));
    }
}
