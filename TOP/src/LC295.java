import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0) {
            maxHeap.add(num);
            return;
        }
        if (num == maxHeap.peek()) {
            if (maxHeap.size() > minHeap.size()) minHeap.add(num);
            else maxHeap.add(num);
        } else if (num < maxHeap.peek()) {
            maxHeap.add(num);
        } else minHeap.add(num);
        if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
        if (maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == 0) return 0;
        if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
            if (minHeap.size()>0)
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
            else return maxHeap.peek();
        }
        else return maxHeap.peek();
    }
}

class MedianFinder1 {
    TreeMap<Integer, Integer> nums;
    int n;
    int[] left;
    int[] right;

    public MedianFinder1() {
        nums = new TreeMap<Integer, Integer>();
        n = 0;
        left = new int[2];
        right = new int[2];
    }

    public void addNum(int num) {
        nums.put(num, nums.getOrDefault(num, 0) + 1);
        if (n == 0) {
            left[0] = right[0] = num;
            left[1] = right[1] = 1;
        } else if ((n & 1) != 0) {
            if (num < left[0]) {
                decrease(left);
            } else {
                increase(right);
            }
        } else {
            if (num > left[0] && num < right[0]) {
                increase(left);
                decrease(right);
            } else if (num >= right[0]) {
                increase(left);
            } else {
                decrease(right);
                System.arraycopy(right, 0, left, 0, 2);
            }
        }
        n++;
    }

    public double findMedian() {
        return (left[0] + right[0]) / 2.0;
    }

    private void increase(int[] iterator) {
        iterator[1]++;
        if (iterator[1] > nums.get(iterator[0])) {
            iterator[0] = nums.ceilingKey(iterator[0] + 1);
            iterator[1] = 1;
        }
    }

    private void decrease(int[] iterator) {
        iterator[1]--;
        if (iterator[1] == 0) {
            iterator[0] = nums.floorKey(iterator[0] - 1);
            iterator[1] = nums.get(iterator[0]);
        }
    }
}

public class LC295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
//        Random random=new Random();
//        int len=random.nextInt(1000);
//        int[] nums=new int[len];
//        for (int i = 0; i < len; i++) {
//            nums[i]=random.nextInt(1000);
//            medianFinder.addNum(nums[i]);
//        }
//        Arrays.sort(nums);
//        if (len%2==0)
//            System.out.println((nums[(len-1)/2]+nums[(len-1)/2+1])/2.0);
//        else
//            System.out.println(nums[(len-1)/2]);
//        System.out.println(Arrays.toString(nums));
        System.out.println(medianFinder.findMedian());
    }
}
