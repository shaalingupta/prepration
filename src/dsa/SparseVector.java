package dsa;

import java.util.*;

/**
 * Given two sparse vectors, compute their dot product.
 *
 * Implement class SparseVector:
 *
 * SparseVector(nums) Initializes the object with the vector nums
 * dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
 * A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently
 * and compute the dot product between two SparseVector.
 *
 * Follow up: What if only one of the vectors is sparse?
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
 * Output: 8
 * Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
 * v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
 * Example 2:
 *
 * Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
 * Output: 0
 * Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
 * v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
 * Example 3:
 *
 * Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
 * Output: 6
 *
 *
 * Constraints:
 *
 * n == nums1.length == nums2.length
 * 1 <= n <= 10^5
 * 0 <= nums1[i], nums2[i] <= 100
 */
public class SparseVector {

    /**
     *
     * Naive solution where ignoring the sparsity of the vector, TC : O(n)
     * But this is not what question is asking
     *
    int[] nums;
    SparseVector(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct_IgnoreSparsityOfArray(SparseVector vec) {
        int sum = 0;
        int i = 0, j = 0;
        while(i < nums.length && j < vec.nums.length){
            sum += nums[i++]*vec.nums[j++];
        }
        return sum;
    }
 */

    /**
     *
     * // store index in a map based solution, problem is for a large size of array map will exhaust its buckets and may cause collisions, TC :: O(n) for creating list and for dot product O(l)
     * // where Let n be the length of the input array and L be the number of non-zero elements.
     *
    Map<Integer, Integer> map;

    SparseVector(int[] nums){
        this.map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct_UsingHashMap(SparseVector vec){
        int res = 0;

        for(Integer i : this.map.keySet()){
            if(vec.map.containsKey(i)){
                res += this.map.get(i) * vec.map.get(i);
            }
        }
        return res;
    }

     */


    /**
     *
     * //List of Pairs solution, Time complexity -> O(L1 + L2) to create list and calculating dot product
     *
     * //where Let n be the length of the input array and L be the number of non-zero elements.
    class Pair{
        int index;
        int val;

        Pair(int index, int val){
            this.index = index;
            this.val = val;
        }
    }

    List<Pair> list;

    SparseVector(int[] nums) {
        list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                list.add(new Pair(i, nums[i]));
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct_ListOfPairs(SparseVector vec) {
        int sum = 0;
        int i = 0, j = 0;
        while (i < this.list.size() && j < vec.list.size()){
            if(this.list.get(i).index == vec.list.get(j).index){
                sum += list.get(i).val * vec.list.get(j).val;
                i++;
                j++;
            }else if(list.get(i).index > vec.list.get(j).index){
                j++;
            }else {
                i++;
            }
        }
        return sum;
    }

*/


    // We will modify the above solution by doing binary search when the index is not matching to find next matching index,
    // this will make the Time Complexity as O(min(m, n) * log(max(m, n)) where m is size of first list and n is size of second list of non-zero elements
    class Pair{
        int index;
        int val;

        Pair(int index, int val){
            this.index = index;
            this.val = val;
        }
    }

    List<Pair> list;

    SparseVector(int[] nums) {
        this.list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                list.add(new Pair(i, nums[i]));
            }
        }
    }

    /**
     *
     * Optimized version wiht binary search to find the next index

    // Return the dotProduct of two sparse vectors
    public int dotProduct_ListOfPairs_BinarySearchOnBoth(SparseVector vec) {
        int sum = 0;
        int i = 0, j = 0;
        while(i < this.list.size() && j < vec.list.size()){
            if (this.list.get(i).index == vec.list.get(j).index){
                sum += this.list.get(i).val * vec.list.get(j).val;
                i++;
                j++;
            }else if(this.list.get(i).index > vec.list.get(j).index){
                j = binarySearch(vec.list, this.list.get(i).index);
            }else{
                i = binarySearch(this.list, vec.list.get(j).index);
            }
        }
        return sum;
    }

    private int binarySearch(List<Pair> list, int target){
        int low = 0, high = list.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(list.get(mid).index == target){
                return mid;
            }else if (list.get(mid).index < target){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return low;
    }

     */

    //This is more optimized as running BinarySearch only on the smaller matrix, rather than on both, this will require binary search only once
    public int dotProduct_ListOfPairs_BinarySearchOnSmallSizeArray(SparseVector vec){
        int sum = 0;
        int j = 0;
        List<Pair> a = this.list;
        List<Pair> b = vec.list;

        if(a.size() > b.size()){
            List<Pair> temp = a;
            a = b;
            b = temp;
        }

        for(Pair curr : a){
            int i = curr.index;
            int val = curr.val;
            int index = binarySearch(b, j, b.size()-1, i);
            if(index != -1){
                sum += val * b.get(index).val;
                j = index+1;
            }
        }
        return sum;
    }

    private int binarySearch(List<Pair> list, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(list.get(mid).index == target){
                return mid;
            }else if (list.get(mid).index < target){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] nums1 = {1,0,0,2,3};
        int[] nums2 = {0,3,0,4,0};
         SparseVector v1 = new SparseVector(nums1);
         SparseVector v2 = new SparseVector(nums2);

         //int ans = v1.dotProduct_IgnoreSparsityOfArray(v2);
        //int ans = v1.dotProduct_UsingHashMap(v2);
//        int ans = v1.dotProduct_ListOfPairs(v2);
        int ans = v1.dotProduct_ListOfPairs_BinarySearchOnSmallSizeArray(v2);
        System.out.println(ans);
    }
}


/***
 *
 * I got this question today on my FB interview.
 * I proposed the Hash solution, and he asked the downside to it.
 * I responded with large size of sparse vectors, hash collisions will occur when we hit memory allocation limits, etc.
 * He asked alternative solutions and I proposed array of (index, value) pair. He asked me to code that.
 * Then he added a constraint where one vector is considerably smaller than the other, and asked if we can improve the time complexity from O(m+n).
 * After some scratching around, I told them that we can by doing binary-search of small vector's index over the larger one.
 * This should improve the time-complexity. Was not sure of the exact Big Oh, but it should be better than m * log(n),
 * since the search space should keep reducing from n. Fingers crossed for the results
 *
 *
 *
 *
 *
 * smaller or larger does not make them less or more sparse.
 * For example, a vector could have 1 billion numbers, out of which only 10 million are non zeroes.
 * This would be a very large list and still sparse vector. In a hash table, a common issue is hash collision.
 * Typically we reduce collision by over allocating. For example, for a 10 million entry hash table, we might allocate
 * memory for say 13 million entries based on 0.75% load factor. When we hash such large lists (I know 10 million ints is not really that large,
 * but there are other items in memory and imagine many such parallel calculations being done) ,
 * we may start hitting memory limits so over allocating gets difficult, and we get too many hash collisions.
 * Smaller in the context meant (and the interviewer gave me some similar numbers),
 * 1 vector was 1 billion numbers and the other vector had only 1 million or less entries
 *
 */