public class Offer05 {
    // 如果C++，字符串可以直接变换，可以使用双指针原地修改，空间复杂度降为 O(1)
    public String replaceSpace(String s) {
        StringBuilder newS=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' ') newS.append("%20");
            else newS.append(s.charAt(i));
        }
        return newS.toString();
    }
    public static void main(String[] args) {
        String s="We are happy.";
        System.out.println(new Offer05().replaceSpace(s));
    }

}
