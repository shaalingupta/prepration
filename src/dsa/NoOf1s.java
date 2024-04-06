package dsa;

/**
 *
 * Design an API getOne(start_idx, end_idx) which will return the number of 1's between the two indices from an
 * array consisting of only 0's and 1's eg: [0,1,1,0,0,0,1,1] The call should be completed in constant time.
 *
 */

/**
 *
 * The "prefix sum" array is good and should work. Note that the prefix sum array should have one more element than the original array.
 *
 * If original array a is indexed from 0 to n-1, then prefix-sum array s should be indexed from 0 to n, with s[k] equal to sum of first k elements:
 * s[0] = 0 and s[k] = a[0] + ... + a[k-1]. Then the sum of subarray start,end is equal to s[end+1]-s[start].
 *
 */

public class NoOf1s {
    public int getOne(int[] nums, int start, int end){
        int[] prefixsum = new int[nums.length];
        prefixsum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }

        int oneBeforeStart = (start > 0) ? prefixsum[start-1] : 0;
        return prefixsum[end] - oneBeforeStart;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 0, 0, 1, 1};
        NoOf1s no = new NoOf1s();
        System.out.println(no.getOne(arr, 2, 6));
        System.out.println(no.getOne(arr, 0, 7));
    }
}
