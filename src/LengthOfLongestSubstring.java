public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        int max = lengthOfLongestSubstring("nfpdmpi");
        System.out.println(max);
    }
    public static int lengthOfLongestSubstring(String s){
        /*
        * 从j开始向前判断是否有相同字符，如果没有j加1,max等于j-i+1
        * 如果有相同字符当前max是j-k
        * i从相同字符的下一个字符开始
        * j继续向后加
        * */
        if(s.length()==0)return 0;
        int max = 1;//最大长度
        int i=0,j=1;
        boolean flag = true;
        while(j<s.length()){
            for (int k = j-1; k >= i; k--) {
                if(s.charAt(j) == s.charAt(k)){//判断最后一个字符是否和前面有相同
                    flag = false;
                    i = k+1;
                    if(max < j-k) max = j-k;//出现相同时，当前长度
                    break;
                }
            }
            if(flag) max = Math.max(max,j-i+1);//判断当前最大值和max
            flag = true;
            j++;
        }
        return max;
    }
}
