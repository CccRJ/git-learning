package string;

/**
 * @program: Java_Learning
 * @description: 面试题 01。06字符串压缩
 * @author: ChaiRJ
 * @create: 2020-03-16 12:28
 **/
public class CompressString {
    public String compressString(String S){
        StringBuffer res = new StringBuffer();
        int len = S.length();
        if (len == 0)return S;
        char temp = S.charAt(0);
        res.append(temp);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (S.charAt(i) == temp){
                count++;
            }else {
                res.append(count);
                count = 1;
                temp = S.charAt(i);
                res.append(temp);
            }
        }
        res.append(count);
        return (S.length()<=res.length())?S:new String(res);
    }
}
