package dsa;

import java.util.*;

/**
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.
 *
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 *
 * Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
 * Output: [[2,2],[4,49],[51,74],[76,99]]
 * Explanation: The ranges are:
 * [2,2]
 * [4,49]
 * [51,74]
 * [76,99]
 * Example 2:
 *
 * Input: nums = [-1], lower = -1, upper = -1
 * Output: []
 * Explanation: There are no missing ranges since there are no missing numbers.
 *
 *
 * Constraints:
 *
 * -109 <= lower <= upper <= 109
 * 0 <= nums.length <= 100
 * lower <= nums[i] <= upper
 * All the values of nums are unique.
 *
 *
 */
public class MissingRanges {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] > lower){
                res.add(Arrays.asList(lower, nums[i]-1));
            }
            lower = nums[i]+1;
        }
        if(lower <= upper){
            res.add(Arrays.asList(lower, upper));
        }
        return res;
    }


    /**
     *
     * Variation
     *
     * Problem:
     * Given a sorted integer array nums, return the missing ranges in ascending order.
     * If the number of missing numbers between two consecutive elements is less than or equal to 2,
     * append them individually; otherwise, append the range of missing numbers.
     *
     * Example:
     * Input: nums = [0, 1, 4, 50, 75], lower = 0, upper = 99
     *
     * Output: ["2", "4->49", "51->74", "76->99"]
     *
     * Explanation:
     * Between 1 and 3, there is only one missing number (2), so it is appended individually.
     * Between 3 and 50, there are 46 missing numbers, so the range of missing numbers is appended as "4->49".
     * Similarly, ranges "51->74" and "76->99" are appended.
     */
    public List<List<Integer>> findMissingRangesII(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] > lower){
                if (nums[i] - lower == 1){
                    res.add(Arrays.asList(lower));
                }else if (nums[i] - lower <= 2){
                    res.add(Arrays.asList(lower));
                    res.add(Arrays.asList(nums[i]-1));
                } else {
                    res.add(Arrays.asList(lower, nums[i] - 1));
                }
            }
            lower = nums[i]+1;
        }
        if(lower <= upper){
            res.add(Arrays.asList(lower, upper));
        }
        return res;
    }


    public List<List<Integer>> findMissingRangesIII(int[] nums, int lower, int upper, int k) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] > lower){
                if (nums[i] - lower <= k){
                    int temp = lower;
                    while(temp < nums[i]){
                        res.add(Arrays.asList(temp++));
                    }
                }else {
                    res.add(Arrays.asList(lower, nums[i] - 1));
                }
            }
            lower = nums[i]+1;
        }
        if(lower <= upper){
            res.add(Arrays.asList(lower, upper));
        }
        return res;
    }

    public static void main(String[] args) {
        MissingRanges missingRanges = new MissingRanges();
        int[] arr = {0, 1, 4, 50, 75};
        int lower = 0, upper = 99;
        List<List<Integer>> output = missingRanges.findMissingRangesIII(arr, lower, upper, 2);
        printList(output);
        arr = new int[]{-1};
        lower = -1; upper = -1;
        output = missingRanges.findMissingRangesII(arr, lower, upper);
        printList(output);
        arr = new int[]{};
        lower = 1; upper = 1;
        output = missingRanges.findMissingRangesII(arr, lower, upper);
        printList(output);
    }

    private static void printList(List<List<Integer>> output) {
        for (List<Integer> list : output){
            list.forEach(i -> System.out.print(i+" "));
            System.out.println();
        }
    }
}


