package dsa;

import java.util.*;

/**
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * Example 2:
 *
 * Input: matrix = [['0']]
 * Output: 0
 * Example 3:
 *
 * Input: matrix = [['1']]
 * Output: 1
 *
 *
 * Constraints:
 *
 * rows == matrix.length
 * cols == matrix[i].length
 * 1 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 *
 */

//O(NM).Time,
// O(M) space

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix){
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0; // yeh important h kyuki jab value 0 h toh uss time rectangle nhe banegaisliye sirf jab 1 h toh heights array me add karnege nhe toh 0 rakhenge
            }
            maxArea = Math.max(maxArea, lr.largestRectangleArea(heights));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaximalRectangle m = new MaximalRectangle();
        System.out.println(m.maximalRectangle(matrix));
        matrix = new char[][]{{'0'}};
        System.out.println(m.maximalRectangle(matrix));
        matrix = new char[][]{{'1', '0'}, {'0', '1'}};
        System.out.println(m.maximalRectangle(matrix));
    }
    
}
