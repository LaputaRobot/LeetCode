import java.util.*;

public class LC784 {
    public List<String> letterCasePermutation(String s) {
        List<String> res=new ArrayList();
        List letterCaseIndex=new ArrayList();
        Deque path=new ArrayDeque();
        StringBuilder stringBuilder=new StringBuilder(s);
        for (int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if (ch>='a'&&ch<='z'){
                letterCaseIndex.add(i);
            }
            if (ch>='A'&&ch<='Z'){
                letterCaseIndex.add(i);
                stringBuilder.setCharAt(i,(char) ((char)s.charAt(i)-'A'+'a'));
            }
        }
        String s1=stringBuilder.toString();
        res.add(s1);
        dfs(s1,letterCaseIndex,0,path,res);
        return res;
    }
    public void dfs(String s,List letterCaseIndex,int start,Deque path, List res){
        if (start==letterCaseIndex.size()){
            return;
        }
        for (int i = start; i < letterCaseIndex.size(); i++) {
            path.addLast(letterCaseIndex.get(i));
            StringBuilder stringBuilder=new StringBuilder(s);
            for (Object index : path) {
                stringBuilder.setCharAt((int)index,(char) ((char)s.charAt((int)index)-'a'+'A'));
            }
            res.add(stringBuilder.toString());
            dfs(s,letterCaseIndex,i+1,path,res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        String string=new String("aBcd");
        LC784 lc784=new LC784();
        System.out.println(lc784.letterCasePermutation(string));
    }
}
