package dsa;

import java.util.*;

/**
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * Example 2:
 *
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 *
 *
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights){
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        right[n-1] = n;
        left[0] = -1;
        int maxArea = 0;

        for (int i=n-2; i>=0; --i){
            int p = i+1;
            while (p < n && heights[p] >= heights[i]){
                p = right[p];
            }
            right[i] = p;
        }

        for(int i=1; i<n; i++){
            int p = i-1;
            while (p >= 0 && heights[p] >= heights[i]){
                p = left[p]; // apne pehele wale se puch ki bhai tu kya mujhse bada h chota h ya barabar h agar chota h
                // toh bhai tu hi meri boundary h nhe toh teri boundary bata me waha ja kr puchunga, uski boundary pr ja
                // kr pucho ki bahi tu kya h bada chota ya barabar and repeat
            }
            left[i] = p;
        }

        for (int i=0; i<n; i++){
            int area = heights[i] * (right[i] - left[i] - 1);
            if (maxArea < area){
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
        int[] num1 = {1,1};
        int[] num2 = {2,1,5,6,2,3};
        System.out.println(lr.largestRectangleArea(num2));
        System.out.println(lr.largestRectangleArea(num1));
    }
}
