import java.util.HashMap;

public class LC13 {
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        int res=0;
//        HashMap<Character,Integer> map=new HashMap<>();
//        map.put('I',1);
//        map.put('V',5);
//        map.put('X',10);
//        map.put('L',50);
//        map.put('C',100);
//        map.put('D',500);
//        map.put('M',1000);
//        for (int i = 0; i < s.length(); i++) {
//            if (i<s.length()-1&&map.get(s.charAt(i))<map.get(s.charAt(i+1))){
//                res+=(map.get(s.charAt(i+1))-map.get(s.charAt(i)));
//                i++;
//            }
//            else res+=map.get(s.charAt(i));
//        }
        for (int i = 0; i < s.length(); i++) {
            if (i<s.length()-1&&getValue(s.charAt(i))<getValue(s.charAt(i+1))){
                res+=(getValue(s.charAt(i+1))-getValue(s.charAt(i)));
                i++;
            }
            else res+=getValue(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC13().romanToInt("MMCCCXLV"));
    }
}
