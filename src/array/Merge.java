package array;

import java.util.Arrays;
import java.util.Comparator;

public class Merge {
    /*
    * 56 合并区间
    * 给出一个区间的集合，请合并所有重叠的区间。
    * 输入合并后的区间数组
    * */
    public static int[][] merge(int[][] intervals){
        if(intervals.length == 0)return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0])return a[1] - b[1];
                else return a[0] - b[0];
            }
        });
        int[][] res = new int[intervals.length][intervals[0].length];//原先长度
        res[0] = intervals[0];
        int j = 0;//结果数组指针
        for (int i = 1; i < intervals.length; i++) {
            //左区间大于等于结果数组当前区间，右区间比大小
            if(intervals[i][0] >= res[j][0] && intervals[i][0] <= res[j][1]){
                if(intervals[i][1] > res[j][1]){
                    res[j][1] = intervals[i][1];
                }
            }
            else if(intervals[i][0] > res[j][1]){
                res[++j] = intervals[i];//把数组添加进结果
            }
        }
        return Arrays.copyOfRange(res,0,j + 1);//删除最后面的0数组
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,3},{3,5},{6,8}})));
    }
}
