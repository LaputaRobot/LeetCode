import java.util.ArrayList;
import java.util.Arrays;

public class LC135 {
    public int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        ArrayList<Integer> bottoms = new ArrayList<>();
        int res = 0;
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                if (ratings[i] < ratings[i + 1]) {
                    bottoms.add(i);
                    candies[i] = 1;
                } else if (ratings[i] == ratings[i + 1]) candies[i] = 1;
            } else if (i == ratings.length - 1) {
                if (ratings[i] < ratings[i - 1]) {
                    bottoms.add(i);
                    candies[i] = 1;
                } else if (ratings[i] == ratings[i - 1]) candies[i] = 1;
            } else {
                if ((ratings[i - 1] > ratings[i] && ratings[i] <= ratings[i + 1]) || (ratings[i - 1] >= ratings[i] && ratings[i] < ratings[i + 1])) {
                    bottoms.add(i);
                    candies[i] = 1;
                } else if (ratings[i - 1] == ratings[i] && ratings[i] == ratings[i + 1]) candies[i] = 1;
            }
        }
        for (int b : bottoms) {
            int i = b;
            while (i - 1 >= 0 && ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
                i--;
            }
            i = b;
            while (i + 1 < ratings.length && ratings[i + 1] > ratings[i]) {
                candies[i + 1] = Math.max(candies[i] + 1, candies[i + 1]);
                i++;
            }
        }
        System.out.println(bottoms);
        for (int c : candies) {
            res += c;
        }
        return res;
    }

    public int candy0817(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (len == 1 || ratings[1] >= ratings[0]) {
                    candies[i] = 1;
                }
            } else if (i == len - 1) {
                if (ratings[i] <= ratings[i - 1]) {
                    candies[i] = 1;
                }
            } else {
                if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                    candies[i] = 1;
                }
            }
        }
        for (int i = 0; i < len - 1; i++) {
            if (candies[i] == 1) {
                while (i<len-1&&ratings[i + 1] >= ratings[i]) {
                    if (ratings[i + 1] > ratings[i])
                        candies[i + 1] = candies[i] + 1;
                    else
                        candies[i + 1] = 1;
                    i++;
                }
            }
        }
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            res += candies[i];
            if (candies[i] == 1) {
                while (i > 0 && ratings[i - 1] >= ratings[i]) {
                    if (ratings[i - 1] > ratings[i])
                        candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
                    else
                        candies[i - 1] = Math.max(1, candies[i - 1]);
                    res += candies[i - 1];
                    i--;
                }
            }
        }
        System.out.println(Arrays.toString(candies));
        return res;
    }


    public int  candy0818(int[] ratings){
        if (ratings.length==1) return 1;
        int res=1;
        int incLen=1;
        int pre=1;
        int decLen=0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i]==ratings[i-1]){
                res+=1;
                pre=1;
                incLen=1;
                decLen=0;
            }else if (ratings[i]>ratings[i-1]){
                decLen=0;
                res+=(++pre);
                incLen=pre;
            }else {
                res+=(decLen+1);
                decLen++;
                if (incLen==decLen){
                    decLen++;
                    res++;
                }
                pre =1;
            }

        }
        return res;
    }
    public int answer(int[] ratings){
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
            System.out.print("["+ratings[i]+": "+ret+"], ");
        }
        System.out.println();
        return ret;
    }
    public static void main(String[] args) {
        int[] ratings=new int[]{58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
        System.out.println(new LC135().candy0817(ratings));
        System.out.println(new LC135().candy0818(ratings));
        System.out.println(new LC135().answer(ratings));
    }
}
