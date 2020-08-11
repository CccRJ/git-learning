package match.doubleWeek30;

import java.util.HashMap;

/**
 * @program: Java_Learning
 * @description:
 * @author: ChaiRJ
 * @create: 2020-07-11 22:30
 **/
public class ReformatDate5177 {
    HashMap<String,String> MM = new HashMap<>();
    public String reformatDate(String date) {
        String[] strings = date.split(" ");
        int a = strings[0].charAt(0) - '0';
        int b = 0;
        if(strings[0].charAt(1)-'0' >=0 && strings[0].charAt(1)-'0' <= 9){
            b = strings[0].charAt(1)-'0';
            a *= 10;
        }
        int day = a + b;
        String dd = day+"";
        if(day < 10)dd = "0"+dd;
        MM.put("Jan","01");
        MM.put("Feb","02");
        MM.put("Mar","03");
        MM.put("Apr","04");
        MM.put("May","05");
        MM.put("Jun","06");
        MM.put("Jul","07");
        MM.put("Aug","08");
        MM.put("Sep","09");
        MM.put("Oct","10");
        MM.put("Nov","11");
        MM.put("Dec","12");
        String mouth = MM.get(strings[1]);
        return strings[2]+"-"+mouth+"-"+dd;
    }

    public static void main(String[] args) {
        System.out.println(new ReformatDate5177().reformatDate("10th Jan 2082"));
    }
}
