import java.util.*;

public class LC179 {
    public String largestNumber(int[] nums) {
        List<String> list=new LinkedList<>();
        for (int num : nums) {
            list.add(""+num);
        }
        list.sort(new StringComp());
        System.out.println(list);
        StringBuilder stringBuilder=new StringBuilder();
        boolean isZero=true;
        for (String str : list) {
            if (isZero) {
                if (str.equals("0"))continue;
                else isZero=false;
            }
            stringBuilder.append(str);
        }
        if (stringBuilder.length()==0)return "0";
        return stringBuilder.toString();
    }
    static class StringComp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int len1=o1.length();
            int len2=o2.length();
            int i;
            int j=0;
            for ( i= 0; i < len2+len1; i++,j++) {
                char ch1;
                char ch2;
                if (i>=len1)
                    ch1=o2.charAt(i-len1);
                else ch1=o1.charAt(i);
                if (j>=len2)
                    ch2=o1.charAt(j-len2);
                else ch2=o2.charAt(j);
                if (ch1>ch2) return -1;
                else if (ch1<ch2) return 1;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Random random=new Random();
        int len=random.nextInt(100);
        int[] nums=new int[len];
        for (int i = 0; i < len; i++) {
            nums[i]=random.nextInt(10);
        }
        nums=new int[]{0,10,20010};
        System.out.println(new LC179().largestNumber(nums));
    }
}
