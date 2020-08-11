package array;

/**
 * @program: Java_Learning
 * @description: 680验证回文字符串
 * @author: ChaiRJ
 * @create: 2020-05-19 20:59
 **/
public class ValidPalindrome {
    boolean flag=false;
    public boolean validPalindrome(String s) {
        int len=s.length();
        int left=0,right=len-1;

        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
                continue;
            }
            else if(flag==true)return false;
            else{
                flag=true;
                return validPalindrome(s.substring(left,right)) || validPalindrome(s.substring(left+1,right+1));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(1);
        String stirng;
    }
}
