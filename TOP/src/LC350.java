import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class LC350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap1=new HashMap<>();
        HashMap<Integer,Integer> hashMap2=new HashMap<>();
        for (int num : nums1) {
            hashMap1.put(num,hashMap1.getOrDefault(num,0)+1);
        }
        for (int num : nums2) {
            hashMap2.put(num,hashMap2.getOrDefault(num,0)+1);
        }
        int[] tmp = new int[Math.min(nums1.length,nums2.length)];
        int i=0;
        if (hashMap1.size()>hashMap2.size()) {
            for (Integer key: hashMap2.keySet()) {
                if (hashMap1.containsKey(key)){
                    int times=Math.min(hashMap1.get(key),hashMap2.get(key));
                    for (int j = 0; j < times; j++) {
                        tmp[i++]=key;
                    }
                }
            }
        }
        else {
            for (Integer key: hashMap1.keySet()) {
                if (hashMap2.containsKey(key)){
                    int times=Math.min(hashMap1.get(key),hashMap2.get(key));
                    for (int j = 0; j < times; j++) {
                        tmp[i++]=key;
                    }
                }
            }
        }
        return Arrays.copyOf(tmp,i);
    }
    public int[] intersect1(int[] nums1, int[] nums2) {
        int[] counting1=new int[1001];
        int[] counting2=new int[1001];
        for (int num : nums1) {
            counting1[num]+=1;
        }
        for (int num : nums2) {
            counting2[num]+=1;
        }
        int[] tmp=new int[1001];
        int index=0;
        for (int i = 0; i < counting1.length; i++) {
            if (counting1[i]!=0&&counting2[i]!=0){
                int times=Math.min(counting1[i],counting2[i]);
                for (int j = 0; j < times; j++) {
                    tmp[index++]=i;
                }
            }
        }
        return Arrays.copyOf(tmp,index);
    }
    public static void main(String[] args) {
        int[] nums1={1,2,3,4,4,1};
        int[] nums2={2,2,3,3,4,4,5};
        System.out.println(Arrays.toString(new LC350().intersect1(nums1, nums2)));
    }
}
