package dsa;

import java.util.*;

/**
 *
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 * Constraints:
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 *
 */

public class EditDistance {
    public int minDistance_Recursion(String word1, String word2) {
        return recursion(word1, word2, word1.length(), word2.length());  //Time Complexity = O(3^N), N is Max(word1.length(), word2.length()), and Space is O(N)
    }

    private int recursion(String word1, String word2, int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;
        if (word1.charAt(i-1) == word2.charAt(j-1)){
            return recursion(word1, word2, i-1, j-1);
        } else {
            int insert = recursion(word1, word2, i, j-1); //as we have inserted in word1 so the length increase so pointer will remain at same position but for word2 the pointer will move
            int delete = recursion(word1, word2, i-1, j); // as we have deleted in word1 so the pointer will move but for word2 pointer will remain to match next char of word 2
            int replace = recursion(word1, word2, i-1, j-1); //we replaced so move both pointers

            return Math.max(insert, Math.min(delete, replace))+1;
        }
    }

    Integer memo[][];
    public int minDistance_Memoization(String word1, String word2){
        this.memo = new Integer[word1.length()+1][word2.length()+1]; //Time and Space : O(m*n), length is +1 because to consider empty string
        return recursionWithMemo(word1, word2, word1.length(), word2.length());
    }

    private int recursionWithMemo(String word1, String word2, int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;
        if (memo[i][j] != null)
            return memo[i][j];
        int minDistance = 0;
        if (word1.charAt(i-1) == word2.charAt(j-1)){
            minDistance = recursionWithMemo(word1, word2, i-1, j-1);
        }else {
            int insert = recursionWithMemo(word1, word2, i, j-1);
            int delete = recursionWithMemo(word1, word2, i-1, j);
            int replace = recursionWithMemo(word1, word2, i-1, j-1);

            minDistance = Math.min(insert, Math.min(delete, replace))+1;
        }
        memo[i][j] = minDistance;
        return minDistance;
    }


    public int minDistance_bottomUp(String word1, String word2){ //TC, SC :: O(M*N)
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int i=0; i<=word1.length(); i++){
            for (int j=0; j<=word2.length(); j++){
                if (i == 0){
                    dp[0][j] = j;
                } else if (j == 0){
                    dp[i][0] = i;
                } else if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }


    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance_bottomUp("horse", "ros"));
    }
}
