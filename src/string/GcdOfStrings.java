package string;

/**
 * @program: Java_Learning
 * @description: 1071 字符串最大公因子
 * @author: ChaiRJ
 * @create: 2020-03-12 20:29
 **/
public class GcdOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        String sLong, sShort;
        //找到较短字符串
        sLong = str1.length() >= str2.length() ? str1 : str2;
        sShort = str1.length() >= str2.length() ? str2 : str1;

        int len = sShort.length();
        boolean tag;
        for (int i = 1; len / i > 0; i++) {
            tag = true;
            if (len % i != 0) continue;//有余数除不尽
            int width = len / i;//除数宽度
            if (sLong.length() % width != 0) continue;

            String temp = sShort.substring(0, width);
            for (int k = 0; k < len; k += width) {//判断是不是自己的因子
                if (!sShort.substring(k, k + width).equals(temp)) {
                    tag = false;
                    break;
                }
            }
            if (!tag) continue;
            for (int k = 0; k < sLong.length(); k += width) {//判断是不是自己的因子
                if (!sLong.substring(k, k + width).equals(temp)) {
                    tag = false;
                    break;
                }
            }
            if (tag) {
                return sShort.substring(0, width);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("", "    "));
        System.out.println();
    }
}
