import java.util.Arrays;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2,4}));
    }
    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        double res;
        int length = nums1.length+nums2.length;
        int[] all = new int[length];

        for (int i = 0; i < length; i++) {//将两个数组合并入新数组
            if(i < nums1.length)
                all[i] = nums1[i];
            else
                all[i] = nums2[i-nums1.length];
        }
        Arrays.sort(all);//新数组排序

        if(length%2 == 1)
            res = all[length/2];
        else
            res = (double)(all[length/2]+all[length/2-1])/2;
        return res;
    }
}
