public class LongestPalindrome {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("aba"));
    }
    public static String longestPalindrome(String s){
        int maxi=0,maxj=0,max=0;
        int i,j;
        //回数可能是偶数可能是基数，偶数从某两个数中间向两侧取，奇数从最中间的数开始向两侧取
        for (double l = 0; l < s.length(); l += 0.5) {
            //向下向上取整
            i = (int)Math.floor(l);
            j = (int)Math.ceil(l);
            while(i >= 0 && j < s.length()){
                if(s.charAt(i) == s.charAt(j)){
                    i--;
                    j++;
                }
                else{//两侧不相等
                    break;
                }
            }
            if(j-i+1 > max){//推出循环后判断是否最长
                max = j-i+1;
                //substring左闭右开
                maxi = i+1;
                maxj = j;
            }
        }
        return s.substring(maxi,maxj);
    }
}
