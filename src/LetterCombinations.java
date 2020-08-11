import javax.swing.text.EditorKit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        System.out.println(lc.letterCombinations("234"));
    }

    private List<String> data = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits){

        Collections.addAll(data,"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");

        if(digits.equals(""))return list;//判断非空

        String s = "";//存储当前拼接的字符串
        addCurrentChar(digits,0,s);

        return list;
    }
    public void addCurrentChar(String digits,int index,String s){
        if(index == digits.length()){//拼接完每一位，加入list
            list.add(s);
            return;
        }
        int n = digits.charAt(index) - '0';//当前为字符串索引
        String sCurrent = data.get(n-2);//当前位的字符串
        for (int i = 0; i < sCurrent.length(); i++) {
            //递归 带入继续加入下一个数字的字母
            addCurrentChar(digits,index + 1,s + sCurrent.charAt(i));
        }
    }
}
