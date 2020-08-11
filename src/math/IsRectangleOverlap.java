package math;

/**
 * @program: Java_Learning
 * @description: 836 矩阵重叠 判断两个矩阵是否重叠
 * @author: ChaiRJ
 * @create: 2020-03-18 21:54
 **/
public class IsRectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1,int[] rec2){
        if (rec1[0] > rec2[0] && rec1[0] < rec2[2]
                || rec1[2] > rec2[0] && rec1[2] < rec2[2]
                || rec2[0] > rec1[0] && rec2[0] < rec1[2]
                || rec2[2] > rec1[0] && rec2[2] < rec1[2]){
            if (rec1[1] > rec2[1] && rec1[1] < rec2[3]
                    || rec1[3] > rec2[1] && rec1[3] < rec2[3]
                    || rec2[1] > rec1[1] && rec2[1] < rec1[3]
                    || rec2[3] > rec1[1] && rec2[3] < rec1[3])
                return true;
        }
        return false;
    }
}
