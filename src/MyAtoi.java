public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("+1"));
}
    public static int myAtoi(String str){
        int res = 0;
        int i;
        boolean flag = true;
        for (i = 0; i < str.length(); i++) {//找到开头第一个字符
            char c = str.charAt(i);
            if(c == ' '){
                continue;
            }
            else if(c == '-' || c == '+'){//找到正负号
                if(c == '-')flag = false;
                //之后没有数字返回0
                if(i+1 == str.length() || (str.charAt(i+1) > '9' ||str.charAt(i+1) < '0'))
                    return 0;
                i++; //跳过负号计算数字
                break;
            }
            else if(c > '9' || c < '0'){//第一个不是负号也不是数字
                return 0;
            }
            else//找到第一个字符跳出
                break;
        }
        //开始计算数字部分
        for ( ; i < str.length(); i++) {
            if (str.charAt(i) > '0' || str.charAt(i) < '9'){
                int x = str.charAt(i) - '0';
                //超出范围输出最大或最小值
                //如果是正
                if(flag && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10)))
                    return Integer.MAX_VALUE;
                //如果是负
                if(!flag && (-res < Integer.MIN_VALUE / 10 || (-res == Integer.MIN_VALUE / 10 && -x < Integer.MIN_VALUE % 10)))
                    return Integer.MIN_VALUE;
                res = res * 10 + x;
                //下一个没数了跳出
                if (i+1 < str.length() && (str.charAt(i+1) > '9' ||str.charAt(i+1) < '0'))
                    break;
            }
        }
        return flag ? res : (-res);
    }
}
