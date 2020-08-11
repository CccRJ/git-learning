package string;

/**
 * @program: Java_Learning
 * @description: 125 验证回文串 字符串是否是回文串，忽略字母大小写
 * @author: ChaiRJ
 * @create: 2020-02-25 20:47
 **/
public class IsPalindrome {
    public static boolean isPalindrome(String s){
        if(s.length() == 0)return true;

        s = s.toLowerCase();

        int right = s.length() - 1;
        int left = 0;
        while (left < right){//跳过无用字符
            while(!Character.isLetterOrDigit(s.charAt(left)) && left < s.length() - 1)
                left ++;
            while(!Character.isLetterOrDigit(s.charAt(right)) && right > 0)
                right --;
            if(left > right)return true;//只剩下无用字符
            if(s.charAt(left) != s.charAt(right))return false;
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("p p"));
    }
}
