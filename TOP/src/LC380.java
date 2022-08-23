import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer,Integer> hashMap;
    Random random=new Random();
    public RandomizedSet() {
        list=new ArrayList<>();
        hashMap=new HashMap<>();
    }

    public boolean insert(int val) {
        if (hashMap.containsKey(val))return false;
        else {
            hashMap.put(val,list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!hashMap.containsKey(val))return false;
        else {
            int index=hashMap.get(val);
            int newV=list.get(list.size()-1);
            list.set(index,newV);
            hashMap.put(newV,index);
            list.remove(list.size()-1);
            hashMap.remove(val);
            return true;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
public class LC380 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet=new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(1);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
    }
}
