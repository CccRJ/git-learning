package array;

import java.util.Arrays;

public class MergeTwoArrays {
    /*
    * 88 合并两个有序数组
    * */
    public void merge(int[] nums1,int m,int[] nums2,int n){
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
    /*
    *
    * 将指定源数组中的数组从指定位置复制到目标数组的指定位置。
    * arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
    * */
    public void merge2(int[] nums1,int m,int[] nums2,int n){
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
    /*
    * 双指针，从后向前
    * */
    public void merge3(int[] nums1,int m,int[] nums2,int n){
        int x = m - 1,y = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            //两个数组有一个比较晚直接将另一个赋值即可
            if(x < 0){
                nums1[i] = nums2[y];
                y--;
                continue;
            }
            else if(y < 0){
                break;
            }
            //比较最大位
            if(nums1[x] > nums2[y]){
                nums1[i] = nums1[x];
                x--;
            }
            else{
                nums1[i] = nums2[y];
                y--;
            }
        }
    }

    public static void main(String[] args) {
        MergeTwoArrays m = new MergeTwoArrays();
        m.merge3(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}
