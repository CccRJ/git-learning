package hashmap;

import java.util.*;

public class RelativeSortArray {
    /*
    * 1122
    * 给你两个数组，arr1 和 arr2，
        arr2 中的元素各不相同
        arr2 中的每个元素都出现在 arr1 中
        对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
        * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
    * */
    public static int[] relativeSortArray(int[] arr1,int[] arr2){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i],i);
        }
        Integer[] num = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            num[i] = arr1[i];
        }

        Arrays.sort(num, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if(!map.containsKey(i1) && map.containsKey(i2))return 1;
                else if(map.containsKey(i1) && !map.containsKey(i2))return -1;
                else if(!map.containsKey(i1) && !map.containsKey(i2))return i1 - i2;
                else return map.get(i1) - map.get(i2);
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = num[i];
        }
        return arr1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},
                new int[]{2,1,4,3,9,6})));
    }
}
