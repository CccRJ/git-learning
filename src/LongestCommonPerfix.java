public class LongestCommonPerfix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{}));
    }
    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0)return "";//数组是否为空
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0){//返回该字符串第一次出现的位置，必须是0
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty())return "";//字符串是否为空
            }
        }
        return prefix;
    }
}
