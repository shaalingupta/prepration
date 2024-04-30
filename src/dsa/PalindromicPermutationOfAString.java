package dsa;



import java.util.*;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 *
 * You may return the answer in any order. If s has no palindromic permutation, return an empty list.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aabb"
 * Output: ["abba","baab"]
 * Example 2:
 *
 * Input: s = "abc"
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s consists of only lowercase English letters.
 *
 */
public class PalindromicPermutationOfAString {

    List<String> res = new ArrayList<>();
    public List<String> generatePalindromeII(String s){
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

        int oddCount = 0;
        Character odd = null;
        int length = 0;

        for(char ch : freqMap.keySet()){
            int freq = freqMap.get(ch);

            if (freq % 2 == 1){
                odd = ch;
                oddCount++;
            }
            freqMap.put(ch, freq/2); //as we are only forming half-length of string
            length += freq/2;
        }

        if (oddCount > 1){
            return Collections.emptyList();
        }

        generatePalindrome(1, length, freqMap, odd, "");

        return res;
    }

    private void generatePalindrome(int i, int length, Map<Character, Integer> freqMap, Character odd, String s) {
        if (i > length){
            String rev = "";
            for(int j=s.length()-1; j>=0; --j){ //put reverse string
                rev += s.charAt(j);
            }
            if(odd != null){
                rev+=odd; //if odd is there add it
            }
            rev += s; //append the other half
            res.add(rev);
            return;
        }

        for(char ch : freqMap.keySet()){
            int freq = freqMap.get(ch);
            if (freq > 0){
                freqMap.put(ch, freq-1);
                generatePalindrome(i+1, length, freqMap, odd, s+ch);
                freqMap.put(ch, freq); // putting freq back to original
            }
        }
    }

    public static void main(String[] args) {
        PalindromicPermutationOfAString ps = new PalindromicPermutationOfAString();
        List<String> res = ps.generatePalindromeII("abababab");
        res.forEach(i -> System.out.println(i));
    }
}
