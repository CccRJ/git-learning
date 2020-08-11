package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 6.Z字形变换
 * @author: ChaiRJ
 * @create: 2020-05-05 20:40
 **/
public class Convert {
    public static String convert(String s, int numRows) {
        int len = s.length();
        if (len<numRows || numRows==1)return s;
        List<StringBuffer> list = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }
        for (int i = 0; i < len;) {
            if (num == 0) {
                for (num = 0; num < numRows; num++) {
                    if (i == len) break;
                    list.get(num).append(s.charAt(i++));
                }
            }
            if (num == numRows) {
                for (num = numRows - 2; num > 0; num--) {
                    if (i == len) break;
                    list.get(num).append(s.charAt(i++));
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (StringBuffer l : list) {
            sb.append(l);
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
}
