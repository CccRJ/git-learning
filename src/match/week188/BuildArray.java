package match.week188;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 5404. 用栈操作构建数组
 * @author: ChaiRJ
 * @create: 2020-05-10 10:32
 **/
public class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans=new ArrayList<>();
        int len=target.length;
        if (len==0)return ans;
        int count=0;
        for (int i = 1; i <= n; i++) {
            if (i==target[count]){
                ans.add("Push");
                count++;
            }
            else {
                ans.add("Push");
                ans.add("Pop");
            }
            if (count==len)break;
        }
        return ans;
    }
}
