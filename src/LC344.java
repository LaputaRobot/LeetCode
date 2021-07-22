import java.util.Arrays;

public class LC344 {
    public static void reverseString(char[] s) {
        int left=0,right=s.length-1;
        while (left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s=new char[]{'h','e','l','l','o','2'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
