import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class StrComp implements Comparator{

    @Override
    public int compare(Object x, Object y) {
        String xStr = "" + x;
        String yStr = "" + y;
        int index = 0;
        while (index < xStr.length() + yStr.length()) {
            int xIndex=index%xStr.length();
            int yIndex=index%yStr.length();
            if (xStr.charAt(xIndex) < yStr.charAt(yIndex)) return -1;
            if (xStr.charAt(xIndex) > yStr.charAt(yIndex)) return 1;
            index++;
        }
        return 0;
    }
}

public class Offer45 {
    public String minNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        Integer[] nums1=new Integer[nums.length];
        for (int i = 0; i < nums.length;  i++) {
            nums1[i]=nums[i];
        }
        Arrays.sort(nums1,new StrComp());
        for (Integer num : nums1) {
            res.append(num);
        }
        return res.toString();
    }

    public boolean isBig(int x, int y) {
        String xStr = "" + x;
        String yStr = "" + y;
        int index = 0;
        while (index < xStr.length() + yStr.length()) {
            int xIndex=index%xStr.length();
            int yIndex=index%yStr.length();
            if (xStr.charAt(xIndex) < yStr.charAt(yIndex)) return false;
            if (xStr.charAt(xIndex) > yStr.charAt(yIndex)) return true;
            index++;
        }
        return false;
    }

    public String min1(int[] nums) {
        String[] strs = new String[nums.length];
        for (
                int i = 0;
                i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).

                compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (
                String s : strs)
            res.append(s);
        return res.toString();
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            int num = r.nextInt(1000);
//            if (num<0) continue;
//            if (num=)
            nums[i] = num;
        }
//        nums= new int[]{323, 32};
        System.out.println(Arrays.toString(nums));
        System.out.println(new Offer45().minNumber(nums));
        System.out.println(new Offer45().min1(nums));
    }
}
