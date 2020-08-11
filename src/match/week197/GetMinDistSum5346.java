package match.week197;

/**
 * @program: Java_Learning
 * @description: 5463. 服务中心的最佳位置
 * @author: ChaiRJ
 * @create: 2020-07-12 15:14
 **/
public class GetMinDistSum5346 {
    public double getMinDistSum(int[][] positions){
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        double eps = Math.pow(1,-8);//结束的步长
        double t = 0.98;//步频缩小百分比
        double x = 0,y = 0;
        double min = Double.MAX_VALUE;
        double step = 100;

        while (step > eps){
            boolean flag = true;
            while (flag) {//如果没有缩小方向，需要缩小步幅
                flag = false;
                //四个方向寻找，找到最小方向
                for (int i = 0; i < 4; i++) {
                    double nx = x + dir[i][0] * step;
                    double ny = y + dir[i][1] * step;
                    double tmp = 0;
                    for (int[] position : positions) {
                        tmp += dis(position[0], position[1], nx, ny);
                    }
                    if (tmp < min) {
                        min = tmp;
                        x = nx;
                        y = ny;
                        flag = true;
                    }
                }
            }
            step *= t;
        }
        return min;
    }
    private double dis(double x1,double y1,double x2,double y2){
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
