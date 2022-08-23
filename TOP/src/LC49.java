import java.util.*;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] x=str.toCharArray();
            Arrays.sort(x);
            String sortedS=new String(x);
            if (map.containsKey(sortedS)) map.get(sortedS).add(str);
            else {
                List<String> tmp=new ArrayList<>();
                tmp.add(str);
                map.put(sortedS,tmp);
            }
        }
        for (Map.Entry<String,List<String>> e : map.entrySet()) {
            res.add(e.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs={"eat", "taa", "tan", "ate", "nat", "bat"};
        System.out.println(new LC49().groupAnagrams(strs));
    }
}
