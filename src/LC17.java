import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {

    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if (digits.length()==0) return res;
        StringBuilder stringBuilder=new StringBuilder();
        addChar(res,0,stringBuilder,digits);
        return res;
    }
    public void addChar(List<String> res,int digitIndex,StringBuilder stringBuilder,String digits){
        if (stringBuilder.length()==digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        else {
            for (int i = 0; i < phoneMap.get(digits.charAt(digitIndex)).length(); i++) {
                stringBuilder.append(phoneMap.get(digits.charAt(digitIndex)).charAt(i));
                addChar(res,digitIndex+1,stringBuilder,digits);
                stringBuilder.deleteCharAt(digitIndex);
            }
        }
    }
    public static void main(String[] args) {
        String s="7";
        System.out.println(new LC17().letterCombinations(s));
    }
}
