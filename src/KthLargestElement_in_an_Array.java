
import java.util.*;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class KthLargestElement_in_an_Array {
    public int findKthLargest_nlogk(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * Counting sort, get maxnum in nums,
     * create a list of elements of size maxnum say freq
     * add freq of elements in array freq
     * now create a new sorted array by iterating freq array
     * return kth element from sorted array.
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k){
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        for(int i : nums){
            maxNum = Math.max(maxNum, i);
            minNum = Math.min(minNum, i);
        }

        int[] freq = new int[maxNum - minNum + 1];
        for(int num : nums){
            freq[num-minNum]++;
        }

        System.out.println(Arrays.toString(freq));

        int j = 0;
        for(int i=0; i<freq.length; i++){
            int temp = freq[i];
            while(temp > 0){
                nums[j++] = i+minNum;
                temp--;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[nums.length-k];
    }


    public static void main(String[] args) {
        KthLargestElement_in_an_Array ele = new KthLargestElement_in_an_Array();
        int[] num = {3,2,1,5,6,4};
        System.out.println(ele.findKthLargest(num, 2));
    }
}
