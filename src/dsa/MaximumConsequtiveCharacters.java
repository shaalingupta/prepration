package dsa;

import java.util.*;

/**
 * Given a string s, return a list containing the maximum consecutive characters in the string, preserving the order of appearance.
 * If there are no consecutive characters, return the string split into individual characters.
 *
 * Input: s = "This is a string"
 * Output: ['T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 's', 't', 'r', 'i', 'n', 'g']
 * Explanation: No characters appear consecutively.
 *
 *
 * Input: s = "Thiss is aa ssttrring"
 * Output: ["ss", "aa", "ss", "tt", "rr"]
 * Explanation: Consecutive characters are 'ss', 'aa', 'ss', 'tt', 'rr'.
 *
 * Input: s = "Thiss s snnake elephant trunk"
 * Output: ["ssss"]
 * Explanation: The consecutive characters with the maximum length are 'ssss'.
 *
 *
 * Input: s = "aa aaa aaaaa aaaaaaa"
 * Output: ["aaaaaaaaaaaaaaaaa"]
 * Explanation: The consecutive characters with the maximum length are 'aaaaaaaaaaaaaaaaa'.
 *
 */
public class MaximumConsequtiveCharacters {
    public List<String> maxConsequtiveString(String s){
        int maxLength = Integer.MIN_VALUE;
        List<String> ans = new ArrayList<>();

        int j = 0;
        for(int i=0; i<s.length()-1; i++){
            if (s.charAt(i) != ' '){
                if (s.charAt(i) == s.charAt(i+1)){
                    continue;
                }

                if (i - j + 1 > maxLength){
                    maxLength = Math.max(maxLength, i-j+1);
                    ans.clear();
                    ans.add(s.substring(j, i+1));
                }else if(i - j + 1 == maxLength){
                    ans.add(s.substring(j, i+1));
                }
            }
            j = i+1;
        }
        if (s.length() - j > maxLength){
            ans.clear();
            ans.add(s.substring(j, s.length()));
        }else if(s.length() - j == maxLength){
            ans.add(s.substring(j, s.length()));
        }
        return ans;
    }

    public List<String> maxConsequtiveStringII(String s){

        int maxLength = Integer.MIN_VALUE;
        List<String> ans = new ArrayList<>();
        char lastChar = ' '; // initialization purpose
        int j = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                j++; continue;
            }
            else {
                if (s.charAt(i) == lastChar)
                    continue;
            }
            if (i - j + 1 > maxLength){
                maxLength = Math.max(maxLength, i-j+1);
                ans.clear();
                ans.add(String.valueOf(lastChar).repeat(i-j+1));
            }else if(i - j + 1 == maxLength){
                ans.add(String.valueOf(lastChar).repeat(i-j+1));
            }
            lastChar = s.charAt(i);
            j = i+1;
        }
        if (s.length() - j + 1 > maxLength){
            maxLength = Math.max(maxLength, s.length()-j+1);
            ans.clear();
            ans.add(String.valueOf(lastChar).repeat(s.length()-j+1));
        }else if(s.length() - j + 1 == maxLength){
            ans.add(String.valueOf(lastChar).repeat(s.length()-j+1));
        }
        return ans;
    }


    public static void main(String[] args) {
        MaximumConsequtiveCharacters maxCC = new MaximumConsequtiveCharacters();
        List<String> res = maxCC.maxConsequtiveStringII("This is a string"); //T h i s i s a s t r i n g
        print(res);
        res = maxCC.maxConsequtiveStringII("Thiss iss aa stringg"); //ss ss aa gg
        print(res);
       res = maxCC.maxConsequtiveStringII("aa aaa aaaa aaaaa"); //aaaaaaaaaaaaaa
        print(res);
    }

    private static void print(List<String> res) {
        res.forEach(i -> System.out.print(i+" "));
        System.out.println();
    }
}
