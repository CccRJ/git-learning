package string;

public class StrStr {
    /*
    * 字符串匹配 KMP算法
    * */
    public static int[] getNext(char[] n){
        /*
        * KMP算法比较j的前一位j-1的值和next[j-1]处的值
        * 不等则继续next[next[j-1]]处比较以此类推
        * 相等时next[]等于 相等处next值+1
        * */
        int[] next = new int[n.length];
        next[0] = -1;
        if(n.length > 1)next[1] = 0;
        int k;
        for (int j = 2; j < n.length; j++) {
            k = next[j - 1];//j前一位的next值
            while(k != -1){
                if(n[k] == n[j - 1]){//一直用j-1处的值进行比较
                    next[j] = k + 1;
                    break;
                }
                else
                    k = next[k];//向前追溯
                next[j] = 0;//先默认为0，如果替换就break了
            }
        }
        return next;
    }
    public static int KMP(String haystack,String needle){
        if(haystack.length() == 0 && needle.length() != 0)return -1;
        else if(needle.length() == 0)return 0;
        char[] h_arr = haystack.toCharArray();
        char[] n_arr = needle.toCharArray();
        int[] next = getNext(n_arr);
        int i = 0;
        int j = 0;
        while(i < h_arr.length && j < n_arr.length){
            if(j == -1 || h_arr[i] == n_arr[j]){
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if(j == n_arr.length)//匹配整个字符串
            return i - j;
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(KMP("aaaaac","ac"));
    }
}
