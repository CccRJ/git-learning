package match.week196;

/**
 * @program: Java_Learning
 * @description: 5454. 统计全 1 子矩形
 * @author: ChaiRJ
 * @create: 2020-07-05 14:15
 **/
public class NumSubmat5454 {
    public int numSubmat(int[][] mat) {
        int ans = 0;
        int row = mat.length,col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //由i，j为左上角坐标
                if (mat[i][j] != 0){
                    int right = col,down = row;
                    for (int x = i; x < down; x++) {
                        for (int y = j; y < right; y++) {
                            //遍历右下角坐标
                            //如果有0节点，则该节点的又下侧所有节点都不用遍历了
                            if (mat[x][y] == 0){
                                right=y;
                                continue;
                            }
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
