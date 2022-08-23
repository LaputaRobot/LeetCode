public class Offer58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder newS=new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            newS.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            newS.append(s.charAt(i));
        }
        return newS.toString();
    }
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }
    public static void main(String[] args) {
        System.out.println(new Offer58().reverseWords("a good   exampl"));
    }
}
