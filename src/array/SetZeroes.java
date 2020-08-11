package array;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    /*
    * 73 矩阵置零
    * 将矩阵中0元素的位置 的行和列 都换成0
    * HashSet
    * */
    public static void setZeroes(int[][] matrix){
        int lenX = matrix.length;
        if(lenX == 0) System.out.println(0);
        int lenY = matrix[0].length;
        //行列只需记录一次使用set
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        //找到0点的行列
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        //包含该行或列 置0
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                if(rows.contains(i) || cols.contains(j))
                    matrix[i][j] = 0;
            }
        }


        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }
}
