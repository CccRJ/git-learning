package queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: Java_Learning
 * @description: topk问题
 * @author: ChaiRJ
 * @create: 2020-06-02 14:06
 **/
public class TopK215 {
    /**
     * 小顶堆，找到最大的前k个元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKMax(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() < num) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    /**
     * 找到最小的k个元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKMin(int[] nums, int k) {
        if (k==0)return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() > num) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    //找到轴心点的位置
    public static int partition(int arr[], int start, int end) {

        int left = start, right = end;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;//返回中间点位置
    }

    // 找到第k个最大数并返回
    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];
        int i = partition(arr, left, right);
        int leftLen = i - left;//数组前半部分元素个数

        //等于k直接返回轴心值
        if (leftLen==k)return arr[i-1];
        else if (leftLen > k) {
            //大于k 求前部分第k大
            return quickSelect(arr, left, i - 1, k);
        } else {
            //小于k 求后半分部分第k-i大
            return quickSelect(arr, i + 1, right, k - i);
        }
    }

    public static int[] quickSelectTopK(int[] arr, int k) {
        int len = arr.length;
        if (len <= k) return arr;

        int low = 0, high = arr.length - 1;
        int pivot = partition(arr, low, high);
        //轴点不是k，继续找轴点
        while (pivot != k) {
            if (k > pivot)
                low = pivot + 1;
            else
                high = pivot - 1;
            pivot = partition(arr, low, high);
        }
        return Arrays.copyOfRange(arr,0,k);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{12, 3, 4, 5, 56, 7, 7, 8, 8, 6};
        System.out.println(Arrays.toString(topKMax(arr, 4)));
        System.out.println(Arrays.toString(topKMin(arr, 4)));
        System.out.println(Arrays.toString(arr));
        //quickSelectTopK(arr,4);
        System.out.println(Arrays.toString(quickSelectTopK(arr,4)));
        //System.out.println(quickSelect(arr,0,arr.length-1,4));
    }
}
