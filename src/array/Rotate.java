package array;

import java.util.Arrays;

public class Rotate {
    /*
    * 矩阵顺时针旋转 90 度， 等于矩阵转置+行相反
    * */
    public static void rotate(int[][] matrix){
        int len = matrix.length;

        //转置矩阵
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //行相反
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = tmp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        rotate(new int[][]{{1,2},{3,4}});
    }
}
