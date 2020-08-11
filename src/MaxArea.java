public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,3,20,20,6,7}));
    }
    public static int maxArea(int[] height){
        /*
        * 从两侧开始向中间缩进，两个数值的较小值决定最终面积
        * 较短侧向较长侧移动，（移动较长侧，总面积受限于较短侧，面积不会增大）
        * */
        int maxarea = 0;
        int i = 0, j = height.length - 1;
        while(i < j){
            maxarea = Math.max(maxarea,(j-i) * Math.min(height[i],height[j]));
            if (height[i] > height[j])j--;
            else i++;
        }
        return maxarea;
    }
}
