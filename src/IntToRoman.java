public class IntToRoman {
    public static void main(String[] args) {

    }
    public static String intToRoman(int num){
        StringBuffer s = new StringBuffer();
        int rem;
        while(num % 10 == 0){
            rem = num % 10;
            switch (rem){
                case 4:
                    s.append("VI");
                    break;
                case 9:
                    s.append("XI");
                default:

            }
        }
        return "";
    }
}
