import java.util.Arrays;

public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[i]) {
                    int tmp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                }
            }
            res[i]=arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1};
        System.out.println(Arrays.toString(new Offer40().getLeastNumbers(nums, 0)));
    }
}
