
import java.util.*;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i)-'a'] = i;
        }

        List<Integer> res = new ArrayList<>();

        int prev = -1;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            max = Math.max(max, map[s.charAt(i)-'a']);
            if(i == map[s.charAt(i)-'a']){
                res.add(max-prev);
                prev = i;
            }
        }
        return res;
    }
}
