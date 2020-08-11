package match.week187;

/**
 * @program: Java_Learning
 * @description: 5403. 有序矩阵中的第 k 个最小数组和 BFS&DFS
 * @author: ChaiRJ
 * @create: 2020-05-03 11:42
 **/
public class KthSmallest {
    //dfs 二分，确定最大和最小和 二分得到mid
    //每次判断小于mid的数组有多少个，大于k更新r，否则更新l
    int r, c;
    int[][] tmp;
    int count;

    public int kthSmallest(int[][] mat, int k) {
        tmp = mat;
        r = mat.length;
        c = mat[0].length;
        int left = 0, right = 0;
        //最小值left最大值right
        for (int[] m : mat) {
            left += m[0];
            right += m[c - 1];
        }
        int sum = left;//每种方案的和,初始位第一列求和
        while (left < right) {
            int mid = left + (right - left) / 2;
            count = 1;//计数
            dfs(mid, 0, sum, k);
            if (count >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    /**
     * @param mid 中位数
     * @param row 当前要遍历的行
     * @param sum 当前行最小值，一次向后加，判断是否大于mid
     * @param k
     */
    private void dfs(int mid, int row, int sum, int k) {
        //如果和大于中位数，最后一行，计数已经大于k，就返回
        if (sum > mid || row == r || count > k) return;
        //带入每一行进行计算（直接对下一行进行遍历）
        dfs(mid, row + 1, sum, k);
        //当前行的每一列
        for (int i = 1; i < c; i++) {
            if (sum + tmp[row][i] - tmp[row][0] <= mid) {
                //符合条件，带入下一行（当前行增加值之后，再遍历下一行）
                count++;
                dfs(mid, row + 1, sum + tmp[row][i] - tmp[row][0], k);
            } else break;
        }
    }
}
