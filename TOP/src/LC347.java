import java.util.*;

public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>(hashMap.size(), new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        queue.addAll(hashMap.entrySet());
//        ArrayList<Map.Entry<Integer,Integer>> arrayList=new ArrayList<>(hashMap.size());
//        arrayList.addAll(hashMap.entrySet());
//        arrayList.sort(Comparator.comparingInt(Map.Entry::getValue));
//        for (int i = 0; i < k; i++) {
//            res[i]=arrayList.get(hashMap.size()-1-i).getKey();
//        }
        for (int i = 0; i < k; i++) {
            res[i]=queue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3,3,4,2,5,2,4,5,1,1,4,5,3,1}, 4)));
    }
}
