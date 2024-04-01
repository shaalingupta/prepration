
import java.util.*;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 */

public class MinimumRemoveToMakeValidParantheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                count++;
            } else if (ch == ')') {
                if (count == 0){
                    continue;
                }
                count--;
            }
            sb.append(ch);
        }

        StringBuilder res = new StringBuilder();
        int openCount = 0;
        for(int i=sb.length()-1; i>=0; --i){
            if (sb.charAt(i)=='('){
                if (openCount < count){
                    openCount++;
                    continue;
                }
            }
            res.append(sb.charAt(i));
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "())()(((";
        MinimumRemoveToMakeValidParantheses m = new MinimumRemoveToMakeValidParantheses();
        System.out.println(m.minRemoveToMakeValid(s));
    }
}
