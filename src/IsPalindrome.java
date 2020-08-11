public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12));
        System.out.println(new StringBuffer("123"));
    }
    public static boolean isPalindrome(int x){
        boolean res;
        String s1 = String.valueOf(x);
        System.out.println(s1);
        String s2 = new StringBuffer(s1).reverse().toString();
        return s1.equals(s2);
    }
}
