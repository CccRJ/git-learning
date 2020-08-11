package hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 146 LRU缓存机制
 * @author: ChaiRJ
 * @create: 2020-03-11 11:21
 **/
public class LRUCache extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache l1 = new LRUCache(2);
        l1.put(1, 1);
        l1.put(2, 2);
        System.out.println(l1.get(1));
        System.out.println(l1.get(3));
        l1.put(3, 3);
        l1.put(4, 4);
        System.out.println(l1.get(3));
        System.out.println(l1.get(2));

    }
}
