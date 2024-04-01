
import org.junit.Assert;

import java.util.*;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */

public class ValidPalindromeII {

    private boolean checkPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0, j = s.length()-1;

        while (i <= j){
            if(s.charAt(i)!=s.charAt(j)){
                return checkPalindrome(s, i, j-1) || checkPalindrome(s,i+1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII vp = new ValidPalindromeII();
        Assert.assertEquals(true, vp.validPalindrome("abca"));
        Assert.assertEquals(false, vp.validPalindrome("abc"));
        Assert.assertEquals(true, vp.validPalindrome("aba"));
        Assert.assertEquals(true, vp.validPalindrome("abbca"));
    }
}
