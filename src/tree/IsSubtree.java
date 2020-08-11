package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 572.另一个树的子树
 * @author: ChaiRJ
 * @create: 2020-05-07 20:12
 **/
public class IsSubtree {
    public int maxE, lNull, rNull;
    public List<Integer> sList = new ArrayList<>(), tList = new ArrayList<>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        maxE = Integer.MIN_VALUE;
        getMaxE(s);
        getMaxE(t);
        lNull = maxE + 1;
        rNull = maxE + 2;
        getDfsOrder(s, sList);
        getDfsOrder(t, tList);

        return kmp();
    }

    private void getMaxE(TreeNode t) {
        if (t == null) return;
        maxE = Math.max(maxE, t.val);
        getMaxE(t.left);
        getMaxE(t.right);
    }

    private void getDfsOrder(TreeNode t, List<Integer> list) {
        if (t == null) return;
        list.add(t.val);
        if (t.left != null) getDfsOrder(t.left, list);
        else list.add(lNull);
        if (t.right != null) getDfsOrder(t.right, list);
        else list.add(rNull);
    }

    private boolean kmp() {
        int sLen = sList.size(), tLen = tList.size();
        int[] next = new int[tLen];
        next[0] = -1;
        //next数组
        for (int i = 1, k = -1; i < tLen; i++) {
            if (k == -1 || tList.get(i - 1).equals(tList.get(k))) {
                k++;
                next[i] = k;
            } else {
                next[i] = 0;
                k = 0;
            }
        }
        //匹配
        for (int i = 0, j = 0; i < sLen; ) {
            if (sList.get(i).equals(tList.get(j))) {
                if (j == tLen - 1) return true;
                i++;
                j++;
            } else {
                //匹配完所有j直到首位都不相等，匹配下一位i
                if (next[j] == -1) i++;
                else j = next[j];
            }
        }
        return false;
    }

    //暴力解，同步对比
    private boolean check(TreeNode s,TreeNode t){
        if (s==null && t==null)return true;
        if ((s!=null && t==null)||(s==null&&t!=null)||(s.val!=t.val))return false;
        return check(s.left,t.left) && check(s.right,t.right);
    }
    private boolean dfs(TreeNode s,TreeNode t){
        if (s==null)return false;
        return check(s,t) || dfs(s.left,t) || dfs(s.right,t);
    }
    public boolean isSubtree2(TreeNode s,TreeNode t){
        return dfs(s,t);
    }
}
